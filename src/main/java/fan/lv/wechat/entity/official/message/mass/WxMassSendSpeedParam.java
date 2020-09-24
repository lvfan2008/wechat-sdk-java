package fan.lv.wechat.entity.official.message.mass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lv_fan2008
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WxMassSendSpeedParam {

    /**
     * 群发速度的级别, 0：80w/分钟, 1：60w/分钟, 2：45w/分钟, 3：30w/分钟, 4：10w/分钟
     */
    Integer speed;
}
