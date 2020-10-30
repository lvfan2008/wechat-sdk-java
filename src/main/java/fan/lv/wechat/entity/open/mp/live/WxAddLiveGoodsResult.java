package fan.lv.wechat.entity.open.mp.live;

import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 上传并提审需要直播的商品信息参数结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxAddLiveGoodsResult extends WxResult {

    /**
     * 商品ID
     */
    Integer goodsId;

    /**
     * 审核单ID
     */
    Integer auditId;
}
