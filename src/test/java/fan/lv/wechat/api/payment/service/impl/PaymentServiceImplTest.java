package fan.lv.wechat.api.payment.service.impl;

import fan.lv.wechat.api.official.Util;
import fan.lv.wechat.api.payment.service.PaymentService;
import fan.lv.wechat.entity.pay.config.WxPayConfig;
import fan.lv.wechat.entity.pay.payment.WxMicroPayResult;
import fan.lv.wechat.entity.pay.payment.WxOrderQueryResult;
import junit.framework.TestCase;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

/**
 * @author lv_fan2008
 */
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
        paymentService = new PaymentServiceImpl(config);
    }

    public void testMicroPay1() {
        String orderNo = "T1000" + String.valueOf(new Random().nextInt());
        String authCode = "23943989834";
        WxMicroPayResult result = paymentService.microPay(orderNo, 1, "测试商品", authCode, "127.0.0.1", null);
        assertTrue(result.success());

        WxOrderQueryResult result2 = paymentService.orderQuery(orderNo,null);
        assertTrue(result2.success());

    }

    public void testMicroPay2() {
        String orderNo = "T1000" + String.valueOf(new Random().nextInt());
        String authCode = "23943989834";
        WxMicroPayResult result = paymentService.microPay(orderNo, 1, "测试商品", authCode, "127.0.0.1", null);
        assertTrue(result.success());

        WxOrderQueryResult result2 = paymentService.orderQuery(orderNo,null);
        assertTrue(result2.success());

    }

    public void testMicroPay3() {
        String orderNo = "T1000" + String.valueOf(new Random().nextInt());
        String authCode = "23943989834";
        WxMicroPayResult result = paymentService.microPay(orderNo, 1, "测试商品", authCode, "127.0.0.1", null);
        assertTrue(result.success());

        WxOrderQueryResult result2 = paymentService.orderQuery(orderNo,null);
        assertTrue(result2.success());

    }


    public void testMicroPayByPos() {
    }

    public void testReverse() {
    }

    public void testUnifiedOrder() {
    }

    public void testOrderQuery() {
    }

    public void testCloseOrder() {
    }

    public void testOrderRefund() {
    }

    public void testRefundQuery() {
    }

    public void testDownloadBill() {
    }

    public void testShortUrl() {
    }

    public void testAuthCodeToOpenId() {
    }

    public void testReport() {
    }

    public void testRefundNotifyParse() {
    }

    public void testPayNotifyParse() {
    }

    public void testGetNotifyReplyXml() {
    }
}