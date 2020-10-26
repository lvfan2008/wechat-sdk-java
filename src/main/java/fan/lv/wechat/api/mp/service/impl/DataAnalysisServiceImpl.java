package fan.lv.wechat.api.mp.service.impl;

import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.mp.service.DataAnalysisService;
import fan.lv.wechat.entity.mp.datacube.*;
import fan.lv.wechat.util.SimpleMap;

/**
 * @author lv_fan2008
 */
public class DataAnalysisServiceImpl implements DataAnalysisService {
    /**
     * 请求客户端
     */
    protected Client client;


    /**
     * @param client 请求客户端
     */
    public DataAnalysisServiceImpl(Client client) {
        this.client = client;
    }

    @Override
    public WxDailyRetainInfoResult getDailyRetainInfo(String beginDate, String endDate) {
        return client.postJson("/datacube/getweanalysisappiddailyretaininfo",
                SimpleMap.of("begin_date", beginDate, "end_date", endDate),
                WxDailyRetainInfoResult.class);
    }

    @Override
    public WxWeeklyRetainInfoResult getWeeklyRetainInfo(String beginDate, String endDate) {
        return client.postJson("/datacube/getweanalysisappidweeklyretaininfo",
                SimpleMap.of("begin_date", beginDate, "end_date", endDate),
                WxWeeklyRetainInfoResult.class);
    }

    @Override
    public WxMonthlyRetainInfoResult getMonthlyRetainInfo(String beginDate, String endDate) {
        return client.postJson("/datacube/getweanalysisappidmonthlyretaininfo",
                SimpleMap.of("begin_date", beginDate, "end_date", endDate),
                WxMonthlyRetainInfoResult.class);
    }

    @Override
    public WxDailySummaryTrendResult getDailySummaryTrend(String beginDate, String endDate) {
        return client.postJson("/datacube/getweanalysisappiddailysummarytrend",
                SimpleMap.of("begin_date", beginDate, "end_date", endDate),
                WxDailySummaryTrendResult.class);
    }

    @Override
    public WxDailyVisitTrendResult getDailyVisitTrend(String beginDate, String endDate) {
        return client.postJson("/datacube/getweanalysisappiddailyvisittrend",
                SimpleMap.of("begin_date", beginDate, "end_date", endDate),
                WxDailyVisitTrendResult.class);
    }

    @Override
    public WxMonthlyVisitTrendResult getMonthlyVisitTrend(String beginDate, String endDate) {
        return client.postJson("/datacube/getweanalysisappidmonthlyvisittrend",
                SimpleMap.of("begin_date", beginDate, "end_date", endDate),
                WxMonthlyVisitTrendResult.class);
    }

    @Override
    public WxWeeklyVisitTrendResult getWeeklyVisitTrend(String beginDate, String endDate) {
        return client.postJson("/datacube/getweanalysisappidweeklyvisittrend",
                SimpleMap.of("begin_date", beginDate, "end_date", endDate),
                WxWeeklyVisitTrendResult.class);
    }

    @Override
    public WxUserPortraitResult getUserPortrait(String beginDate, String endDate) {
        return client.postJson("/datacube/getweanalysisappiduserportrait",
                SimpleMap.of("begin_date", beginDate, "end_date", endDate),
                WxUserPortraitResult.class);
    }

    @Override
    public WxVisitDistributionResult getVisitDistribution(String beginDate, String endDate) {
        return client.postJson("/datacube/getweanalysisappidvisitdistribution",
                SimpleMap.of("begin_date", beginDate, "end_date", endDate),
                WxVisitDistributionResult.class);
    }

    @Override
    public WxVisitPageResult getVisitPage(String beginDate, String endDate) {
        return client.postJson("/datacube/getweanalysisappidvisitpage",
                SimpleMap.of("begin_date", beginDate, "end_date", endDate),
                WxVisitPageResult.class);
    }
}
