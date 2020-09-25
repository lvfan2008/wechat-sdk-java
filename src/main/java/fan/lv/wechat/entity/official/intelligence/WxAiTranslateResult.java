package fan.lv.wechat.entity.official.intelligence;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 微信翻译结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxAiTranslateResult extends WxResult {
    /**
     * 源语言翻译内容
     */
    @JsonProperty("from_content")
    String fromContent;

    /**
     * 目标语言翻译内容
     */
    @JsonProperty("to_content")
    String toContent;
}
