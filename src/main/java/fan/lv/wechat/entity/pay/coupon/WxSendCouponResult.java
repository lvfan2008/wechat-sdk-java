package fan.lv.wechat.entity.pay.coupon;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import fan.lv.wechat.entity.pay.base.WxCommonPayResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 发放优惠券结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxSendCouponResult extends WxCommonPayResult {

    /**
     * 代金券批次id，创建代金券时生成的批次号，可在商户平台-代金券管理页面查看
     */
    @XStreamAlias("coupon_stock_id")
    String couponStockId;


    /**
     * 返回记录数
     */
    @XStreamAlias("resp_count")
    Integer respCount;


    /**
     * 成功记录数
     */
    @XStreamAlias("success_count")
    Integer successCount;

    /**
     * 失败记录数
     */
    @XStreamAlias("failed_count")
    Integer failedCount;


    /**
     * 用户标识
     */
    @XStreamAlias("openid")
    String openId;


    /**
     * 对一个用户成功发放代金券则返回代金券id，即ret_code为SUCCESS的时候；
     * 如果ret_code为FAILED则填写空串""
     */
    @XStreamAlias("coupon_id")
    String couponId;


    /**
     * 返回信息，当返回码是FAILED的时候填写，否则填空串“”
     */
    @XStreamAlias("ret_msg")
    String retMsg;
}
