package fan.lv.wechat.entity.open.mp.basicinfo.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import fan.lv.wechat.entity.official.server.message.BaseEventMessage;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 名称审核结果事件推送
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@XStreamAlias("xml")
@Data
public class EventWxaNickNameAuditMessage extends BaseEventMessage {
    /**
     * 事件类型: 名称审核结果事件
     */
    @XStreamAlias("Event")
    @JsonProperty("Event")
    String event = "wxa_nickname_audit";

    /**
     * 需要更改的昵称
     */
    @XStreamAlias("nickname")
    @JsonProperty("nickname")
    String nickname;


    /**
     * 审核结果 2：失败，3：成功
     */
    @XStreamAlias("ret")
    @JsonProperty("ret")
    Integer ret;

    /**
     * 审核失败的驳回原因
     */
    @XStreamAlias("reason")
    @JsonProperty("reason")
    String reason;
}
