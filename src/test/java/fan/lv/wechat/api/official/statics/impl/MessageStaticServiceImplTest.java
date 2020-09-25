package fan.lv.wechat.api.official.statics.impl;

import fan.lv.wechat.api.official.Util;
import fan.lv.wechat.api.official.statics.MessageStaticService;
import fan.lv.wechat.entity.official.statics.*;
import junit.framework.TestCase;

/**
 * @author lv_fan2008
 */
public class MessageStaticServiceImplTest extends TestCase {
    MessageStaticService messageStaticService;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        messageStaticService = new MessageStaticServiceImpl(Util.getClient());
    }

    public void testGetUpStreamMsgData() {
        WxUpStreamMsgResult result = messageStaticService.getUpStreamMsgData("2020-08-01", "2020-08-01");
        assertTrue(result.success());
    }

    public void testGetUpStreamMsgHourData() {
        WxUpStreamMsgHourResult result = messageStaticService.getUpStreamMsgHourData("2020-08-01", "2020-08-01");
        assertTrue(result.success());
    }

    public void testGetUpStreamMsgWeekData() {
        WxUpStreamMsgWeekResult result = messageStaticService.getUpStreamMsgWeekData("2020-08-01", "2020-08-01");
        assertTrue(result.success());
    }

    public void testGetUpStreamMsgMonthData() {
        WxUpStreamMsgMonthResult result = messageStaticService.getUpStreamMsgMonthData("2020-08-01", "2020-08-01");
        assertTrue(result.success());
    }

    public void testGetUpStreamMsgDistData() {
        WxUpStreamMsgDistResult result = messageStaticService.getUpStreamMsgDistData("2020-08-01", "2020-08-01");
        assertTrue(result.success());
    }

    public void testGetUpStreamMsgDistWeekData() {
        WxUpStreamMsgDistWeekResult result = messageStaticService.getUpStreamMsgDistWeekData("2020-08-01", "2020-08-01");
        assertTrue(result.success());
    }

    public void testGetUpStreamMsgDistMonthData() {
        WxUpStreamMsgDistMonthResult result = messageStaticService.getUpStreamMsgDistMonthData("2020-08-01", "2020-08-01");
        assertTrue(result.success());
    }
}