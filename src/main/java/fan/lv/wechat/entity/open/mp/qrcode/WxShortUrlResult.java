package fan.lv.wechat.entity.open.mp.qrcode;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 将二维码长链接转成短链接结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxShortUrlResult extends WxResult {

    /**
     * 短链接
     */
    @JsonProperty("short_url")
    String shortUrl;
}
