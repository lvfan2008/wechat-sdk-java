package fan.lv.wechat.api.official.server;

import fan.lv.wechat.entity.official.server.message.*;

/**
 * 公众号或小程序服务
 *
 * @author lv_fan2008
 */
public interface ServerService {
    /**
     * 服务消息处理
     *
     * @param signature GET参数signature
     * @param timestamp GET参数timestamp
     * @param nonce     GET参数nonce
     * @param echoStr   GET参数echostr
     * @param xmlBody   POST字符串
     * @return 回复的消息
     */
    String serv(String signature, String timestamp, String nonce, String echoStr, String xmlBody);

    /**
     * 添加消息回调
     *
     * @param messageCallback
     */
    ServerService messageCallback(MessageCallback messageCallback);

    /**
     * 注册事件类型对应类
     *
     * @param msgType          消息类型
     * @param event            事件名，msgType=event时有效
     * @param messageClassType 对应字段类型
     */
    void registerMessageType(String msgType, String event, Class<? extends BaseReceiveMessage> messageClassType);
}
