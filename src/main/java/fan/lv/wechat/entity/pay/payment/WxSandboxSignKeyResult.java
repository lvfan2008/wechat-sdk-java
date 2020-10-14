package fan.lv.wechat.entity.pay.payment;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import fan.lv.wechat.entity.pay.base.WxBasePayResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 沙箱支付密钥结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxSandboxSignKeyResult extends WxBasePayResult {

    /**
     * 微信支付分配的微信商户号
     */
    @XStreamAlias("mch_id")
    String mchId;

    /**
     * 返回的沙箱密钥
     */
    @XStreamAlias("sandbox_signkey")
    String sandboxSignKey;
}
