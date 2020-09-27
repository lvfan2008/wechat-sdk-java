package fan.lv.wechat.api.official.server;

import fan.lv.wechat.entity.official.server.message.BaseReceiveMessage;
import fan.lv.wechat.entity.official.server.message.BaseReplyMessage;

/**
 * @author lv_fan2008
 */
public interface MessageCallback {
    /**
     * 处理消息
     *
     * @param message 收到的消息
     * @return 返回回复消息
     */
    BaseReplyMessage handle(BaseReceiveMessage message);
}
