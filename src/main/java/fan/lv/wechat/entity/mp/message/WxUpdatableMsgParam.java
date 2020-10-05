package fan.lv.wechat.entity.mp.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 修改被分享的动态消息参数
 *
 * @author lv_fan2008
 * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/updatable-message/updatableMessage.setUpdatableMsg.html" target="_blank">微信官方文档</a>
 */
@Data
public class WxUpdatableMsgParam {
    /**
     * 动态消息的 ID
     */
    @JsonProperty("activity_id")
    String activityId;

    /**
     * 动态消息修改后的状态,0 未开始	1 已开始
     */
    @JsonProperty("target_state")
    Integer targetState;

    /**
     * 动态消息对应的模板信息
     */
    @JsonProperty("template_info")
    TemplateInfo templateInfo;

    @Data
    public static class TemplateInfo {
        /**
         * 参数列表
         */
        @JsonProperty("parameter_list")
        List<TemplateParameter> parameterList;
    }

    @Data
    public static class TemplateParameter {
        /**
         * 要修改的参数名
         */
        String name;

        /**
         * 修改后的参数值
         */
        String value;
    }

}
