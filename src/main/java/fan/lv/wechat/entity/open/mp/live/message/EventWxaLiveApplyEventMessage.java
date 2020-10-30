package fan.lv.wechat.entity.open.mp.live.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import fan.lv.wechat.entity.official.server.message.BaseEventMessage;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 申请直播事件推送
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@XStreamAlias("xml")
@Data
public class EventWxaLiveApplyEventMessage extends BaseEventMessage {
    /**
     * 事件类型: 审核延后
     */
    @XStreamAlias("Event")
    @JsonProperty("Event")
    String event = "wxa_live_apply_event";

    /**
     * 申请直播通知结果
     */
    @XStreamAlias("ApplyLiveInfoNoitfy")
    @JsonProperty("ApplyLiveInfoNoitfy")
    ApplyLiveInfoNotify applyLiveInfoNotify;

    @XStreamAlias("ApplyLiveInfoNoitfy")
    @Data
    public static class ApplyLiveInfoNotify {
        /**
         * 成功开通的appid
         */
        @XStreamAlias("appid")
        @JsonProperty("appid")
        Integer appId;

        /**
         * 成功开通的时间
         */
        @XStreamAlias("open_time")
        @JsonProperty("open_time")
        String openTime;
    }


}
