package fan.lv.wechat.entity.open.mp.basicinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 微信认证名称检测结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxVerifyNicknameResult extends WxResult {

    /**
     * 是否命中关键字策略。若命中，可以选填关键字材料
     */
    @JsonProperty("hit_condition")
    Boolean hitCondition;


    /**
     * 命中关键字的说明描述
     */
    @JsonProperty("wording")
    String wording;
}
