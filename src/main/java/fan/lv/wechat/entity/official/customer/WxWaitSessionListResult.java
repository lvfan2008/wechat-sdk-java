package fan.lv.wechat.entity.official.customer;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 未接入会话列表
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxWaitSessionListResult extends WxResult {

    /**
     * 未接入会话列表，最多返回100条数据，按照来访顺序
     */
    @JsonProperty("waitcaselist")
    List<Session> waitCaseList;

    /**
     * 未接入会话数量
     */
    Integer count;

    @Data
    public static class Session {
        /**
         * 粉丝的最后一条消息的时间
         */
        @JsonProperty("latest_time")
        String latestTime;

        /**
         * 粉丝OpenId
         */
        @JsonProperty("openid")
        String openId;
    }

}
