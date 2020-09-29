package fan.lv.wechat.entity.official.jssdk;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.official.sns.WxSnsOpenIdResult;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * jsapi_ticket
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxJsSdkTicketResult extends WxResult {
    /**
     * 公众号用于调用微信JS接口的临时票据
     */
    String ticket;

    /**
     * 凭证有效时间，单位：秒
     */
    @JsonProperty("expires_in")
    Integer expiresIn;
}