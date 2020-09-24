package fan.lv.wechat.api.official.account.impl;

import fan.lv.wechat.api.official.Util;
import fan.lv.wechat.api.official.account.AccountService;
import fan.lv.wechat.api.official.user.UserService;
import fan.lv.wechat.api.official.user.impl.UserServiceImpl;
import fan.lv.wechat.entity.official.account.WxCreateQrCodeParam;
import fan.lv.wechat.entity.official.account.WxCreateQrCodeResult;
import fan.lv.wechat.entity.official.account.WxGetShortUrlResult;
import junit.framework.TestCase;

import java.util.Random;

/**
 * @author lv_fan2008
 */
public class AccountServiceImplTest extends TestCase {

    AccountService accountService;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        accountService = new AccountServiceImpl(Util.getClient());
    }

    public void testCreateQrCode() {
        WxCreateQrCodeResult result = accountService.createQrCode(3600 * 24, WxCreateQrCodeParam.QR_SCENE,
                new Random().nextInt(1000), null);
        assertTrue(result.success());
        result = accountService.createQrCode(3600 * 24, WxCreateQrCodeParam.QR_STR_SCENE, null,
                "test" + new Random().nextInt());
        assertTrue(result.success());
    }

    public void testGetShortUrl() {
        WxGetShortUrlResult result = accountService.getShortUrl(
                "https://developers.weixin.qq.com/doc/offiaccount/Analytics/User_Analysis_Data_Interface.html");
        assertTrue(result.success());
    }

}