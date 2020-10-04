package fan.lv.wechat.entity.mp.datacube;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 用户访问小程序数据日趋势
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxDailyVisitTrendResult extends WxResult {

    /**
     * 每月统计列表
     */
    List<MonthlyVisit> list;


    @Data
    public static class MonthlyVisit {

        /**
         * 日期，格式为 yyyymmdd
         */
        @JsonProperty("ref_date")
        String refDate;


        /**
         * 打开次数
         */
        @JsonProperty("session_cnt")
        Integer sessionCnt;

        /**
         * 访问次数
         */
        @JsonProperty("visit_pv")
        Integer visitPv;

        /**
         * 访问人数
         */
        @JsonProperty("visit_uv")
        Integer visitUv;

        /**
         * 新用户数
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
