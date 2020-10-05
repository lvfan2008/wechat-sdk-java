package fan.lv.wechat.entity.mp.qrcode;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 获取小程序码参数
 *
 * @author lv_fan2008
 */
@Data
@NoArgsConstructor
public class WxGetMpCodeParam {
    /**
     * 扫码进入的小程序页面路径，最大长度 128 字节，不能为空；对于小游戏，可以只传入 query 部分，来实现传参效果，
     * 如：传入 "?foo=bar"，即可在 wx.getLaunchOptionsSync 接口中的 query 参数获取到 {foo:"bar"}
     */
    String path;

    /**
     * 二维码的宽度，单位 px。最小 280px，最大 1280px,默认值430，可为null
     */
    Integer width = 430;

    /**
     * 自动配置线条颜色，如果颜色依然是黑色，则说明不建议配置主色调
     */
    @JsonProperty("auto_color")
    Boolean autoColor = false;

    /**
     * {"r":0,"g":0,"b":0}	否	auto_color 为 false 时生效，使用 rgb 设置颜色 例如 {"r":"xxx","g":"xxx","b":"xxx"} 十进制表示
     */
    @JsonProperty("line_color")
    LineColor lineColor;


    /**
     * 是否需要透明底色，为 true 时，生成透明底色的小程序码
     */
    @JsonProperty("is_hyaline")
    Boolean isHyaline = false;


    public WxGetMpCodeParam(String path) {
        this.path = path;
    }

    @Data
    public static class LineColor {
        /**
         * 红色值：0-255
         */
        Integer r;

        /**
         * 绿色值：0-255
         */
        Integer g;

        /**
         * 蓝色值：0-255
         */
        Integer b;
    }
}
