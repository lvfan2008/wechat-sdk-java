package fan.lv.wechat.api.payment.service.impl;

import fan.lv.wechat.api.official.Util;
import fan.lv.wechat.api.payment.service.EnterprisePayService;
import fan.lv.wechat.api.payment.service.RedPackService;
import fan.lv.wechat.entity.pay.config.WxPayConfig;
import fan.lv.wechat.entity.pay.enterprisepay.*;
import junit.framework.TestCase;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

/**
 * @author lv_fan2008
 */
public class EnterprisePayServiceImplTest extends TestCase {
    EnterprisePayService enterprisePayService;

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
        enterprisePayService = new EnterprisePayServiceImpl(config);
    }

    public void testEnterprisePay() {
        String no = "111"+ new Random().nextInt(10000);
        WxEnterprisePayResult result = enterprisePayService.enterprisePay(no,Util.getProperty("user_id"),"NO_CHECK",1,"hh",null);
        assertTrue(result.success());
    }

    public void testQueryEnterprisePay() {
        String no = "111"+ new Random().nextInt(1000066);
        WxQueryEnterprisePayResult result = enterprisePayService.queryEnterprisePay(no);
        assertTrue(result.success());
    }

    public void testEnterprisePayToBankCard() {
        String no = "111"+ new Random().nextInt(10000);
        WxEnterprisePayToBankCardResult result = enterprisePayService.enterprisePayToBankCard(no,"238923989832",
                "哈哈","1006",1,"3232");
        assertTrue(result.success());
    }

    public void testQueryEnterprisePayToBankCard() {
        String no = "111"+ new Random().nextInt(10000);
        WxQueryPayToBankCardResult result = enterprisePayService.queryEnterprisePayToBankCard(no);
        assertTrue(result.success());
    }

    public void testGetPubKey() {
        WxGetPubKeyResult result = enterprisePayService.getPubKey();
        assertTrue(result.success());
    }
}