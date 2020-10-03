package fan.lv.wechat.api.official.sns.impl;

import fan.lv.wechat.api.kernel.impl.DefaultCacheImpl;
import fan.lv.wechat.api.official.Util;
import fan.lv.wechat.api.official.sns.SnsService;
import fan.lv.wechat.api.official.statics.InterfaceStaticService;
import fan.lv.wechat.api.official.statics.impl.InterfaceStaticServiceImpl;
import fan.lv.wechat.entity.official.sns.WxSnsOpenIdResult;
import fan.lv.wechat.entity.official.sns.WxSnsUserInfoResult;
import junit.framework.TestCase;

/**
 * @author lv_fan2008
 */
public class SnsServiceImplTest extends TestCase {

    SnsService snsService;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        snsService = new SnsServiceImpl(Util.getProperty("app_id"),
                Util.getProperty("app_secret"),
                new DefaultCacheImpl()
        );
    }

    public void testGetOpenAuthUrl() {
        String url = snsService.getOpenAuthUrl("http://r.com.cn/redirect","snsapi_base","hello");
        assertTrue(url.contains("redirect_uri"));
    }

    public void testGetAuthToken() {
        WxSnsOpenIdResult result = snsService.getAuthToken("code");
        assertTrue(result.getErrorCode() == 40029);
    }

    public void testGetUserInfo() {
        WxSnsUserInfoResult result = snsService.getUserInfo(Util.getProperty("user_id"),"zh_CN");
        assertTrue(result.getErrorCode() == 40029);
    }
}