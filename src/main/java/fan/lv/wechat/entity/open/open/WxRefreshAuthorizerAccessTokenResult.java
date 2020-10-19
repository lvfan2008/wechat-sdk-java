package fan.lv.wechat.entity.open.open;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.official.base.WxAccessToken;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 获取/刷新接口调用令牌
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxRefreshAuthorizerAccessTokenResult extends WxResult implements WxAccessToken {
    /**
     * 授权方令牌
     */
    @JsonProperty("authorizer_access_token")
    String accessToken;

    /**
     * 凭证有效时间，单位：秒
     */
    @JsonProperty("expires_in")
    Integer expiresIn;

    /**
     * 凭证有效时间，单位：秒
     */
    @JsonProperty("authorizer_refresh_token")
    String refreshToken;
}