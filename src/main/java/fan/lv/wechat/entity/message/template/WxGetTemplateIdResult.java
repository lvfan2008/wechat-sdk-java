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
public class WxGetTemplateIdResult extends WxResult {
    /**
     * 模板ID
     */
    @JsonProperty("template_id")
    String templateId;
}
