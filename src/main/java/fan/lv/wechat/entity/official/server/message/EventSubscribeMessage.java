package fan.lv.wechat.entity.official.server.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户未关注时，进行关注后的事件
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@XStreamAlias("xml")
@Data
public class EventSubscribeMessage extends BaseEventMessage {
    /**
     * 事件类型: subscribe(订阅)
     */
    @XStreamAlias("Event")
    @JsonProperty("Event")
    String event = "subscribe";

    /**
     * 事件KEY值，是一个32位无符号整数，即创建二维码时的二维码scene_id
     */
    @XStreamAlias("EventKey")
    @JsonProperty("EventKey")
    String eventKey;


    /**
     * 二维码的ticket，可用来换取二维码图片
     */
    @XStreamAlias("Ticket")
    @JsonProperty("Ticket")
    String ticket;
}
