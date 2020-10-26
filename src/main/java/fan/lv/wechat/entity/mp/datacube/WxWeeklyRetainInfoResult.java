package fan.lv.wechat.entity.mp.datacube;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 用户访问小程序周留存
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxWeeklyRetainInfoResult extends WxResult {

    /**
     * 时间，如："20170306-20170312"
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
         * 标识，0开始，表示当周，1表示1周后。依此类推，取值分别是：0,1,2,3,4
         */
        Integer key;

        /**
         * key对应日期的新增用户数/活跃用户数（key=0时）或留存用户数（k>0时）
         */
        Integer value;
    }

}
