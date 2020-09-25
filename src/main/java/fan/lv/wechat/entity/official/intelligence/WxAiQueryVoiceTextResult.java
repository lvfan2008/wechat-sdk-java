package fan.lv.wechat.entity.official.intelligence;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 语音识别结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxAiQueryVoiceTextResult extends WxResult {
    /**
     * 语音识别结果
     */
    String result;

    /**
     * 是否完成
     */
    @JsonProperty("is_end")
    Boolean isEnd;
}
