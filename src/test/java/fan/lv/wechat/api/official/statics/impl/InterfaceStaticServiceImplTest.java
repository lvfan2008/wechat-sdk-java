package fan.lv.wechat.api.official.statics.impl;

import fan.lv.wechat.api.official.Util;
import fan.lv.wechat.api.official.statics.InterfaceStaticService;
import fan.lv.wechat.entity.official.statics.WxInterfaceSummaryHourResult;
import fan.lv.wechat.entity.official.statics.WxInterfaceSummaryResult;
import junit.framework.TestCase;

/**
 * @author lv_fan2008
 */
public class InterfaceStaticServiceImplTest extends TestCase {
    InterfaceStaticService interfaceStaticService;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        interfaceStaticService = new InterfaceStaticServiceImpl(Util.getClient());
    }

    public void testGetInterfaceSummary() {
        WxInterfaceSummaryResult result = interfaceStaticService.getInterfaceSummary("2020-08-01", "2020-08-01");
        assertTrue(result.success());
    }

    public void testGetInterfaceSummaryHour() {
        WxInterfaceSummaryHourResult result = interfaceStaticService.getInterfaceSummaryHour("2020-08-01", "2020-08-01");
        assertTrue(result.success());
    }
}