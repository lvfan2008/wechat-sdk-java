package fan.lv.wechat.api.official.statics;

import fan.lv.wechat.entity.official.statics.*;

/**
 * 广告数据分析接口
 *
 * @author lv_fan2008
 * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/Analytics/Ad_Analysis.html" target="_blank">微信官方接口文档</a>
 */
public interface PublishAdStaticService {

    /**
     * 获取公众号分广告位数据
     *
     * @param page      返回第几页数据
     * @param pageSize  当页返回数据条数，每页最大获取量为90
     * @param startDate 获取数据的开始时间 yyyy-mm-dd
     * @param endDate   获取数据的结束时间 yyyy-mm-dd
     * @param adSlot    广告位类型名称，如果广告位类型名称为null，将默认返回全部类型广告位（除返佣商品广告）的数据。
     * @return 公众号分广告位数据
     */
    WxPublisherAdPosGeneralResult getPublisherAdPosGeneral(Integer page, Integer pageSize,
                                                           String startDate, String endDate, String adSlot);

    /**
     * 获取公众号返佣商品数据
     *
     * @param page      返回第几页数据
     * @param pageSize  当页返回数据条数，每页最大获取量为90
     * @param startDate 获取数据的开始时间 yyyy-mm-dd
     * @param endDate   获取数据的结束时间 yyyy-mm-dd
     * @return 公众号返佣商品数据
     */
    WxPublisherCpsGeneralResult getPublisherCpsGeneral(Integer page, Integer pageSize, String startDate, String endDate);

    /**
     * 获取公众号结算收入数据及结算主体信息
     *
     * @param page      返回第几页数据
     * @param pageSize  当页返回数据条数，每页最大获取量为90
     * @param startDate 获取数据的开始时间 yyyy-mm-dd
     * @param endDate   获取数据的结束时间 yyyy-mm-dd
     * @return 公众号结算收入数据及结算主体信息
     */
    WxPublisherSettlementResult getPublisherSettlement(Integer page, Integer pageSize, String startDate, String endDate);
}
