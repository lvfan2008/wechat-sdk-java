package fan.lv.wechat.entity.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxMassSendSpeedResult extends WxResult {

    /**
     * 群发速度的级别, 0：80w/分钟, 1：60w/分钟, 2：45w/分钟, 3：30w/分钟, 4：10w/分钟
     */
    Integer speed;

    /**
     * 群发速度的真实值 单位：万/分钟
     */
    @JsonProperty("realspeed")
    Integer realSpeed;
}
