package fan.lv.wechat.api.official.statics.impl;

import fan.lv.wechat.api.official.Util;
import fan.lv.wechat.api.official.statics.UserStaticService;
import fan.lv.wechat.entity.official.statics.WxUserCumulateResult;
import fan.lv.wechat.entity.official.statics.WxUserSummaryResult;
import junit.framework.TestCase;

/**
 * @author lv_fan2008
 */
public class UserStaticServiceImplTest extends TestCase {

    UserStaticService userStaticService;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        userStaticService = new UserStaticServiceImpl(Util.getClient());
    }

    public void testGetUserSummary() {
        WxUserSummaryResult result = userStaticService.getUserSummary("2020-08-01", "2020-08-02");
        assertTrue(result.success());
    }

    public void testGetUserCumulateData() {
        WxUserCumulateResult result = userStaticService.getUserCumulateData("2020-08-01", "2020-08-02");
        assertTrue(result.success());
    }
}