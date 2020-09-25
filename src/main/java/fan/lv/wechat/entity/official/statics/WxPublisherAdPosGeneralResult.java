package fan.lv.wechat.entity.official.statics;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 公众号分广告位数据
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxPublisherAdPosGeneralResult extends WxResult {

    /**
     * 返回码信息
     */
    @JsonProperty("base_resp")
    BaseResp baseResp;

    /**
     * 广告位数据
     */
    List<AdPosData> list;

    /**
     * 广告位总统计数据
     */
    AdPosSummaryData summary;

    /**
     * 请求返回总条数
     */
    @JsonProperty("total_num")
    Integer totalNum;

    @Data
    public static class BaseResp {
        /**
         * 错误码
         */
        Integer ret;

        /**
         * 返回错误信息
         */
        @JsonProperty("err_msg")
        String errMsg;
    }

    /**
     * 广告位数据
     */
    public static class AdPosData {
        /**
         * 广告位类型id
         */
        @JsonProperty("slot_id")
        String slotId;

        /**
         * 广告位类型名称
         */
        @JsonProperty("ad_slot")
        String adSlot;

        /**
         * 日期
         */
        String date;

        /**
         * 拉取量
         */
        @JsonProperty("req_succ_count")
        Integer reqSuccessCount;

        /**
         * 曝光量
         */
        @JsonProperty("exposure_count")
        Integer exposureCount;

        /**
         * 曝光率
         */
        @JsonProperty("exposure_rate")
        Double exposureRate;

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
         * 收入(分)
         */
        Integer income;

        /**
         * 广告千次曝光收益(分)
         */
        @JsonProperty("ecpm")
        Double ecpm;
    }

    /**
     * 广告位总统计数据
     */
    public static class AdPosSummaryData {
        /**
         * 拉取量
         */
        @JsonProperty("req_succ_count")
        Integer reqSuccessCount;

        /**
         * 曝光量
         */
        @JsonProperty("exposure_count")
        Integer exposureCount;

        /**
         * 曝光率
         */
        @JsonProperty("exposure_rate")
        Double exposureRate;

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
         * 收入(分)
         */
        Integer income;

        /**
         * 广告千次曝光收益(分)
         */
        @JsonProperty("ecpm")
        Double ecpm;
    }
}
