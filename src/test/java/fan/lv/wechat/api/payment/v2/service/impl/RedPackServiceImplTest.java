package fan.lv.wechat.api.payment.v2.service.impl;

import fan.lv.wechat.api.official.Util;
import fan.lv.wechat.api.payment.v2.service.RedPackService;
import fan.lv.wechat.entity.pay.config.WxPayConfig;
import fan.lv.wechat.entity.pay.redpack.WxGetRedPackResult;
import fan.lv.wechat.entity.pay.redpack.WxMpSendRedPackResult;
import fan.lv.wechat.entity.pay.redpack.WxSendRedPackResult;
import junit.framework.TestCase;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author lv_fan2008
 */
public class RedPackServiceImplTest extends TestCase {
    RedPackService redPackService;

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
        redPackService = new RedPackServiceImpl(new PayClientImpl(config),config);
    }

    public void testSendRedPack() {
        WxSendRedPackResult result = redPackService.sendRedPack("332", "hahha", Util.getProperty("user_id"),
                10, 1, "sdsdsd",
                "127.0.0.1", "actioname", "remark", null);
        assertTrue(result.success());
    }

    public void testSendGroupRedPack() {
        WxSendRedPackResult result = redPackService.sendGroupRedPack("332", "hahha", Util.getProperty("user_id"),
                10, 5, "sdsdsd",
                "ALL_RAND", "127.0.0.1","actioname", "remark", null);
        assertTrue(result.success());
    }

    public void testGetRedPack() {
        WxGetRedPackResult result = redPackService.getRedPack("332", "hahha");
        assertTrue(result.success());
    }

    public void testSendMpRedPack() {
        WxMpSendRedPackResult result = redPackService.sendMpRedPack("332", "hahha", Util.getProperty("user_id"),
                10, 1, "sdsdsd",
                "127.0.0.1", "actioname", "remark","MINI_PROGRAM_JSAPI", null);
        assertTrue(result.success());
    }
}