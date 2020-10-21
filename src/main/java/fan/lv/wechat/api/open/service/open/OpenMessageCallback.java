package fan.lv.wechat.api.open.service.open;

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
     */
    void handle(WxBaseMessage message);
}
