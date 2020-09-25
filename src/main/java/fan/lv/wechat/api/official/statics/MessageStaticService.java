package fan.lv.wechat.api.official.statics;

import fan.lv.wechat.entity.official.statics.*;

/**
 * 消息分析数据接口
 *
 * @author lv_fan2008
 * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/Analytics/Message_analysis_data_interface.html" target="_blank">微信官方接口文档</a>
 */
public interface MessageStaticService {
    /**
     * 获取消息发送概况数据
     *
     * @param beginDate 获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”（比如最大时间跨度为1时，
     *                  begin_date和end_date的差值只能为0，才能小于1），否则会报错
     * @param endDate   获取数据的结束日期，end_date允许设置的最大值为昨日
     * @return 消息发送概况数据
     */
    WxUpStreamMsgResult getUpStreamMsgData(String beginDate, String endDate);

    /**
     * 获取消息分送分时数据
     *
     * @param beginDate 获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”（比如最大时间跨度为1时，
     *                  begin_date和end_date的差值只能为0，才能小于1），否则会报错
     * @param endDate   获取数据的结束日期，end_date允许设置的最大值为昨日
     * @return 消息分送分时数据
     */
    WxUpStreamMsgHourResult getUpStreamMsgHourData(String beginDate, String endDate);


    /**
     * 获取消息发送周数据
     *
     * @param beginDate 获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”（比如最大时间跨度为1时，
     *                  begin_date和end_date的差值只能为0，才能小于1），否则会报错
     * @param endDate   获取数据的结束日期，end_date允许设置的最大值为昨日
     * @return 消息发送周数据
     */
    WxUpStreamMsgWeekResult getUpStreamMsgWeekData(String beginDate, String endDate);


    /**
     * 获取消息发送月数据
     *
     * @param beginDate 获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”（比如最大时间跨度为1时，
     *                  begin_date和end_date的差值只能为0，才能小于1），否则会报错
     * @param endDate   获取数据的结束日期，end_date允许设置的最大值为昨日
     * @return 消息发送月数据
     */
    WxUpStreamMsgMonthResult getUpStreamMsgMonthData(String beginDate, String endDate);


    /**
     * 获取消息发送分布数据
     *
     * @param beginDate 获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”（比如最大时间跨度为1时，
     *                  begin_date和end_date的差值只能为0，才能小于1），否则会报错
     * @param endDate   获取数据的结束日期，end_date允许设置的最大值为昨日
     * @return 消息发送分布数据
     */
    WxUpStreamMsgDistResult getUpStreamMsgDistData(String beginDate, String endDate);

    /**
     * 获取消息发送分布周数据
     *
     * @param beginDate 获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”（比如最大时间跨度为1时，
     *                  begin_date和end_date的差值只能为0，才能小于1），否则会报错
     * @param endDate   获取数据的结束日期，end_date允许设置的最大值为昨日
     * @return 消息发送分布周数据
     */
    WxUpStreamMsgDistWeekResult getUpStreamMsgDistWeekData(String beginDate, String endDate);

    /**
     * 获取消息发送分布周数据
     *
     * @param beginDate 获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”（比如最大时间跨度为1时，
     *                  begin_date和end_date的差值只能为0，才能小于1），否则会报错
     * @param endDate   获取数据的结束日期，end_date允许设置的最大值为昨日
     * @return 消息发送分布周数据
     */
    WxUpStreamMsgDistMonthResult getUpStreamMsgDistMonthData(String beginDate, String endDate);

}
