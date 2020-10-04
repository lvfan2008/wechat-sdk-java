package fan.lv.wechat.entity.mp.datacube;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 每日留存统计
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxDailyRetainInfoResult extends WxResult {

    /**
     * 日期
     */
    @JsonProperty("ref_date")
    String refDate;


    /**
     * 新增用户留存
     */
    @JsonProperty("visit_uv_new")
    List<VisitUv> visitUvNew;

    /**
     * 活跃用户留存
     */
    @JsonProperty("visit_uv")
    List<VisitUv> visitUv;

    /**
     * 用户留存
     */
    @Data
    public static class VisitUv {
        /**
         * 标识，0开始，表示当天，1表示1天后。依此类推，key取值分别是：0,1,2,3,4,5,6,7,14,30
         */
        Integer key;

        /**
         * key对应日期的新增用户数/活跃用户数（key=0时）或留存用户数（k>0时）
         */
        Integer value;
    }

}
