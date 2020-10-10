package fan.lv.wechat.entity.mp.operation;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 性能监控结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxGetPerformanceResult extends WxResult {

    /**
     * 错误查询数据(json字符串，结构如下所述的 strbody)
     */
    @JsonProperty("default_time_data")
    String defaultTimeData;

    /**
     * 比较数据
     */
    @JsonProperty("compare_time_data")
    String compareTimeData;

    @Data
    public static class DefaultTimeData {
        /**
         * 错误查询数据列表
         */
        List<StrBody> list;
    }

    @Data
    public static class StrBody {
        /**
         * 日期
         */
        @JsonProperty("ref_date")
        String refDate;

        /**
         * 1（启动总耗时）， 2（下载耗时），3（初次渲染耗时）
         */
        @JsonProperty("cost_time_type")
        Integer costTimeType;

        /**
         * 耗时(毫秒)
         */
        @JsonProperty("cost_time")
        Integer costTime;
    }
}
