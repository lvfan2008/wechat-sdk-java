package fan.lv.wechat.entity.open.open;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 所有已授权的帐号信息
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxAuthorizerListResult extends WxResult {
    /**
     * 授权的帐号总数
     */
    @JsonProperty("total_count")
    Integer totalCount;

    /**
     * 帐号基本信息
     */
    @JsonProperty("expires_in")
    AuthorizerAuthInfo authorizerAuthInfo;

    @Data
    public static class AuthorizerAuthInfo {
        /**
         * 已授权的 appid
         */
        @JsonProperty("authorizer_appid")
        String authorizerAppId;

        /**
         * 刷新令牌authorizer_access_token
         */
        @JsonProperty("refresh_token")
        String refreshToken;

        /**
         * 授权的时间
         */
        @JsonProperty("auth_time")
        Integer authTime;
    }
}
