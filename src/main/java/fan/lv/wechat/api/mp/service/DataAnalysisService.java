package fan.lv.wechat.api.mp.service;

import fan.lv.wechat.entity.mp.datacube.*;

/**
 * @author lv_fan2008
 */
public interface DataAnalysisService {
    /**
     * 获取用户访问小程序日留存
     *
     * @param beginDate 开始日期。格式为 yyyymmdd
     * @param endDate   结束日期，限定查询1天数据，允许设置的最大值为昨日。格式为 yyyymmdd
     * @return 用户访问小程序日留存
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/data-analysis/visit-retain/analysis.getDailyRetain.html" target="_blank">官方接口文档</a>
     */
    WxDailyRetainInfoResult getDailyRetainInfo(String beginDate, String endDate);


    /**
     * 获取用户访问小程序数据概况
     *
     * @param beginDate 开始日期。格式为 yyyymmdd
     * @param endDate   结束日期，限定查询1天数据，允许设置的最大值为昨日。格式为 yyyymmdd
     * @return 用户访问小程序数据概况
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/data-analysis/analysis.getDailySummary.html" target="_blank">官方接口文档</a>
     */
    WxDailySummaryTrendResult getDailySummaryTrend(String beginDate, String endDate);

    /**
     * 获取用户访问小程序数据日趋势
     *
     * @param beginDate 开始日期。格式为 yyyymmdd
     * @param endDate   结束日期，限定查询1天数据，允许设置的最大值为昨日。格式为 yyyymmdd
     * @return 用户访问小程序数据日趋势
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/data-analysis/visit-trend/analysis.getDailyVisitTrend.html" target="_blank">官方接口文档</a>
     */
    WxDailyVisitTrendResult getDailyVisitTrend(String beginDate, String endDate);


    /**
     * 获取用户访问小程序数据月趋势(能查询到的最新数据为上一个自然月的数据)
     *
     * @param beginDate 开始日期。格式为 yyyymmdd
     * @param endDate   结束日期，为自然月最后一天，限定查询一个月的数据。格式为 yyyymmdd
     * @return 用户访问小程序数据月趋势
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/data-analysis/visit-trend/analysis.getMonthlyVisitTrend.html" target="_blank">官方接口文档</a>
     */
    WxMonthlyVisitTrendResult getMonthlyVisitTrend(String beginDate, String endDate);

    /**
     * 获取用户访问小程序数据周趋势
     *
     * @param beginDate 开始日期。格式为 yyyymmdd
     * @param endDate   结束日期，为周日日期，限定查询一周数据。格式为 yyyymmdd
     * @return 用户访问小程序数据周趋势
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/data-analysis/visit-trend/analysis.getWeeklyVisitTrend.html" target="_blank">官方接口文档</a>
     */
    WxWeeklyVisitTrendResult getWeeklyVisitTrend(String beginDate, String endDate);


    /**
     * 获取小程序新增或活跃用户的画像分布数据。时间范围支持昨天、最近7天、最近30天。
     * 其中，新增用户数为时间范围内首次访问小程序的去重用户数，活跃用户数为时间范围内访问过小程序的去重用户数。
     *
     * @param beginDate 开始日期。格式为 yyyymmdd
     * @param endDate   结束日期，开始日期与结束日期相差的天数限定为0/6/29，分别表示查询最近1/7/30天数据，允许设置的最大值为昨日。格式为 yyyymmdd
     * @return 小程序新增或活跃用户的画像分布数据
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/data-analysis/analysis.getUserPortrait.html" target="_blank">官方接口文档</a>
     */
    WxUserPortraitResult getUserPortrait(String beginDate, String endDate);

    /**
     * 获取用户小程序访问分布数据
     *
     * @param beginDate 开始日期。格式为 yyyymmdd
     * @param endDate   结束日期，限定查询 1 天数据，允许设置的最大值为昨日。格式为 yyyymmdd
     * @return 用户小程序访问分布数据
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/data-analysis/analysis.getVisitDistribution.html" target="_blank">官方接口文档</a>
     */
    WxVisitDistributionResult getVisitDistribution(String beginDate, String endDate);

    /**
     * 获取用户小程序访问页面数据
     *
     * @param beginDate 开始日期。格式为 yyyymmdd
     * @param endDate   结束日期，限定查询 1 天数据，允许设置的最大值为昨日。格式为 yyyymmdd
     * @return 用户小程序访问页面数据
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/data-analysis/analysis.getVisitPage.html" target="_blank">官方接口文档</a>
     */
    WxVisitPageResult getVisitPage(String beginDate, String endDate);

}
