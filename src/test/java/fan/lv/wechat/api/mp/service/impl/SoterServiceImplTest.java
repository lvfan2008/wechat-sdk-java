package fan.lv.wechat.api.mp.service.impl;

import fan.lv.wechat.api.mp.service.MarketService;
import fan.lv.wechat.api.mp.service.SoterService;
import fan.lv.wechat.api.official.Util;
import fan.lv.wechat.entity.mp.soter.WxVerifySignatureResult;
import junit.framework.TestCase;

/**
 * @author lv_fan2008
 */
public class SoterServiceImplTest extends TestCase {
    SoterService soterService;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        soterService = new SoterServiceImpl(Util.getMpClient());
    }

    public void testVerifySignature() {
        WxVerifySignatureResult result = soterService.verifySignature("test", "{}", "{}");
        assertTrue(result.success() || result.getErrorCode() == 40003);
    }
}