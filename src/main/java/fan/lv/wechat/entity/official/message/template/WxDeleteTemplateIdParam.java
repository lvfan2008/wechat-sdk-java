package fan.lv.wechat.entity.official.message.template;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lv_fan2008
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WxDeleteTemplateIdParam {
    /**
     * 模板ID
     */
    @JsonProperty("template_id")
    String templateId;
}
