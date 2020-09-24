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
public class WxGetTemporaryMaterialResult extends WxResult {
    /**
     *
     */
    @JsonProperty("video_url")
    String videoUrl;
}
