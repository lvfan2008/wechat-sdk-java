package fan.lv.wechat.entity.official.statics;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 接口分析数据结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxInterfaceSummaryResult extends WxResult {

    /**
     * 每日接口数据列表
     */
    List<InterfaceSummaryDay> list;


    @Data
    public static class InterfaceSummaryDay {

        /**
         * 数据的日期
         */
        @JsonProperty("ref_date")
        String refDate;

        /**
         * 通过服务器配置地址获得消息后，被动回复用户消息的次数
         */
        @JsonProperty("callback_count")
        Integer callbackCount;

        /**
         * 上述动作的失败次数
         */
        @JsonProperty("fail_count")
        Double failCount;

        /**
         * 总耗时，除以callback_count即为平均耗时
         */
        @JsonProperty("total_time_cost")
        Integer totalTimeCost;

        /**
         * 最大耗时
         */
        @JsonProperty("max_time_cost")
        Integer maxTimeCost;
    }
}
