package fan.lv.wechat.api.official.server.impl;

import fan.lv.wechat.api.official.server.MessageCallback;
import fan.lv.wechat.api.official.server.ServerService;
import fan.lv.wechat.entity.official.server.message.*;
import fan.lv.wechat.util.JsonUtil;
import fan.lv.wechat.util.SignUtil;
import fan.lv.wechat.util.SimpleMap;
import fan.lv.wechat.util.XmlUtil;
import fan.lv.wechat.util.crpto.AesException;
import fan.lv.wechat.util.crpto.SHA1;
import fan.lv.wechat.util.crpto.WxBizMsgCrypt;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
     * 是否数据格式为Json格式，默认为Xml格式
     */
    protected Boolean isBodyJson = false;

    /**
     * 事件消息对应类,key=msgType:event
     */
    protected Map<String, Class<? extends BaseReceiveMessage>> msgTypeMap =
            new SimpleMap<String, Class<? extends BaseReceiveMessage>>()
                    .add("text", CommonTextMessage.class)
                    .add("image", CommonImageMessage.class)
                    .add("voice", CommonVoiceMessage.class)
                    .add("video", CommonVideoMessage.class)
                    .add("link", CommonLinkMessage.class)
                    .add("location", CommonLocationMessage.class)
                    .add("shortvideo", CommonShortVideoMessage.class)
                    .add("event:subscribe", EventSubscribeMessage.class)
                    .add("event:SCAN", EventScanMessage.class)
                    .add("event:unsubscribe", EventUnSubscribeMessage.class)
                    .add("event:CLICK", EventClickMessage.class)
                    .add("event:VIEW", EventViewMessage.class)
                    .add("event:LOCATION", EventLocationMessage.class);

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
    public String serv(String signature, String timestamp, String nonce, String echoStr, String body) {
        log.debug("serv: {} {} {} {} {}", signature, timestamp, nonce, echoStr, body);
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
                String message = body;
                isBodyJson = body.trim().startsWith("{");
                EncryptReceiveMessage encryptReceiveMessage = isBodyJson ? JsonUtil.parseJson(body, EncryptReceiveMessage.class)
                        : XmlUtil.parseXml(body, EncryptReceiveMessage.class);
                boolean encrypt = encryptReceiveMessage.getEncrypt() != null;
                if (encrypt) {
                    if (!SignUtil.sha1(token, timestamp, nonce, encryptReceiveMessage.getEncrypt()).equals(signature)) {
                        throw new AesException(AesException.VALIDATE_SIGNATURE_ERROR);
                    }
                    message = crypt.decrypt(encryptReceiveMessage.getEncrypt());
                }
                log.debug("decryptMsg: {}", message);
                reply = processMessage(message);
                log.debug("processMessage reply: {}", reply);
                if (encrypt && reply != null) {
                    reply = encryptMsg(crypt, reply, nonce);
                }
            }
            reply = reply == null ? "success" : reply;
        } catch (AesException e) {
            log.error("param: {} {} {} {} {}, AesException:{}", signature, timestamp, nonce, echoStr, body, e.getMessage());
            return "success";
        }
        return reply;
    }

    /**
     * 加密回复消息
     *
     * @param crypt    加解密实例
     * @param replyMsg 回复消息
     * @param nonce    随机串
     * @return 加密后的字符串
     * @throws AesException 异常
     */
    protected String encryptMsg(WxBizMsgCrypt crypt, String replyMsg, String nonce) throws AesException {
        // 加密
        String encrypt = crypt.encrypt(crypt.getRandomStr(), replyMsg);
        String timeStamp = Long.toString(System.currentTimeMillis());
        String signature = SHA1.getSha1(token, timeStamp, nonce, encrypt);
        EncryptReplyMessage encryptReplyMessage = new EncryptReplyMessage(encrypt, signature, timeStamp, nonce);
        return isBodyJson ? JsonUtil.toJson(encryptReplyMessage) : XmlUtil.toXml(encryptReplyMessage);
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
     * @param message 原始Message
     * @return 返回回复信息
     */
    protected String processMessage(String message) {
        BaseReceiveMessage baseReceiveMessage = isBodyJson ? JsonUtil.parseJson(message, BaseReceiveMessage.class)
                : XmlUtil.parseXml(message, BaseReceiveMessage.class);
        Class<? extends BaseReceiveMessage> type = getMessageTypeValue(baseReceiveMessage.getMsgType(), baseReceiveMessage.getEvent());
        BaseReceiveMessage realMessage = baseReceiveMessage;
        if (type != null) {
            realMessage = isBodyJson ? JsonUtil.parseJson(message, type) : XmlUtil.parseXml(message, type);
        }
        realMessage.setOriginMessage(message);
        for (MessageCallback callback : callbackList) {
            BaseReplyMessage result = callback.handle(realMessage);
            if (result != null) {
                result.setToUserName(realMessage.getFromUserName());
                if (StringUtils.isEmpty(result.getFromUserName())) {
                    result.setFromUserName(realMessage.getToUserName());
                }
                return isBodyJson ? JsonUtil.toJson(result) : XmlUtil.toXml(result);
            }
        }
        return null;
    }
}
