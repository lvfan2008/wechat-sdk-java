package fan.lv.wechat.api.official.statics;

import fan.lv.wechat.entity.official.statics.*;

/**
 * 图文分享数据统计接口
 *
 * @author lv_fan2008
 * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/Analytics/Graphic_Analysis_Data_Interface.html" target="_blank">微信官方接口文档</a>
 */
public interface ArticleStaticService {
    /**
     * 获取图文群发每日数据
     *
     * @param beginDate 获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”（比如最大时间跨度为1时，
     *                  begin_date和end_date的差值只能为0，才能小于1），否则会报错
     * @param endDate   获取数据的结束日期，end_date允许设置的最大值为昨日
     * @return 图文群发每日数据
     */
    WxArticlesSummaryResult getArticlesSummary(String beginDate, String endDate);

    /**
     * 获取图文群发总数据
     *
     * @param beginDate 获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”（比如最大时间跨度为1时，
     *                  begin_date和end_date的差值只能为0，才能小于1），否则会报错
     * @param endDate   获取数据的结束日期，end_date允许设置的最大值为昨日
     * @return 图文群发总数据
     */
    WxArticleTotalResult getArticleTotal(String beginDate, String endDate);


    /**
     * 获取图文统计数据
     *
     * @param beginDate 获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”（比如最大时间跨度为1时，
     *                  begin_date和end_date的差值只能为0，才能小于1），否则会报错
     * @param endDate   获取数据的结束日期，end_date允许设置的最大值为昨日
     * @return 图文统计数据
     */
    WxUserReadResult getUserRead(String beginDate, String endDate);


    /**
     * 获取图文统计分时数据
     *
     * @param beginDate 获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”（比如最大时间跨度为1时，
     *                  begin_date和end_date的差值只能为0，才能小于1），否则会报错
     * @param endDate   获取数据的结束日期，end_date允许设置的最大值为昨日
     * @return 图文统计分时数据
     */
    WxUserReadHourResult getUserReadHour(String beginDate, String endDate);


    /**
     * 获取图文分享转发数据
     *
     * @param beginDate 获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”（比如最大时间跨度为1时，
     *                  begin_date和end_date的差值只能为0，才能小于1），否则会报错
     * @param endDate   获取数据的结束日期，end_date允许设置的最大值为昨日
     * @return 图文分享转发数据
     */
    WxUserShareResult getUserShare(String beginDate, String endDate);

    /**
     * 获取图文分享转发分时数据
     *
     * @param beginDate 获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”（比如最大时间跨度为1时，
     *                  begin_date和end_date的差值只能为0，才能小于1），否则会报错
     * @param endDate   获取数据的结束日期，end_date允许设置的最大值为昨日
     * @return 图文分享转发分时数据
     */
    WxUserShareHourResult getUserShareHour(String beginDate, String endDate);


}
