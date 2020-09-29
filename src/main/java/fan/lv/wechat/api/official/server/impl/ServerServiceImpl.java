package fan.lv.wechat.api.official.server.impl;

import com.google.common.collect.ImmutableMap;
import fan.lv.wechat.api.official.server.MessageCallback;
import fan.lv.wechat.api.official.server.ServerService;
import fan.lv.wechat.entity.official.server.message.*;
import fan.lv.wechat.util.XmlUtil;
import fan.lv.wechat.util.crpto.AesException;
import fan.lv.wechat.util.crpto.SHA1;
import fan.lv.wechat.util.crpto.WxBizMsgCrypt;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * 公众号或小程序服务回调
 *
 * @author lv_fan2008
 */
@Slf4j
public class ServerServiceImpl implements ServerService {

    /**
     * 加密Aes密钥
     */
    protected String encodingAesKey;

    /**
     * 凭证
     */
    protected String token;

    /**
     * appId
     */
    protected String appId;

    /**
     * 事件消息对应类,key=msgType:event
     */
    protected Map<String, Class<? extends BaseReceiveMessage>> msgTypeMap =
            new ImmutableMap.Builder<String, Class<? extends BaseReceiveMessage>>()
                    .put("text", CommonTextMessage.class)
                    .put("image", CommonImageMessage.class)
                    .put("voice", CommonVoiceMessage.class)
                    .put("video", CommonVideoMessage.class)
                    .put("link", CommonLinkMessage.class)
                    .put("location", CommonLocationMessage.class)
                    .put("shortvideo", CommonShortVideoMessage.class)
                    .put("event:subscribe", EventSubscribeMessage.class)
                    .put("event:SCAN", EventScanMessage.class)
                    .put("event:unsubscribe", EventUnSubscribeMessage.class)
                    .put("event:CLICK", EventClickMessage.class)
                    .put("event:VIEW", EventViewMessage.class)
                    .put("event:LOCATION", EventLocationMessage.class)
                    .build();

    /**
     * 消息回调列表
     */
    protected List<MessageCallback> callbackList = new ArrayList<>();

    /**
     * 构造函数
     *
     * @param encodingAesKey 加密Aes密钥
     * @param token          凭证
     * @param appId          公众号标识
     */
    public ServerServiceImpl(String encodingAesKey, String token, String appId) {
        this.encodingAesKey = encodingAesKey;
        this.token = token;
        this.appId = appId;
    }


    @Override
    public String serv(String signature, String timestamp, String nonce, String echoStr, String xmlBody) {
        log.debug("serv: {} {} {} {} {}", signature, timestamp, nonce, echoStr, xmlBody);
        WxBizMsgCrypt crypt;
        String reply = null;
        try {
            crypt = new WxBizMsgCrypt(token, encodingAesKey, appId);
            if (!StringUtils.isEmpty(echoStr)) {
                String calSig = SHA1.getSha1(token, timestamp, nonce, "");
                if (calSig.equals(signature)) {
                    reply = echoStr;
                }
            } else {
                String xmlMessage = xmlBody;
                boolean encrypt = xmlBody.contains("<Encrypt>");
                if (encrypt) {
                    xmlMessage = crypt.decryptMsg(signature, timestamp, nonce, xmlBody);
                }
                log.debug("decryptMsg: {}", xmlMessage);
                reply = processMessage(xmlMessage);
                log.debug("processMessage reply: {}", reply);
                if (encrypt) {
                    reply = crypt.encryptMsg(reply, "", nonce);
                }
            }
            reply = reply == null ? "success" : reply;
        } catch (AesException e) {
            log.error("param: {} {} {} {} {}, AesException:{}", signature, timestamp, nonce, echoStr, xmlBody, e.getMessage());
            return "success";
        }
        return reply;
    }

    @Override
    public ServerService messageCallback(MessageCallback messageCallback) {
        this.callbackList.add(messageCallback);
        return this;
    }

    @Override
    public void registerMessageType(String msgType, String event, Class<? extends BaseReceiveMessage> messageClassType) {
        String key = getMessageTypeKey(msgType, event);
        msgTypeMap.put(key, messageClassType);
    }

    private String getMessageTypeKey(String msgType, String event) {
        return msgType + ("event".equals(msgType) && !StringUtils.isEmpty(event) ? ":" + event : "");
    }

    private Class<? extends BaseReceiveMessage> getMessageTypeValue(String msgType, String event) {
        String key = getMessageTypeKey(msgType, event);
        return msgTypeMap.get(key);
    }


    /**
     * 处理回调消息
     *
     * @param xmlMessage 原始Message
     * @return 返回回复信息
     */
    protected String processMessage(String xmlMessage) {
        BaseReceiveMessage message = (BaseReceiveMessage) XmlUtil.parseXml(xmlMessage, BaseReceiveMessage.class);
        Class<? extends BaseReceiveMessage> type = getMessageTypeValue(message.getMsgType(), message.getEvent());
        Object realMessage = XmlUtil.parseXml(xmlMessage, type);
        for (MessageCallback callback : callbackList) {
            BaseReplyMessage result = callback.handle(type.cast(realMessage));
            if (result != null) {
                result.setToUserName(message.getFromUserName());
                if (StringUtils.isEmpty(result.getFromUserName())) {
                    result.setFromUserName(message.getToUserName());
                }
                return XmlUtil.toXml(result);
            }
        }
        return null;
    }
}
