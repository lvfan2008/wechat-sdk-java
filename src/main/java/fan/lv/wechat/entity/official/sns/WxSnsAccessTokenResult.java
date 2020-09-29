package fan.lv.wechat.entity.official.sns;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 网页授权Token
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxSnsAccessTokenResult extends WxSnsOpenIdResult {
    /**
     * 获取到的凭证
     */
    @JsonProperty("access_token")
    String accessToken;

    /**
     * 凭证有效时间，单位：秒
     */
    @JsonProperty("expires_in")
    Integer expiresIn;

    /**
     * 用户刷新access_token
     */
    @JsonProperty("refresh_token")
    String refreshToken;

    /**
     * 用户唯一标识
     */
    @JsonProperty("openid")
    Integer openid;

    /**
     * 用户授权的作用域，使用逗号（,）分隔
     */
    @JsonProperty("scope")
    String scope;
}