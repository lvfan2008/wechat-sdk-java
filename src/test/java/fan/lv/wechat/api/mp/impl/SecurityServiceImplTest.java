package fan.lv.wechat.api.mp.impl;

import fan.lv.wechat.api.mp.service.SecurityService;
import fan.lv.wechat.api.mp.service.impl.SecurityServiceImpl;
import fan.lv.wechat.api.official.Util;
import fan.lv.wechat.entity.mp.security.WxMediaCheckAsyncResult;
import fan.lv.wechat.entity.result.WxResult;
import junit.framework.TestCase;

/**
 * @author lv_fan2008
 */
public class SecurityServiceImplTest extends TestCase {

    SecurityService securityService;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        securityService = new SecurityServiceImpl(Util.getMpClient());
    }
    public void testImgSecCheck() {
        WxResult result = securityService.imgSecCheck(Util.getProperty("thumb.path"));
        assertTrue(result.success());
    }

    public void testMediaCheckAsync() {
        String url = "https://qian-img.tenpay.com/resources/vtools/img/201905/5cf1588f7ddec28b3d1f99c616fd9300.png";
        WxMediaCheckAsyncResult result = securityService.mediaCheckAsync(url,2);
        assertTrue(result.success());
    }

    public void testMsgSecCheck() {
        WxResult result = securityService.msgSecCheck("哈哈哈哈哈");
        assertTrue(result.success());
    }
}