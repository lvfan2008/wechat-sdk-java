package fan.lv.wechat.api.open.service;

import fan.lv.wechat.entity.open.open.message.WxBaseMessage;

/**
 * 第三方平台消息回调
 *
 * @author lv_fan2008
 */
public interface OpenMessageCallback {
    /**
     * 处理消息
     *
     * @param message 收到的消息
     * @return 返回回复消息
     */
    String handle(WxBaseMessage message);
}
