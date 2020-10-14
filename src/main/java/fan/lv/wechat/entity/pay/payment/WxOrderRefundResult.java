package fan.lv.wechat.entity.pay.payment;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import fan.lv.wechat.entity.result.WxCommonPayResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 统一下单结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxOrderRefundResult extends WxCommonPayResult {

    /**
     * 微信支付订单号
     */
    @XStreamAlias("transaction_id")
    String transactionId;


    /**
     * 商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一。
     */
    @XStreamAlias("out_trade_no")
    String outTradeNo;

    /**
     * 商户系统内部的退款单号，商户系统内部唯一，只能是数字、大小写字母_-|*@ ，同一退款单号多次请求只退一笔
     */
    @XStreamAlias("out_refund_no")
    String outRefundNo;

    /**
     * 微信退款单号
     */
    @XStreamAlias("refund_id")
    String refundId;

    /**
     * 退款总金额,单位为分,可以做部分退款
     */
    @XStreamAlias("refund_fee")
    Integer refundFee;

    /**
     * 去掉非充值代金券退款金额后的退款金额，退款金额=申请退款金额-非充值代金券退款金额，退款金额<=申请退款金额
     */
    @XStreamAlias("settlement_refund_fee")
    Integer settlementRefundFee;

    /**
     * 订单总金额，单位为分
     */
    @XStreamAlias("total_fee")
    Integer totalFee;

    /**
     * 当订单使用了免充值型优惠券后返回该参数，应结订单金额=订单金额-免充值优惠券金额
     */
    @XStreamAlias("settlement_total_fee")
    Integer settlementTotalFee;

    /**
     * 货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY
     */
    @XStreamAlias("fee_type")
    String feeType;


    /**
     * 现金支付金额订单现金支付金额
     */
    @XStreamAlias("cash_fee")
    Integer cashFee;

    /**
     * 	现金退款金额，单位为分，只能为整数
     */
    @XStreamAlias("cash_refund_fee")
    Integer cashRefundFee;

    /**
     * 	代金券退款金额<=退款金额，退款金额-代金券或立减优惠退款金额为现金
     */
    @XStreamAlias("coupon_refund_fee")
    Integer couponRefundFee;

    /**
     * 	退款代金券使用数量
     */
    @XStreamAlias("coupon_refund_count")
    Integer couponRefundCount;
}
