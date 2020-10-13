package fan.lv.wechat.api.payment.service;

import fan.lv.wechat.entity.pay.commonpay.*;
import fan.lv.wechat.entity.result.WxCommonPayResult;

import java.util.Map;

/**
 * @author lv_fan2008
 */
public interface PaymentService {
    /**
     * 统一下单
     *
     * @param outTradeNo     商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*且在同一个商户号下唯一
     * @param totalFee       订单总金额，只能为整数
     * @param tradeType      JSAPI -JSAPI支付  NATIVE -Native支付 APP -APP支付
     * @param body           商品描述交易字段格式根据不同的应用场景建议按照以下格式上传：
     *                       （1）PC网站——传入浏览器打开的网站主页title名-实际商品名称，例如：腾讯充值中心-QQ会员充值；
     *                       （2） 公众号——传入公众号名称-实际商品名称，例如：腾讯形象店- image-QQ公仔；
     *                       （3） H5——应用在浏览器网页上的场景，传入浏览器打开的移动网页的主页title名-实际商品名称，例如：腾讯充值中心-QQ会员充值；
     *                       （4） 线下门店——门店品牌名-城市分店名-实际商品名称，例如： image形象店-深圳腾大- QQ公仔）
     *                       （5） APP——需传入应用市场上的APP名字-实际商品名称，天天爱消除-游戏充值。
     * @param openId         trade_type=JSAPI，此参数必传，用户在商户appid下的唯一标识。
     * @param spBillCreateIp 支持IPV4和IPV6两种格式的IP地址。调用微信支付API的机器IP
     * @param others         其他参数，参考官方接口文档
     * @return 统一下单结果
     */
    WxUnifiedOrderResult unifiedOrder(String outTradeNo, Integer totalFee, String tradeType, String body,
                                      String openId, String spBillCreateIp, Map<String, String> others);


    /**
     * 查询订单
     *
     * @param outTradeNo    微信的订单号，建议优先使用，outTradeNo 和 transactionId二选一
     * @param transactionId 商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一，outTradeNo 和 transactionId二选一
     * @return 查询订单结果
     */
    WxOrderQueryResult orderQuery(String outTradeNo, String transactionId);


    /**
     * 关闭订单
     *
     * @param outTradeNo 商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一
     * @return 关闭订单结果
     */
    WxCommonPayResult closeOrder(String outTradeNo);

    /**
     * 申请退款
     *
     * @param outTradeNo    商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一，outTradeNo 和 transactionId二选一
     * @param transactionId 微信的订单号，建议优先使用，outTradeNo 和 transactionId二选一
     * @param outRefundNo   商户系统内部的退款单号，商户系统内部唯一，只能是数字、大小写字母_-|*@ ，同一退款单号多次请求只退一笔。
     * @param totalFee      订单总金额，单位为分，只能为整数
     * @param refundFee     退款总金额，单位为分，只能为整数，可部分退款
     * @param others        其他参数，参考官方接口文档
     * @return 申请退款结果
     */
    WxOrderRefundResult orderRefund(String outTradeNo, String transactionId, String outRefundNo, Integer totalFee,
                                    Integer refundFee, Map<String, String> others);

    /**
     * 查询退款
     *
     * @param outTradeNo    商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一
     * @param transactionId 微信的订单号，建议优先使用
     * @param outRefundNo   商户系统内部的退款单号，商户系统内部唯一，只能是数字、大小写字母_-|*@ ，同一退款单号多次请求只退一笔
     * @param refundId      微信退款单号 refund_id、out_refund_no、out_trade_no、transaction_id四个参数必填一个，
     *                      如果同时存在优先级为： >out_refund_no>transaction_id>out_trade_no
     * @param offset        偏移量，当部分退款次数超过10次时可使用，表示返回的查询结果从这个偏移量开始取记录
     * @return 查询退款结果
     */
    WxRefundQueryResult refundQuery(String outTradeNo, String transactionId, String outRefundNo, String refundId, Integer offset);

    /**
     * 查询退款
     *
     * @param outTradeNo    商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一
     * @param transactionId 微信的订单号，建议优先使用
     * @param outRefundNo   商户系统内部的退款单号，商户系统内部唯一，只能是数字、大小写字母_-|*@ ，同一退款单号多次请求只退一笔
     * @param refundId      微信退款单号 refund_id、out_refund_no、out_trade_no、transaction_id四个参数必填一个，
     *                      如果同时存在优先级为： >out_refund_no>transaction_id>out_trade_no
     * @return 查询退款结果
     */
    default WxRefundQueryResult refundQuery(String outTradeNo, String transactionId, String outRefundNo, String refundId) {
        return refundQuery(outTradeNo, transactionId, outRefundNo, refundId, null);
    }

    /**
     * 下载交易账单
     *
     * @param billDate 下载对账单的日期，格式：20140603
     * @param billType ALL，返回当日所有订单信息，默认值 SUCCESS，返回当日成功支付的订单 REFUND，返回当日退款订单 RECHARGE_REFUND，返回当日充值退款订单
     * @param tarType  非必传参数，固定值：GZIP，返回格式为.gzip的压缩包账单。不传则默认为数据流形式。
     * @return 交易账单, 成功数据库在content属性，否则查看错误原因
     */
    WxDownloadBillResult downloadBill(String billDate, String billType, String tarType);

    /**
     * 通过付款码查询公众号Openid，调用查询后，该付款码只能由此商户号发起扣款，直至付款码更新。
     *
     * @param authCode 扫码支付付款码，设备读取用户微信中的条码或者二维码信息
     * @return 公众号Openid
     */
    WxAuthCodeToOpenIdResult authCodeToOpenId(String authCode);

    /**
     * 解析退款通知结果
     *
     * @param xml 退款通知的xml
     * @return 退款通知结果
     */
    WxRefundNotifyResult refundNotifyParse(String xml);
}
