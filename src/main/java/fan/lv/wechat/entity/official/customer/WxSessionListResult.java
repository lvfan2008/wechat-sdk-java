package fan.lv.wechat.entity.official.customer;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 客服会话列表
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxSessionListResult extends WxResult {

    /**
     * 会话列表
     */
    @JsonProperty("sessionlist")
    List<Session> sessionList;

    @Data
    public static class Session {
        /**
         * 会话接入的时间
         */
        @JsonProperty("createtime")
        String createTime;

        /**
         * 粉丝OpenId
         */
        @JsonProperty("openid")
        String openId;
    }

}
