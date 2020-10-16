package fan.lv.wechat.api.payment.v2.service.impl;

import fan.lv.wechat.api.official.Util;
import fan.lv.wechat.api.payment.v2.service.PaymentService;
import fan.lv.wechat.entity.pay.base.WxBasePayResult;
import fan.lv.wechat.entity.pay.base.WxCommonPayResult;
import fan.lv.wechat.entity.pay.config.WxPayConfig;
import fan.lv.wechat.entity.pay.payment.*;
import fan.lv.wechat.util.SimpleMap;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

/**
 * @author lv_fan2008
 */
@Slf4j
public class PaymentServiceImplTest extends TestCase {
    PaymentService paymentService;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        byte[] bytes = Files.readAllBytes(Paths.get(Util.getProperty("pay.cert_path")));
        WxPayConfig config = WxPayConfig.builder().appId(Util.getProperty("pay.app_id"))
                .mchId(Util.getProperty("pay.mch_id"))
                .key(Util.getProperty("pay.key"))
                .certBytes(bytes)
                .notifyUrl("http://www.yunyicheng.cn/pay/callback")
                .sandbox(true)
                .build();
        paymentService = new PaymentServiceImpl(new PayClientImpl(config),config);
    }

    protected PaymentService getPay() {
        byte[] bytes = new byte[0];
        try {
            bytes = Files.readAllBytes(Paths.get(Util.getProperty("pay.cert_path")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        WxPayConfig config = WxPayConfig.builder().appId(Util.getProperty("pay.app_id"))
                .mchId(Util.getProperty("pay.mch_id"))
                .key(Util.getProperty("pay.key"))
                .certBytes(bytes)
                .notifyUrl("http://www.yunyicheng.cn/pay/callback")
                .sandbox(false)
                .build();
        return new PaymentServiceImpl(new PayClientImpl(config),config);
    }

    public void testMicroPay1() {
        String orderNo = "sandbox_test_1";
        String authCode = "23943989834";
        WxMicroPayResult result = paymentService.microPay(orderNo, 1, "测试商品", authCode, "127.0.0.1", null);
        assertTrue(result.success() && result.resultSuccess());
        WxOrderQueryResult result2 = paymentService.orderQuery(orderNo, null);
        assertTrue(result2.success());
        assertTrue(result2.resultSuccess());
        assertEquals(result2.getOutTradeNo(), orderNo);
        assertEquals(1, (int) result2.getCashFee());
        assertEquals(1, (int) result2.getTotalFee());
        assertEquals("SUCCESS", result2.getPayErrCode());
    }

    public void testMicroPay2() {
        String orderNo = "sandbox_test_2";
        String authCode = "23943989834";
        WxMicroPayResult result = paymentService.microPay(orderNo, 2, "测试商品", authCode, "127.0.0.1",
                SimpleMap.of("goods_tag", "1"));
        assertTrue(result.success() && result.resultSuccess());

        WxOrderQueryResult result2 = paymentService.orderQuery(orderNo, null);
        assertTrue(result2.success());
        assertTrue(result2.resultSuccess());
        assertEquals(result2.getOutTradeNo(), orderNo);
        assertEquals(1, (int) result2.getCashFee());
        assertEquals(2, (int) result2.getTotalFee());
        assertEquals("SUCCESS", result2.getPayErrCode());
    }

    public void testMicroPay3() {
        String orderNo = "sandbox_test_3";
        String authCode = "23943989834";
        WxMicroPayResult result = paymentService.microPay(orderNo, 3, "测试商品", authCode, "127.0.0.1",
                SimpleMap.of("goods_tag", "2"));
        assertTrue(result.success() && result.resultSuccess());

        WxOrderQueryResult result2 = paymentService.orderQuery(orderNo, null);
        assertTrue(result2.success());
        assertTrue(result2.resultSuccess());
        assertEquals(result2.getOutTradeNo(), orderNo);
        assertEquals(3, (int) result2.getCouponFee());
        assertEquals(1, (int) result2.getSettlementTotalFee());
        assertEquals(0, (int) result2.getCashFee());
        assertEquals("1", result2.get("coupon_fee_0"));
        assertEquals("2", result2.get("coupon_fee_1"));
        assertEquals("NO_CASH", result2.get("coupon_type_1"));
        assertEquals(3, (int) result2.getTotalFee());
        assertEquals(2, (int) result2.getCouponCount());
        assertEquals("SUCCESS", result2.getPayErrCode());
    }

    public void testReverse() {
        String orderNo = "T1000" + String.valueOf(new Random().nextInt());
        String authCode = "23943989834";
        WxMicroPayResult result = paymentService.microPay(orderNo, 1, "测试商品", authCode, "127.0.0.1", null);
        assertTrue(result.success());
        WxPayReverseResult result2 = paymentService.reverse(orderNo, null);
        assertTrue(result2.success());

    }

    public void testUnifiedOrder() {
        String orderNo = "T1000" + String.valueOf(new Random().nextInt());
        String authCode = "23943989834";
        WxUnifiedOrderResult result = paymentService.unifiedOrder(orderNo, 301, "NATIVE",
                "测试商品", "", "127.0.0.1", null);
        assertTrue(result.success());
        WxPayReverseResult result2 = paymentService.reverse(orderNo, null);
        assertTrue(result2.success());
    }

    public void testCloseOrder() {
        String orderNo = "T1000" + String.valueOf(new Random().nextInt());
        String authCode = "23943989834";
        WxUnifiedOrderResult result = paymentService.unifiedOrder(orderNo, 101, "JSAPI",
                "测试商品", "", "127.0.0.1", null);
        assertTrue(result.success());
        WxCommonPayResult result2 = paymentService.closeOrder(orderNo);
        assertTrue(result2.success());
    }

    public void testOrderRefund() {
        String orderNo = "T1000" + String.valueOf(new Random().nextInt());
        String authCode = "23943989834";
        WxUnifiedOrderResult result = paymentService.unifiedOrder(orderNo, 301, "NATIVE",
                "测试商品", "", "127.0.0.1", null);
        assertTrue(result.success());
        WxOrderRefundResult result2 = paymentService.orderRefund(orderNo, null, "R001010", 301, 301, null);
        assertTrue(result2.success());

        WxRefundQueryResult result3 = paymentService.refundQuery(null, null, null, result2.getRefundId(), null);
        assertTrue(result3.success());
    }


    public void testDownloadBill() {
        WxDownloadBillResult result3 = paymentService.downloadBill("20201015", "ALL", null);
        assertTrue(result3.success());
    }

    public void testShortUrl() {
        WxShortUrlResult result3 = getPay().shortUrl("http://www.baidu.com/");
        assertEquals("invalid native url", result3.getReturnMsg());
    }

    public void testAuthCodeToOpenId() {
        WxAuthCodeToOpenIdResult result2 = getPay().authCodeToOpenId("135119521468514360");
        assertTrue(result2.success());
    }

    public void testReport() {
        WxBasePayResult result2 = getPay().report("https://api.mch.weixin.qq.com/pay/unifiedorder",
                1000, "SUCCESS", "OK", "127.0.0.1", null);
        assertTrue(result2.success());
    }

    public void testRefundNotifyParse() {
        String xml = "<xml>\n" +
                "<return_code>SUCCESS</return_code>\n" +
                "   <appid><![CDATA[wx2421b1c4370ec43b]]></appid>\n" +
                "   <mch_id><![CDATA[10000100]]></mch_id>\n" +
                "   <nonce_str><![CDATA[TeqClE3i0mvn3DrK]]></nonce_str>\n" +
                "   <req_info><![CDATA[T87GAHG17TGAHG1TGHAHAHA1Y1CIOA9UGJH1GAHV871HAGAGQYQQPOOJMXNBCXBVNMNMAJAA]]></req_info>\n" +
                "</xml>";
        WxRefundNotifyResult result = getPay().refundNotifyParse(xml);
        assertEquals("wx2421b1c4370ec43b", result.getAppId());
        assertNull(result.getDecodeReqInfo());
    }

    public void testPayNotifyParse() {
        String xml = "<xml>\n" +
                "  <appid><![CDATA[wx2421b1c4370ec43b]]></appid>\n" +
                "  <attach><![CDATA[支付测试]]></attach>\n" +
                "  <bank_type><![CDATA[CFT]]></bank_type>\n" +
                "  <fee_type><![CDATA[CNY]]></fee_type>\n" +
                "  <is_subscribe><![CDATA[Y]]></is_subscribe>\n" +
                "  <mch_id><![CDATA[10000100]]></mch_id>\n" +
                "  <nonce_str><![CDATA[5d2b6c2a8db53831f7eda20af46e531c]]></nonce_str>\n" +
                "  <openid><![CDATA[oUpF8uMEb4qRXf22hE3X68TekukE]]></openid>\n" +
                "  <out_trade_no><![CDATA[1409811653]]></out_trade_no>\n" +
                "  <result_code><![CDATA[SUCCESS]]></result_code>\n" +
                "  <return_code><![CDATA[SUCCESS]]></return_code>\n" +
                "  <sign><![CDATA[B552ED6B279343CB493C5DD0D78AB241]]></sign>\n" +
                "  <time_end><![CDATA[20140903131540]]></time_end>\n" +
                "  <total_fee>1</total_fee>\n" +
                "  <coupon_fee><![CDATA[10]]></coupon_fee>\n" +
                "  <coupon_count><![CDATA[1]]></coupon_count>\n" +
                "  <coupon_type><![CDATA[CASH]]></coupon_type>\n" +
                "  <coupon_id><![CDATA[10000]]></coupon_id>\n" +
                "  <trade_type><![CDATA[JSAPI]]></trade_type>\n" +
                "  <transaction_id><![CDATA[1004400740201409030005092168]]></transaction_id>\n" +
                "</xml>";
        WxPayNotifyResult result = getPay().payNotifyParse(xml);
        assertEquals("wx2421b1c4370ec43b", result.getAppId());
    }

    public void testGetNotifyReplyXml() {
        String result2 = getPay().getNotifyReplyXml("SUCCESS", "OK");
        log.debug("getNotifyReplyXml: {}", result2);
        assertTrue(result2.contains("SUCCESS") && result2.contains("OK"));
    }
}