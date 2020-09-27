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
@XStreamAlias("xml")
@Data
public class BaseReceiveMessage extends BaseMessage {
    /**
     * 消息类型
     */
    @XStreamAlias("MsgType")
    String msgType;

    /**
     * 事件类型，默认为null，多加这个字段是为了兼容处理
     */
    @XStreamAlias("Event")
    String event;
}
