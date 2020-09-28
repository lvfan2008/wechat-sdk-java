package fan.lv.wechat.entity.official.server.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 事件消息基类
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BaseEventMessage extends BaseReceiveMessage {
    /**
     * 消息类型
     */
    @XStreamAlias("MsgType")
    String msgType = "event";

    /**
     * 事件类型
     */
    @XStreamAlias("Event")
    String event;
}
