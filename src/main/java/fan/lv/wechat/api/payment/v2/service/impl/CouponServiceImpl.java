package fan.lv.wechat.api.payment.v2.service.impl;

import fan.lv.wechat.api.payment.v2.service.CouponService;
import fan.lv.wechat.entity.pay.config.WxPayConfig;
import fan.lv.wechat.entity.pay.coupon.WxCouponInfoResult;
import fan.lv.wechat.entity.pay.coupon.WxQueryCouponStockResult;
import fan.lv.wechat.entity.pay.coupon.WxSendCouponResult;
import fan.lv.wechat.util.SimpleMap;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @author lv_fan2008
 */
@Slf4j
public class CouponServiceImpl extends PayClientImpl implements CouponService {

    public CouponServiceImpl(WxPayConfig payConfig) {
        super(payConfig);
    }

    @Override
    public WxSendCouponResult sendCoupon(String couponStockId, String partnerTradeNo, String openId, Map<String, String> others) {
        Map<String, String> map = SimpleMap.of("coupon_stock_id", couponStockId,
                "partner_trade_no", partnerTradeNo,
                "openid", openId,
                "openid_count", "1")
                .addAll(others);
        return postXml("/mmpaymkttransfers/send_coupon", map, WxSendCouponResult.class, defSslOpts());
    }

    @Override
    public WxQueryCouponStockResult queryCouponStock(String couponStockId, Map<String, String> others) {
        Map<String, String> map = SimpleMap.of("coupon_stock_id", couponStockId).addAll(others);
        return postXml("/mmpaymkttransfers/query_coupon_stock", map, WxQueryCouponStockResult.class, defOpts());
    }

    @Override
    public WxCouponInfoResult queryCouponInfo(String openId, String couponId, String stockId, Map<String, String> others) {
        Map<String, String> map = SimpleMap.of("openid", openId, "coupon_id", couponId, "stock_id", stockId)
                .addAll(others);
        return postXml("/mmpaymkttransfers/querycouponsinfo", map, WxCouponInfoResult.class, defOpts());
    }
}
