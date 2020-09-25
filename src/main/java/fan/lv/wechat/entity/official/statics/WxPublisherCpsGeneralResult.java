package fan.lv.wechat.entity.official.statics;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxPublisherCpsGeneralResult extends WxResult {

    /**
     * 返回码信息
     */
    @JsonProperty("base_resp")
    WxPublisherAdPosGeneralResult.BaseResp baseResp;

    /**
     * 公众号返佣商品数据
     */
    List<CpsDayData> list;

    /**
     * 总计数据
     */
    CpsSummaryData summary;

    /**
     * 请求返回总条数
     */
    @JsonProperty("total_num")
    Integer totalNum;





    /**
     * 广告位数据
     */
    @Data
    public static class CpsSummaryData {

        /**
         * 曝光量
         */
        @JsonProperty("exposure_count")
        Integer exposureCount;

        /**
         * 点击量
         */
        @JsonProperty("click_count")
        Integer clickCount;

        /**
         * 点击率
         */
        @JsonProperty("click_rate")
        Double clickRate;

        /**
         * 下单量
         */
        @JsonProperty("order_count")
        Integer orderCount;

        /**
         * 下单率
         */
        @JsonProperty("order_rate")
        Double orderRate;

        /**
         * 订单金额(分)
         */
        @JsonProperty("total_fee")
        Integer totalFee;

        /**
         * 预估收入(分)
         */
        @JsonProperty("total_commission")
        Integer totalCommission;
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class CpsDayData extends CpsSummaryData {
        /**
         * 日期
         */
        String date;
    }
}
