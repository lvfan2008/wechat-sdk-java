package fan.lv.wechat.entity.pay.enterprisepay;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import fan.lv.wechat.entity.pay.base.WxCommonPayResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 查询企业付款到银行卡结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxQueryPayToBankCardResult extends WxCommonPayResult {

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
     * 微信企业付款单号
     */
    @XStreamAlias("payment_no")
    String paymentNo;

    /**
     * 收款用户银行卡号(MD5加密)
     */
    @XStreamAlias("bank_no_md5")
    String bankNoMd5;

    /**
     * 收款人真实姓名（MD5加密）
     */
    @XStreamAlias("true_name_md5")
    String trueNameMd5;


    /**
     * 代付金额RMB:分
     */
    @XStreamAlias("amount")
    Integer amount;


    /**
     * 代付订单状态：
     * PROCESSING（处理中，如有明确失败，则返回额外失败原因；否则没有错误原因）
     * SUCCESS（付款成功）
     * FAILED（付款失败,需要替换付款单号重新发起付款）
     * BANK_FAIL（银行退票，订单状态由付款成功流转至退票,退票时付款金额和手续费会自动退还）
     */
    @XStreamAlias("status")
    String status;

    /**
     * 手续费金额 RMB：分
     */
    @XStreamAlias("cmms_amt")
    Integer cmmsAmt;

    /**
     * 商户下单时间, 微信侧订单创建时间
     */
    @XStreamAlias("create_time")
    String createTime;


    /**
     * 成功付款时间，微信侧付款成功时间（依赖银行的处理进度，可能出现延迟返回，甚至被银行退票的情况）
     */
    @XStreamAlias("pay_succ_time")
    String paySuccTime;


    /**
     * 订单失败原因（如：余额不足）
     */
    @XStreamAlias("reason")
    String reason;
}
