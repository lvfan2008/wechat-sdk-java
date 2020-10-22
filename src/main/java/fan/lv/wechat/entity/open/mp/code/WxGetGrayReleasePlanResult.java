package fan.lv.wechat.entity.open.mp.code;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 提交审核结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxGetGrayReleasePlanResult extends WxResult {

    /**
     * 分阶段发布计划详情
     */
    @JsonProperty("gray_release_plan")
    GrayReleasePlan grayReleasePlan;

    @Data
    public static class GrayReleasePlan {
        /**
         * 0:初始状态 1:执行中 2:暂停中 3:执行完毕 4:被删除
         */
        Integer status;

        /**
         * 分阶段发布计划的创建事件
         */
        @JsonProperty("create_timestamp")
        Integer createTimestamp;


        /**
         * 当前的灰度比例
         */
        @JsonProperty("gray_percentage")
        Integer grayPercentage;

    }
}
