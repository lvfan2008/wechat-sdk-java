package fan.lv.wechat.entity.open.open;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 预授权码
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxPreAuthCodeResult extends WxResult {
    /**
     * 预授权码
     */
    @JsonProperty("pre_auth_code")
    String preAuthCode;

    /**
     * 有效期，单位：秒
     */
    @JsonProperty("expires_in")
    Integer expireIn;
}
