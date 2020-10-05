package fan.lv.wechat.entity.mp.qrcode;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 获取无限制小程序码参数
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class WxGetUnlimitedMpCodeParam extends WxGetMpCodeParam {
    /**
     * 最大32个可见字符，只支持数字，大小写英文以及部分特殊字符：!#$&'()*+,/:;=?@-._~，
     * 其它字符请自行编码为合法字符（因不支持%，中文无法使用 urlencode 处理，请使用其他编码方式）
     */
    String scene;

    public WxGetUnlimitedMpCodeParam(String scene) {
        this.scene = scene;
    }

    public WxGetUnlimitedMpCodeParam(String path, String scene) {
        super(path);
        this.scene = scene;
    }
}
