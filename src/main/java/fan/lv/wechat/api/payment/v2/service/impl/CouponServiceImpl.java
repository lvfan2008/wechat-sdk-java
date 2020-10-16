package fan.lv.wechat.api.payment.v2.service.impl;

import fan.lv.wechat.api.payment.v2.PayClient;
import fan.lv.wechat.api.payment.v2.service.CouponService;
import fan.lv.wechat.entity.pay.config.WxPayConfig;
import fan.lv.wechat.entity.pay.coupon.WxCouponInfoResult;
import fan.lv.wechat.entity.pay.coupon.WxQueryCouponStockResult;
import fan.lv.wechat.entity.pay.coupon.WxSendCouponResult;
import fan.lv.wechat.util.SimpleMap;
import fan.lv.wechat.util.pay.WxPayUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @author lv_fan2008
 */
@Slf4j
public class CouponServiceImpl extends BaseService implements CouponService {


    public CouponServiceImpl(PayClient client, WxPayConfig payConfig) {
        super(client, payConfig);
    }

    /**
     * 默认初始化数据
     *
     * @return 初始化数据
     */
    protected SimpleMap<String, String> defData() {
        return SimpleMap.of("appid", payConfig.getAppId())
                .add("mch_id", payConfig.getMchId())
                .add("nonce_str", WxPayUtil.generateNonceStr())
                .add("sub_mch_id", payConfig.getSubMchId())
                .add("sub_appid", payConfig.getSubAppId());
    }

    @Override
    public WxSendCouponResult sendCoupon(String couponStockId, String partnerTradeNo, String openId, Map<String, String> others) {
        Map<String, String> map = SimpleMap.of("coupon_stock_id", couponStockId,
                "partner_trade_no", partnerTradeNo,
                "openid", openId,
                "openid_count", "1")
                .addAll(others).addAll(defData());
        return client.postXml("/mmpaymkttransfers/send_coupon", map, WxSendCouponResult.class, defSslOpts());
    }

    @Override
    public WxQueryCouponStockResult queryCouponStock(String couponStockId, Map<String, String> others) {
        Map<String, String> map = SimpleMap.of("coupon_stock_id", couponStockId).addAll(others).addAll(defData());
        return client.postXml("/mmpaymkttransfers/query_coupon_stock", map, WxQueryCouponStockResult.class, defOpts());
    }

    @Override
    public WxCouponInfoResult queryCouponInfo(String openId, String couponId, String stockId, Map<String, String> others) {
        Map<String, String> map = SimpleMap.of("openid", openId, "coupon_id", couponId, "stock_id", stockId)
                .addAll(others).addAll(defData());
        return client.postXml("/mmpaymkttransfers/querycouponsinfo", map, WxCouponInfoResult.class, defOpts());
    }
}
