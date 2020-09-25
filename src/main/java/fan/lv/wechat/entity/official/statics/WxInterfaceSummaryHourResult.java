package fan.lv.wechat.entity.official.statics;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 接口分析分时数据
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxInterfaceSummaryHourResult extends WxResult {

    /**
     * 分时接口数据列表
     */
    List<InterfaceSummaryHour> list;


    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class InterfaceSummaryHour extends WxInterfaceSummaryResult.InterfaceSummaryDay {

        /**
         * 数据的小时
         */
        @JsonProperty("ref_hour")
        Integer refHour;
    }
}
