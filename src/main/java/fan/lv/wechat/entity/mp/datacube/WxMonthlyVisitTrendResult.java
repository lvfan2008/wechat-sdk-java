package fan.lv.wechat.entity.mp.datacube;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 用户访问小程序数据月趋势(能查询到的最新数据为上一个自然月的数据
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxMonthlyVisitTrendResult extends WxResult {

    /**
     * 每日统计列表
     */
    List<MonthlyVisit> list;


    @Data
    public static class MonthlyVisit {

        /**
         * 时间，格式为 yyyymm，如："201702"
         */
        @JsonProperty("ref_date")
        String refDate;


        /**
         * 打开次数（自然月内汇总）
         */
        @JsonProperty("session_cnt")
        Integer sessionCnt;

        /**
         * 访问次数（自然月内汇总）
         */
        @JsonProperty("visit_pv")
        Integer visitPv;

        /**
         * 访问人数（自然月内去重）
         */
        @JsonProperty("visit_uv")
        Integer visitUv;

        /**
         * 新用户数（自然月内去重）
         */
        @JsonProperty("visit_uv_new")
        Integer visitUvNew;

        /**
         * 人均停留时长 (浮点型，单位：秒)
         */
        @JsonProperty("stay_time_uv")
        Double stayTimeUv;

        /**
         * 次均停留时长 (浮点型，单位：秒)
         */
        @JsonProperty("stay_time_session")
        Double stayTimeSession;

        /**
         * 平均访问深度 (浮点型)
         */
        @JsonProperty("visit_depth")
        Double visitDepth;
    }
}
