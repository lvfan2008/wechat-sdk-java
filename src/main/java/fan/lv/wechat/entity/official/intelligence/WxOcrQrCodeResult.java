package fan.lv.wechat.entity.official.intelligence;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 二维码/条码识别结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxOcrQrCodeResult extends WxResult {

    /**
     * 识别结果列表
     */
    @JsonProperty("code_results")
    List<QrCodeResult> codeResults;

    /**
     * 图片位置
     */
    @JsonProperty("img_size")
    WxOcrDrivingCardResult.ImageSize imageSize;

    /**
     * 二维码/条码识别结果
     */
    @Data
    public static class QrCodeResult {
        /**
         * 类型名称：QR_CODE（二维码） EAN_13（条形码）
         */
        @JsonProperty("type_name")
        String typeName;

        /**
         * 识别内容
         */
        String data;

        /**
         * 位置
         */
        WxOcrDrivingCardResult.Pos pos;
    }
}
