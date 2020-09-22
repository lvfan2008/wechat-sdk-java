package fan.lv.wechat.entity.message.mass;

import lombok.Data;

/**
 * @author lv_fan2008
 */
@Data
public class WxMassSendSpeedParam {

    /**
     * 群发速度的级别, 0：80w/分钟, 1：60w/分钟, 2：45w/分钟, 3：30w/分钟, 4：10w/分钟
     */
    Integer speed;
}
