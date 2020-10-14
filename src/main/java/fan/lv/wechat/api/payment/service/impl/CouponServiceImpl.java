package fan.lv.wechat.api.payment.service.impl;

import fan.lv.wechat.api.payment.service.CouponService;
import fan.lv.wechat.api.payment.service.PaymentService;
import fan.lv.wechat.entity.pay.base.WxBasePayResult;
import fan.lv.wechat.entity.pay.base.WxCommonPayResult;
import fan.lv.wechat.entity.pay.config.WxPayConfig;
import fan.lv.wechat.entity.pay.coupon.WxSendCouponResult;
import fan.lv.wechat.entity.pay.payment.*;
import fan.lv.wechat.util.RequestOptions;
import fan.lv.wechat.util.SimpleMap;
import fan.lv.wechat.util.SslCert;
import fan.lv.wechat.util.XmlUtil;
import fan.lv.wechat.util.pay.WxPayUtil;
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
}
