package fan.lv.wechat.entity.official.server.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 取消订阅事件
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@XStreamAlias("xml")
@Data
public class EventUnSubscribeMessage extends BaseEventMessage {
    /**
     * 事件类型: unsubscribe(取消订阅)
     */
    @XStreamAlias("Event")
    String event = "unsubscribe";
}
