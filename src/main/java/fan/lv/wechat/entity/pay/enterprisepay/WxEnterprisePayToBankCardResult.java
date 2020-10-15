package fan.lv.wechat.entity.pay.enterprisepay;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import fan.lv.wechat.entity.pay.base.WxCommonPayResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 企业付款到银行卡结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxEnterprisePayToBankCardResult extends WxCommonPayResult {

    /**
     * 微信支付分配的商户号
     */
    @XStreamAlias("mch_id")
    String mchId;

    /**
     * 商户订单号，需要保持唯一
     */
    @XStreamAlias("partner_trade_no")
    String partnerTradeNo;


    /**
     * 代付金额RMB:分
     */
    @XStreamAlias("amount")
    Integer amount;


    /**
     * 代付成功后，返回的内部业务单号
     */
    @XStreamAlias("payment_no")
    String paymentNo;

    /**
     * 手续费金额 RMB：分
     */
    @XStreamAlias("cmms_amt")
    Integer cmmsAmt;
}
