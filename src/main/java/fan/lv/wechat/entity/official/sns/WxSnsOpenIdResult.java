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
public class WxSnsOpenIdResult extends WxResult {
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