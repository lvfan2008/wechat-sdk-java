package fan.lv.wechat.entity.official.server.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 点击菜单跳转链接时的事件推送
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@XStreamAlias("xml")
@Data
@NoArgsConstructor
public class EventViewMessage extends BaseEventMessage {
    /**
     * 事件类型
     */
    @XStreamAlias("Event")
    String event = "VIEW";

    /**
     * 事件KEY值，设置的跳转URL
     */
    @XStreamAlias("EventKey")
    String eventKey;

    public EventViewMessage(String eventKey) {
        this.eventKey = eventKey;
    }
}
