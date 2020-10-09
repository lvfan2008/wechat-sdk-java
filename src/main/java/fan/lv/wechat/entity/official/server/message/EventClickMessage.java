package fan.lv.wechat.entity.official.server.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 自定义菜单事件
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@XStreamAlias("xml")
@Data
public class EventClickMessage extends BaseEventMessage {
    /**
     * 事件类型
     */
    @XStreamAlias("Event")
    @JsonProperty("Event")
    String event = "CLICK";

    /**
     * 事件KEY值，与自定义菜单接口中KEY值对应
     */
    @XStreamAlias("EventKey")
    @JsonProperty("EventKey")
    String eventKey;
}
