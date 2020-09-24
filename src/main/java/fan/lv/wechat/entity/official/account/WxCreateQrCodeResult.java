package fan.lv.wechat.entity.official.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxCreateQrCodeResult extends WxResult {
    /**
     * 获取的二维码ticket，凭借此ticket可以在有效时间内换取二维码。
     */
    String ticket;

    /**
     * 该二维码有效时间，以秒为单位。 最大不超过2592000（即30天）。
     */
    @JsonProperty("expire_seconds")
    Integer expireSeconds;

    /**
     * 二维码图片解析后的地址，开发者可根据该地址自行生成需要的二维码图片
     */
    String url;

    /**
     * 通过ticket换取二维码,获取二维码ticket后，开发者可用ticket换取二维码图片。请注意，本接口无须登录态即可调用。
     *
     * @return 二维码图片Url
     */
    public String getTicketQrCodeUrl() {
        try {
            return "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=" + URLEncoder.encode(this.ticket, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

}
