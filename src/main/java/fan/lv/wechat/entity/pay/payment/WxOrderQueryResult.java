package fan.lv.wechat.entity.pay.payment;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import fan.lv.wechat.entity.result.WxCommonPayResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 订单查询结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxOrderQueryResult extends WxCommonPayResult {

    /**
     * 调用接口提交的终端设备号
     */
    @XStreamAlias("device_info")
    String deviceInfo;

    /**
     * 用户在商户appid下的唯一标识
     */
    @XStreamAlias("openid")
    String openId;

    /**
     * 用户是否关注公众账号，Y-关注，N-未关注
     */
    @XStreamAlias("is_subscribe")
    String isSubscribe;

    /**
     * 调用接口提交的交易类型，取值如下：JSAPI，NATIVE，APP，MICROPAY
     */
    @XStreamAlias("trade_type")
    String tradeType;

    /**
     * SUCCESS—支付成功  REFUND—转入退款 NOTPAY—未支付  CLOSED—已关闭 REVOKED—已撤销（付款码支付）
     * USERPAYING--用户支付中（付款码支付） PAYERROR--支付失败(其他原因，如银行返回失败)
     */
    @XStreamAlias("trade_state")
    String tradeState;

    /**
     * 银行类型，采用字符串类型的银行标识
     */
    @XStreamAlias("bank_type")
    String bankType;

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
     * 货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY
     */
    @XStreamAlias("cash_fee_type")
    String cashFeeType;


    /**
     * “代金券”金额<=订单金额，订单金额-“代金券”金额=现金支付金额
     */
    @XStreamAlias("coupon_fee")
    Integer couponFee;


    /**
     * 代金券使用数量
     */
    @XStreamAlias("coupon_count")
    Integer couponCount;


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
     * 附加数据，原样返回
     */
    @XStreamAlias("attach")
    String attach;

    /**
     * 订单支付时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010
     */
    @XStreamAlias("time_end")
    String timeEnd;

    /**
     * 对当前查询订单状态的描述和下一步操作的指引
     */
    @XStreamAlias("trade_state_desc")
    String tradeStateDesc;
}
