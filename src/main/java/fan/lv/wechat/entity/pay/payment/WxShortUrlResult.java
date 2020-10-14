package fan.lv.wechat.entity.pay.payment;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import fan.lv.wechat.entity.result.WxCommonPayResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 转换短链接结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxShortUrlResult extends WxCommonPayResult {

    /**
     * 转换后的URL
     */
    @XStreamAlias("short_url")
    String shortUrl;
}
