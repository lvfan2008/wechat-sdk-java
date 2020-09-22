package fan.lv.wechat.entity.message.template;

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
public class WxGetTemplateIdParam {
    /**
     * 模板库中模板的编号，有“TM**”和“OPENTMTM**”等形式
     */
    @JsonProperty("template_id_short")
    String templateIdShort;
}
