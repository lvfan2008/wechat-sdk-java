package fan.lv.wechat.api.open.service;

import fan.lv.wechat.api.official.server.ServerService;
import fan.lv.wechat.entity.open.open.message.WxBaseMessage;

/**
 * 公众号或小程序服务
 *
 * @author lv_fan2008
 */
public interface OpenServerService {
    /**
     * 服务消息处理
     *
     * @param signature GET参数msg_signature
     * @param timestamp GET参数timestamp
     * @param nonce     GET参数nonce
     * @param xmlBody   POST字符串
     * @return 回复的消息
     */
    String servComponentCallback(String signature, String timestamp, String nonce, String xmlBody);

    /**
     * 添加消息回调
     *
     * @param openMessageCallback 回调
     * @return 开放平台服务端
     */
    OpenServerService messageCallback(OpenMessageCallback openMessageCallback);

    /**
     * 注册事件类型对应类
     *
     * @param infoType         事件类型
     * @param messageClassType 对应字段类型
     * @return 开放平台服务端
     */
    OpenServerService registerMessageType(String infoType, Class<? extends WxBaseMessage> messageClassType);

}
