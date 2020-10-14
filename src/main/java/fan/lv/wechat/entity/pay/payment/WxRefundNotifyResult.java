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
public class WxRefundNotifyResult extends WxCommonPayResult {

    /**
     * 加密信息请用商户秘钥进行解密
     */
    @XStreamAlias("req_info")
    String reqInfo;

    WxReqInfo decodeReqInfo;

    @Data
    public static class WxReqInfo {

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
         * 微信退款单号
         */
        @XStreamAlias("refund_id")
        String refundId;


        /**
         * 商户退款单号
         */
        @XStreamAlias("out_refund_no")
        String outRefundNo;


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
         * 退款总金额,单位为分
         */
        @XStreamAlias("refund_fee")
        Integer refundFee;


        /**
         * 退款金额=申请退款金额-非充值代金券退款金额，退款金额<=申请退款金额
         */
        @XStreamAlias("settlement_refund_fee")
        Integer settlementRefundFee;


        /**
         * 退款状态
         * SUCCESS-退款成功
         * CHANGE-退款异常
         * REFUNDCLOSE—退款关闭
         */
        @XStreamAlias("refund_status")
        Integer refundStatus;

        /**
         * 资金退款至用户帐号的时间，格式2017-12-15 09:46:01
         */
        @XStreamAlias("success_time")
        String successTime;


        /**
         * 取当前退款单的退款入账方  1）退回银行卡：  {银行名称}{卡类型}{卡尾号}  2）退回支付用户零钱:  支付用户零钱
         * 3）退还商户:  商户基本账户  商户结算银行账户  4）退回支付用户零钱通:  支付用户零钱通
         */
        @XStreamAlias("refund_recv_accout")
        String refundRecvAccout;


        /**
         * 退款资金来源
         * REFUND_SOURCE_RECHARGE_FUNDS 可用余额退款/基本账户
         * REFUND_SOURCE_UNSETTLED_FUNDS 未结算资金退款
         */
        @XStreamAlias("refund_account")
        String refundAccount;


        /**
         * API接口
         * VENDOR_PLATFORM商户平台
         */
        @XStreamAlias("refund_request_source")
        String refundRequestSource;

    }

}
