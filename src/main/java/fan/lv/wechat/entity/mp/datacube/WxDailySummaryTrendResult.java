package fan.lv.wechat.entity.mp.datacube;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 用户访问小程序数据概况
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxDailySummaryTrendResult extends WxResult {

    /**
     * 每日统计列表
     */
    List<DailySummary> list;


    @Data
    public static class DailySummary {

        /**
         * 日期
         */
        @JsonProperty("ref_date")
        String refDate;


        /**
         * 累计用户数
         */
        @JsonProperty("visit_total")
        Integer visitTotal;

        /**
         * 转发次数
         */
        @JsonProperty("share_pv")
        Integer sharePv;

        /**
         * 转发人数
         */
        @JsonProperty("share_uv")
        Integer shareUv;
    }
}
