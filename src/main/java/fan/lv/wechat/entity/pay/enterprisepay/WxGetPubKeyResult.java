package fan.lv.wechat.entity.pay.enterprisepay;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import fan.lv.wechat.entity.pay.base.WxCommonPayResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 获取公钥结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxGetPubKeyResult extends WxCommonPayResult {

    /**
     * 微信支付分配的商户号
     */
    @XStreamAlias("mch_id")
    String mchId;

    /**
     * RSA 公钥
     */
    @XStreamAlias("pub_key")
    String pubKey;
}
