package fan.lv.wechat.api.mp.impl;

import fan.lv.wechat.api.mp.DataAnalysisService;
import fan.lv.wechat.api.official.Util;
import fan.lv.wechat.entity.mp.datacube.*;
import junit.framework.TestCase;

/**
 * @author lv_fan2008
 */
public class DataAnalysisServiceImplTest extends TestCase {

    DataAnalysisService dataAnalysisService;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        dataAnalysisService = new DataAnalysisServiceImpl(Util.getMpClient());
    }


    public void testGetDailyRetainInfo() {
        WxDailyRetainInfoResult result = dataAnalysisService.getDailyRetainInfo("20201002", "20201002");
        assertTrue(result.success());
    }

    public void testGetDailySummaryTrend() {
        WxDailySummaryTrendResult result = dataAnalysisService.getDailySummaryTrend("20201002", "20201002");
        assertTrue(result.success());
    }

    public void testGetDailyVisitTrend() {
        WxDailyVisitTrendResult result = dataAnalysisService.getDailyVisitTrend("20201002", "20201002");
        assertTrue(result.success());
    }

    public void testGetMonthlyVisitTrend() {
        WxMonthlyVisitTrendResult result = dataAnalysisService.getMonthlyVisitTrend("20200901", "20200930");
        assertTrue(result.success());
    }

    public void testGetWeeklyVisitTrend() {
        WxWeeklyVisitTrendResult result = dataAnalysisService.getWeeklyVisitTrend("20200921", "20200927");
        assertTrue(result.success());
    }

    public void testGetUserPortrait() {
        WxUserPortraitResult result = dataAnalysisService.getUserPortrait("20201003", "20201003");
        assertTrue(result.success());
    }

    public void testGetVisitDistribution() {
        WxVisitDistributionResult result = dataAnalysisService.getVisitDistribution("20201003", "20201003");
        assertTrue(result.success());
    }

    public void testGetVisitPage() {
        WxVisitPageResult result = dataAnalysisService.getVisitPage("20201003", "20201003");
        assertTrue(result.success());
    }
}