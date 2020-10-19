package fan.lv.wechat.entity.open.open;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 授权方选项信息
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxAuthorizerOptionResult extends WxResult {
    /**
     * 授权公众号或小程序的 appid
     */
    @JsonProperty("authorizer_appid")
    String authorizerAppId;

    /**
     * 选项名称
     */
    @JsonProperty("option_name")
    String optionName;

    /**
     * 选项值
     */
    @JsonProperty("option_value")
    String optionValue;
}
