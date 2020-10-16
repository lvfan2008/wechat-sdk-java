package fan.lv.wechat.api.payment.v2.service;

import fan.lv.wechat.entity.pay.coupon.WxCouponInfoResult;
import fan.lv.wechat.entity.pay.coupon.WxQueryCouponStockResult;
import fan.lv.wechat.entity.pay.coupon.WxSendCouponResult;

import java.util.Map;

/**
 * 代金券或立减优惠服务
 *
 * @author lv_fan2008
 */
public interface CouponService {

    /**
     * 发放代金券
     * 用于商户主动调用接口给用户发放代金券的场景，已做防小号处理，给小号发放代金券将返回错误码。
     * <p>
     * 注意：通过接口发放的代金券不会进入微信卡包
     *
     * @param couponStockId  代金券批次id
     * @param partnerTradeNo 商户此次发放凭据号（格式：商户id+日期+流水号），商户侧需保持唯一性
     * @param openId         Openid信息，用户在appid下的唯一标识
     * @param others         其他参数
     * @return 发放代金券结果
     */
    WxSendCouponResult sendCoupon(String couponStockId, String partnerTradeNo, String openId, Map<String, String> others);

    /**
     * 查询代金券批次
     *
     * @param couponStockId 代金券批次id
     * @param others        其他参数
     * @return 代金券批次
     */
    WxQueryCouponStockResult queryCouponStock(String couponStockId, Map<String, String> others);

    /**
     * 查询代金券信息
     *
     * @param openId   用户openid
     * @param couponId 代金券id
     * @param stockId  代金劵对应的批次号
     * @param others   其他参数
     * @return 代金券信息
     */
    WxCouponInfoResult queryCouponInfo(String openId, String couponId, String stockId, Map<String, String> others);
}
