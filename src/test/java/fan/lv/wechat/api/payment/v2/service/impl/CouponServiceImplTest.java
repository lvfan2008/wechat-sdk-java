package fan.lv.wechat.api.payment.v2.service.impl;

import fan.lv.wechat.api.official.Util;
import fan.lv.wechat.api.payment.v2.PayClientV2;
import fan.lv.wechat.api.payment.v2.service.CouponService;
import fan.lv.wechat.entity.pay.config.WxPayConfig;
import fan.lv.wechat.entity.pay.coupon.WxCouponInfoResult;
import fan.lv.wechat.entity.pay.coupon.WxQueryCouponStockResult;
import fan.lv.wechat.entity.pay.coupon.WxSendCouponResult;
import junit.framework.TestCase;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author lv_fan2008
 */
public class CouponServiceImplTest extends TestCase {

    CouponService couponService;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        byte[] bytes = Files.readAllBytes(Paths.get(Util.getProperty("pay.cert_path")));
        WxPayConfig config = WxPayConfig.builder().appId(Util.getProperty("pay.app_id"))
                .mchId(Util.getProperty("pay.mch_id"))
                .key(Util.getProperty("pay.key"))
                .certBytes(bytes)
                .notifyUrl("http://www.yunyicheng.cn/pay/callback")
                .sandbox(false)
                .build();
        PayClientV2 client = new PayClientV2Impl(config);
        couponService = new CouponServiceImpl(client, config);
    }


    public void testSendCoupon() {
        WxSendCouponResult result = couponService.sendCoupon("test001", "hhhla01", "eweewwe", null);
        assertTrue(result.success() && result.getPayErrCode().equals("INVALID_REQUEST"));
    }

    public void testQueryCouponStock() {
        WxQueryCouponStockResult result = couponService.queryCouponStock("test001", null);
        assertTrue(result.success() && result.getPayErrCode().equals("INVALID_REQUEST"));
    }

    public void testQueryCouponInfo() {
        WxCouponInfoResult result = couponService.queryCouponInfo("test001", "hhhla01", "eweewwe", null);
        assertTrue(result.success() && result.getPayErrCode().equals("INVALID_REQUEST"));
    }
}