package fan.lv.wechat.entity.official.intelligence;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 智能裁剪结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxImageAiCropResult extends WxResult {

    /**
     * 智能裁剪结果
     */
    List<CropRect> results;

    /**
     * 图片大小
     */
    @JsonProperty("img_size")
    WxOcrDrivingCardResult.ImageSize imageSize;

    @Data
    public static class CropRect {
        /**
         * crop left pos
         */
        @JsonProperty("crop_left")
        Integer cropLeft;

        /**
         * crop top pos
         */
        @JsonProperty("crop_top")
        Integer cropTop;

        /**
         * crop right pos
         */
        @JsonProperty("crop_right")
        Integer cropRight;

        /**
         * crop bottom pos
         */
        @JsonProperty("crop_bottom")
        Integer cropBottom;
    }
}
