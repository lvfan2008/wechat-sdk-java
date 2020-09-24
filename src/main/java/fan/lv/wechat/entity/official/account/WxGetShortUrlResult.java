package fan.lv.wechat.entity.official.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxGetShortUrlResult extends WxResult {
    /**
     * 短链接
     */
    @JsonProperty("short_url")
    String shortUrl;
}
