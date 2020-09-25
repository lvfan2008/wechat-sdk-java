package fan.lv.wechat.api.official.statics;

import fan.lv.wechat.entity.official.statics.*;

/**
 * 接口分析接口
 *
 * @author lv_fan2008
 * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/Analytics/Analytics_API.html" target="_blank">微信官方接口文档</a>
 */
public interface InterfaceStaticService {

    /**
     * 获取接口分析数据
     *
     * @param beginDate 获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”
     *                  （比如最大时间跨度为1时，begin_date和end_date的差值只能为0，才能小于1），否则会报错，格式 yyyy-mm-dd
     * @param endDate   获取数据的结束日期，end_date允许设置的最大值为昨日 格式 yyyy-mm-dd
     * @return 接口分析数据
     */
    WxInterfaceSummaryResult getInterfaceSummary(String beginDate, String endDate);

    /**
     * 获取接口分析分时数据
     *
     * @param beginDate 获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”
     *                  （比如最大时间跨度为1时，begin_date和end_date的差值只能为0，才能小于1），否则会报错，格式 yyyy-mm-dd
     * @param endDate   获取数据的结束日期，end_date允许设置的最大值为昨日 格式 yyyy-mm-dd
     * @return 接口分析分时数据
     */
    WxInterfaceSummaryHourResult getInterfaceSummaryHour(String beginDate, String endDate);
}
