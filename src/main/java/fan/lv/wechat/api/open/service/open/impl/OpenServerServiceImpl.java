package fan.lv.wechat.api.open.service.open.impl;

import fan.lv.wechat.api.open.service.open.OpenMessageCallback;
import fan.lv.wechat.api.open.service.open.OpenServerService;
import fan.lv.wechat.entity.open.config.OpenPlatformConfig;
import fan.lv.wechat.entity.open.open.message.*;
import fan.lv.wechat.util.SignUtil;
import fan.lv.wechat.util.SimpleMap;
import fan.lv.wechat.util.XmlUtil;
import fan.lv.wechat.util.crpto.AesException;
import fan.lv.wechat.util.crpto.WxBizMsgCrypt;
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
     * 开放平台配置
     */
    OpenPlatformConfig config;

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
                    .add("updateauthorized", WxUpdateAuthorizedMessage.class)
                    .add("notify_third_fasteregister", WxNotifyThirdFastRegisterMessage.class);

    /**
     * 消息回调列表
     */
    protected List<OpenMessageCallback> callbackList = new ArrayList<>();

    /**
     * 构造函数
     *
     * @param config 开放平台配置
     */
    public OpenServerServiceImpl(OpenPlatformConfig config) {
        this.config = config;
    }


    @Override
    public String servComponentCallback(String signature, String timestamp, String nonce, String body) {
        log.debug("open callback serv: {} {} {} {}", signature, timestamp, nonce, body);
        WxBizMsgCrypt crypt;
        String reply = null;
        try {
            crypt = new WxBizMsgCrypt(config.getToken(), config.getAesKey(), config.getComponentAppId());
            Map<String, String> map = XmlUtil.xmlToMap(body);
            if (!SignUtil.sha1(config.getToken(), timestamp, nonce, map.get("Encrypt")).equals(signature)) {
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
        Map<String, String> map = XmlUtil.xmlToMap(message);
        Class<? extends WxBaseMessage> type = getMessageTypeValue(map.get("InfoType"));
        WxBaseMessage realMessage;
        type = type == null ? WxBaseMessage.class : type;
        realMessage = XmlUtil.parseXml(message, type);
        realMessage.setMapResult(map);
        for (OpenMessageCallback callback : callbackList) {
            callback.handle(realMessage);
        }
    }
}
