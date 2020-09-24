package fan.lv.wechat.api.official.statics;

import fan.lv.wechat.entity.official.statics.WxUserCumulateResult;
import fan.lv.wechat.entity.official.statics.WxUserSummaryResult;

/**
 * 数据统计接口
 *
 * @author lv_fan2008
 * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/Analytics/User_Analysis_Data_Interface.html" target="_blank">微信官方接口文档</a>
 */
public interface UserStaticService {

    /**
     * 获取用户增减数据
     *
     * @param beginDate 获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”
     *                  （比如最大时间跨度为1时，begin_date和end_date的差值只能为0，才能小于1），否则会报错
     * @param endDate   获取数据的结束日期，end_date允许设置的最大值为昨日
     * @return 用户增减数据
     */
    WxUserSummaryResult getUserSummary(String beginDate, String endDate);

    /**
     * 获取累计用户数据
     *
     * @param beginDate 获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”
     *                  （比如最大时间跨度为1时，begin_date和end_date的差值只能为0，才能小于1），否则会报错
     * @param endDate   获取数据的结束日期，end_date允许设置的最大值为昨日
     * @return 累计用户数据
     */
    WxUserCumulateResult getUserComulateData(String beginDate, String endDate);


}
