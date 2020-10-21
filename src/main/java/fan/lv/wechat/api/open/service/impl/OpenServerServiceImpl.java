package fan.lv.wechat.api.open.service.impl;

import fan.lv.wechat.api.official.server.ServerService;
import fan.lv.wechat.api.official.server.impl.ServerServiceImpl;
import fan.lv.wechat.api.open.service.OpenMessageCallback;
import fan.lv.wechat.api.open.service.OpenServerService;
import fan.lv.wechat.entity.open.open.message.*;
import fan.lv.wechat.util.SignUtil;
import fan.lv.wechat.util.SimpleMap;
import fan.lv.wechat.util.XmlUtil;
import fan.lv.wechat.util.crpto.AesException;
import fan.lv.wechat.util.crpto.WxBizMsgCrypt;
import fan.lv.wechat.util.pay.WxPayUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 开放平台服务回调
 *
 * @author lv_fan2008
 */
@Slf4j
public class OpenServerServiceImpl implements OpenServerService {

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
    protected Map<String, Class<? extends WxBaseMessage>> msgTypeMap =
            new SimpleMap<String, Class<? extends WxBaseMessage>>()
                    .add("authorized", WxAuthorizedMessage.class)
                    .add("component_verify_ticket", WxComponentVerifyTicketMessage.class)
                    .add("unauthorized", WxUnAuthorizedMessage.class)
                    .add("updateauthorized", WxUpdateAuthorizedMessage.class);

    /**
     * 消息回调列表
     */
    protected List<OpenMessageCallback> callbackList = new ArrayList<>();

    /**
     * 构造函数
     *
     * @param encodingAesKey 加密Aes密钥
     * @param token          凭证
     * @param appId          公众号标识
     */
    public OpenServerServiceImpl(String encodingAesKey, String token, String appId) {
        this.encodingAesKey = encodingAesKey;
        this.token = token;
        this.appId = appId;
    }


    @Override
    public String servComponentCallback(String signature, String timestamp, String nonce, String body) {
        log.debug("open callback serv: {} {} {} {}", signature, timestamp, nonce, body);
        WxBizMsgCrypt crypt;
        String reply = null;
        try {
            crypt = new WxBizMsgCrypt(token, encodingAesKey, appId);
            Map<String, String> map = WxPayUtil.xmlToMap(body);
            if (!SignUtil.sha1(token, timestamp, nonce, map.get("Encrypt")).equals(signature)) {
                throw new AesException(AesException.VALIDATE_SIGNATURE_ERROR);
            }
            String message = crypt.decrypt(map.get("Encrypt"));
            log.debug("decryptMsg: {}", message);
            processMessage(message);
        } catch (Exception e) {
            log.error("param: {} {} {} {}, Exception:{}", signature, timestamp, nonce, body, e.getMessage());
            return "success";
        }
        return "success";
    }

    @Override
    public OpenServerService messageCallback(OpenMessageCallback openMessageCallback) {
        this.callbackList.add(openMessageCallback);
        return this;
    }


    @Override
    public OpenServerService registerMessageType(String infoType, Class<? extends WxBaseMessage> messageClassType) {
        msgTypeMap.put(infoType, messageClassType);
        return this;
    }

    private Class<? extends WxBaseMessage> getMessageTypeValue(String infoType) {
        return msgTypeMap.get(infoType);
    }

    /**
     * 处理回调消息
     *
     * @param message 原始Message
     */
    protected void processMessage(String message) throws Exception {
        WxBaseMessage msg = XmlUtil.parseXml(message, WxBaseMessage.class);
        msg.setMapResult(WxPayUtil.xmlToMap(message));
        Class<? extends WxBaseMessage> type = getMessageTypeValue(msg.getInfoType());
        WxBaseMessage realMessage = msg;
        if (type != null) {
            realMessage = XmlUtil.parseXml(message, type);
        }
        for (OpenMessageCallback callback : callbackList) {
            callback.handle(realMessage);
        }
    }
}
