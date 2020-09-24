package fan.lv.wechat.entity.official.asset;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxMaterialCountResult extends WxResult {
    /**
     * 语音总数量
     */
    @JsonProperty("voice_count")
    Integer voiceCount;

    /**
     * 视频总数量
     */
    @JsonProperty("video_count")
    Integer videoCount;

    /**
     * 图片总数量
     */
    @JsonProperty("image_count")
    Integer imageCount;

    /**
     * 图文总数量
     */
    @JsonProperty("news_count")
    Integer newsCount;
}
