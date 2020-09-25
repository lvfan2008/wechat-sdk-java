package fan.lv.wechat.entity.official.intelligence;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.smartcardio.Card;

/**
 * 行驶证OCR识别结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxOcrDrivingCardResult extends WxResult {
    /**
     * 车牌号码
     */
    @JsonProperty("plate_num")
    String plateNum;

    /**
     * 车辆类型
     */
    @JsonProperty("vehicle_type")
    String vehicleType;

    /**
     * 所有人
     */
    String owner;

    /**
     * 住址
     */
    String addr;

    /**
     * 使用性质
     */
    @JsonProperty("use_character")
    String useCharacter;

    /**
     * 品牌型号
     */
    String model;

    /**
     * 车辆识别代号
     */
    String vin;

    /**
     * 发动机号码
     */
    @JsonProperty("engine_num")
    String engineNum;

    /**
     * 注册日期
     */
    @JsonProperty("register_date")
    String registerDate;

    /**
     * 发证日期
     */
    @JsonProperty("issue_date")
    String issueDate;

    /**
     * 车牌号码
     */
    @JsonProperty("plate_num_b")
    String plateNumB;

    /**
     * 号牌
     */
    String record;

    /**
     * 核定载人数
     */
    @JsonProperty("passengers_num")
    String passengersNum;

    /**
     * 总质量
     */
    @JsonProperty("total_quality")
    String totalQuality;

    /**
     * 整备质量
     */
    @JsonProperty("prepare_quality")
    String prepareQuality;

    /**
     * 外廓尺寸
     */
    @JsonProperty("overall_size")
    String overallSize;

    /**
     * 卡片正面位置（检测到卡片正面才会返回）
     */
    @JsonProperty("card_position_front")
    CardPos cardPositionFront;

    /**
     * 卡片反面位置（检测到卡片反面才会返回）
     */
    @JsonProperty("card_position_back")
    CardPos cardPositionBack;

    /**
     * 图片大小
     */
    @JsonProperty("img_size")
    ImageSize imageSize;

    @Data
    public static class Point {
        /**
         * x轴位置
         */
        Integer x;

        /**
         * y轴位置
         */
        Integer y;
    }

    @Data
    public static class Pos {
        /**
         * 左上角
         */
        @JsonProperty("left_top")
        Point leftTop;

        /**
         * 右上角
         */
        @JsonProperty("right_top")
        Point rightTop;

        /**
         * 右下角
         */
        @JsonProperty("right_bottom")
        Point rightBottom;

        /**
         * 左下角
         */
        @JsonProperty("left_bottom")
        Point leftBottom;
    }

    @Data
    public static class CardPos {
        /**
         * 卡片位置
         */
        Pos pos;
    }

    @Data
    public static class ImageSize {
        /**
         * 图片宽度
         */
        Integer w;

        /**
         * 图片高度
         */
        Integer h;
    }

}
