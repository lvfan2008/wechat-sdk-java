package fan.lv.wechat.entity.open.mp.code.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import fan.lv.wechat.entity.official.server.message.BaseEventMessage;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 审核通过事件推送
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@XStreamAlias("xml")
@Data
public class EventWeappAuditSuccessMessage extends BaseEventMessage {
    /**
     * 事件类型: 审核通过
     */
    @XStreamAlias("Event")
    @JsonProperty("Event")
    String event = "weapp_audit_success";

    /**
     * 审核成功时间
     */
    @XStreamAlias("SuccTime")
    @JsonProperty("SuccTime")
    Integer successTime;
}
