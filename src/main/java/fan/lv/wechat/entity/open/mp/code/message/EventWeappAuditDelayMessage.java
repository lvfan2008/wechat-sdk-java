package fan.lv.wechat.entity.open.mp.code.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import fan.lv.wechat.entity.official.server.message.BaseEventMessage;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 审核延后事件推送
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@XStreamAlias("xml")
@Data
public class EventWeappAuditDelayMessage extends BaseEventMessage {
    /**
     * 事件类型: 审核延后
     */
    @XStreamAlias("Event")
    @JsonProperty("Event")
    String event = "weapp_audit_delay";

    /**
     * 审核延后时的时间戳
     */
    @XStreamAlias("DelayTime")
    @JsonProperty("DelayTime")
    Integer delayTime;

    /**
     * 审核延期原因
     */
    @XStreamAlias("Reason")
    @JsonProperty("Reason")
    String reason;
}
