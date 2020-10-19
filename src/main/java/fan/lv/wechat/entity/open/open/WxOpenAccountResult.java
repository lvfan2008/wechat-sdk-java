package fan.lv.wechat.entity.open.open;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 创建开放平台帐号并绑定公众号/小程序结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxOpenAccountResult extends WxResult {
    /**
     * 所创建的开放平台帐号的 appid
     */
    @JsonProperty("open_appid")
    String openAppId;
}
