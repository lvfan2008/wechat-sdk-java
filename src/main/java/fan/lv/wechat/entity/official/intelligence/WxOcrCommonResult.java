package fan.lv.wechat.entity.official.intelligence;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 通用印刷体OCR识别结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxOcrCommonResult extends WxResult {

    /**
     * 识别结果
     */
    List<Item> items;

    /**
     * 图片大小
     */
    @JsonProperty("img_size")
    WxOcrDrivingCardResult.ImageSize imageSize;


    /**
     * 识别项
     */
    @Data
    public static class Item {
        /**
         * 识别文字
         */
        String text;

        /**
         * 文字位置
         */
        WxOcrDrivingCardResult.Pos pos;
    }
}
