package fan.lv.wechat.entity.open.mp.code.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import fan.lv.wechat.entity.official.server.message.BaseEventMessage;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 审核不通过事件推送
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@XStreamAlias("xml")
@Data
public class EventWeappAuditFailMessage extends BaseEventMessage {
    /**
     * 事件类型: 审核不通过
     */
    @XStreamAlias("Event")
    @JsonProperty("Event")
    String event = "weapp_audit_fail";

    /**
     * 审核失败时间
     */
    @XStreamAlias("FailTime")
    @JsonProperty("FailTime")
    Integer failTime;

    /**
     * 审核不通过的截图示例。用 | 分隔的 media_id 的列表，可通过获取永久素材接口拉取截图内容
     */
    @XStreamAlias("ScreenShot")
    @JsonProperty("ScreenShot")
    String screenShot;

    /**
     * 审核失败原因
     */
    @XStreamAlias("Reason")
    @JsonProperty("Reason")
    String reason;
}
