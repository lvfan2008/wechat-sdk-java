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
public class WxPublisherSettlementResult extends WxResult {
    /**
     * 返回码信息
     */
    @JsonProperty("base_resp")
    WxPublisherAdPosGeneralResult.BaseResp baseResp;

    /**
     * 主体名称
     */
    String body;

    /**
     * 扣除金额
     */
    @JsonProperty("penalty_all")
    Integer penaltyAll;

    /**
     * 累计收入
     */
    @JsonProperty("revenue_all")
    Integer revenueAll;

    /**
     * 已结算金额
     */
    @JsonProperty("settled_revenue_all")
    Integer settledRevenueAll;

    /**
     * 结算列表
     */
    @JsonProperty("settlement_list")
    List<Settlement> settlementList;

    /**
     * 请求返回总条数
     */
    @JsonProperty("total_num")
    Integer totalNum;

    /**
     * 结算信息
     */
    @Data
    public static class Settlement {
        /**
         * 数据更新时间
         */
        String date;

        /**
         * 日期区间
         */
        String zone;

        /**
         * 收入月份
         */
        String month;

        /**
         * 1 = 上半月，2 = 下半月
         */
        Integer order;

        /**
         * 1 = 结算中；2、3 = 已结算；4 = 付款中；5 = 已付款
         */
        @JsonProperty("sett_status")
        Integer settStatus;

        /**
         * 区间内结算收入
         */
        @JsonProperty("settled_revenue")
        Integer settledRevenue;

        /**
         * 结算单编号
         */
        @JsonProperty("sett_no")
        String settNo;

        /**
         * 申请补发结算单次数
         */
        @JsonProperty("mail_send_cnt")
        String mailSendCnt;

        /**
         * 广告位结算列表
         */
        @JsonProperty("slot_revenue")
        List<SlotRevenue> slotRevenues;
    }

    /**
     * 广告位结算信息
     */
    @Data
    public static class SlotRevenue {
        /**
         * 产生收入的广告位
         */
        @JsonProperty("slot_id")
        String slotId;

        /**
         * 该广告位结算金额
         */
        @JsonProperty("slot_settled_revenue")
        Integer slotSettledRevenue;
    }
}
