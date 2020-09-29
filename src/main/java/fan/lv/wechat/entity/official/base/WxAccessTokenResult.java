package fan.lv.wechat.entity.official.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 调用凭据
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxAccessTokenResult extends WxResult {
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
}