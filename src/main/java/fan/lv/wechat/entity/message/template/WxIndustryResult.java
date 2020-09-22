package fan.lv.wechat.entity.message.template;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxIndustryResult extends WxResult {
    /**
     * 第一行业
     */
    @JsonProperty("primary_industry")
    Industry primaryIndustry;

    /**
     * 第二行业
     */
    @JsonProperty("secondary_industry")
    Industry secondaryIndustry;

    @Data
    public static class Industry {
        /**
         * 主行业
         */
        @JsonProperty("first_class")
        String firstClass;

        /**
         * 副行业
         */
        @JsonProperty("second_class")
        String secondClass;
    }
}
