package fan.lv.wechat.api.payment.v2.service.impl;

import fan.lv.wechat.api.official.Util;
import fan.lv.wechat.api.payment.v2.service.ProfitShareService;
import fan.lv.wechat.entity.pay.config.WxPayConfig;
import fan.lv.wechat.entity.pay.profitshare.*;
import junit.framework.TestCase;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;

/**
 * @author lv_fan2008
 */
public class ProfitShareServiceImplTest extends TestCase {
    ProfitShareService profitShareService;

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
        profitShareService = new ProfitShareServiceImpl(new PayClientImpl(config),config);
    }

    public void testProfitShare() {
        String no = "111" + new Random().nextInt(10000);
        WxProfitShareResult result = profitShareService.profitShare(no, "ewwe",
                Arrays.asList(new WxReceiver("MERCHANT_ID", "ewwewe", 123, "ffds", "3232"),
                        new WxReceiver("MERCHANT_ID", "ewwewe2", 123, "ffds", "3232")), null);
        assertTrue(result.success());
    }

    public void testMultiProfitShare() {
        String no = "111" + new Random().nextInt(10000);
        WxProfitShareResult result = profitShareService.multiProfitShare(no, "ewwe",
                Arrays.asList(new WxReceiver("MERCHANT_ID", "ewwewe", 123, "ffds", "3232"),
                        new WxReceiver("MERCHANT_ID", "ewwewe2", 123, "ffds", "3232")), null);
        assertTrue(result.success());
    }

    public void testQueryProfitShare() {
        String no = "111" + new Random().nextInt(10000);
        WxQueryProfitShareResult result = profitShareService.queryProfitShare(no, "ewwe");
        assertTrue(result.success());
    }

    public void testAddReceivers() {
        WxAddReceiversResult result = profitShareService.addReceivers(new WxReceiverForAdd("MERCHANT_ID", "dssd", "dsd", "dsds", "dsds"));
        assertTrue(result.success());
    }

    public void testDeleteReceivers() {
        WxDeleteReceiverResult result = profitShareService.deleteReceivers(new WxReceiverForDelete("MERCHANT_ID", "dsds", "dsds"));
        assertTrue(result.success());
    }

    public void testFinishProfitShare() {
        String no = "111" + new Random().nextInt(10000);
        WxProfitShareResult result = profitShareService.finishProfitShare(no, "323", "dsdds");
        assertTrue(result.success());
    }

    public void testReturnProfitShare() {
        WxReturnProfitShareResult result = profitShareService.returnProfitShare(
                "3008450740201411110007820472",
                "P20150806125346",
                "R20190516001",
                "MERCHANT_ID",
                "86693852",
                888,
                "用户退款"
        );
        assertEquals("PARAM_ERROR", result.getReturnErrorCode());
    }

    public void testQueryReturnProfitShare() {

        String no = "111" + new Random().nextInt(10000);
        WxReturnProfitShareResult result = profitShareService.queryReturnProfitShare(no, "323", "dsdds");
        assertEquals("NOAUTH", result.getReturnErrorCode());
    }
}