package fan.lv.wechat.entity.pay.payment;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import fan.lv.wechat.entity.result.WxCommonPayResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 退款查询结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxRefundQueryResult extends WxCommonPayResult {

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
     * 当前返回退款笔数
     */
    @XStreamAlias("refund_count")
    Integer refundCount;


    /**
     * 订单总共已发生的部分退款次数，当请求参数传入offset后有返回
     */
    @XStreamAlias("total_refund_count")
    Integer totalRefundCount;

}
