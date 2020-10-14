package fan.lv.wechat.entity.pay.payment;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import fan.lv.wechat.entity.pay.base.WxCommonPayResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 通过付款码查询公众号Openid结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxAuthCodeToOpenIdResult extends WxCommonPayResult {

    /**
     * 用户在商户appid下的唯一标识
     */
    @XStreamAlias("openid")
    String openId;

    /**
     * 用户在子商户appid下的唯一标识
     */
    @XStreamAlias("sub_openid")
    String subOpenId;
}
