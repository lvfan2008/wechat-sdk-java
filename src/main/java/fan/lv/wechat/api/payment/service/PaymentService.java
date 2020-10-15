package fan.lv.wechat.api.payment.service;

import fan.lv.wechat.entity.pay.payment.*;
import fan.lv.wechat.entity.pay.base.WxBasePayResult;
import fan.lv.wechat.entity.pay.base.WxCommonPayResult;

import java.util.Map;

/**
 * @author lv_fan2008
 */
public interface PaymentService {
    /**
     * 付款码支付
     *
     * @param outTradeNo     商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*且在同一个商户号下唯一
     * @param totalFee       订单总金额，只能为整数
     * @param body           商品或支付单简要描述，格式要求：门店品牌名-城市分店名-实际商品名称
     * @param authCode       扫码支付付款码，设备读取用户微信中的条码或者二维码信息
     *                       （注：用户付款码条形码规则：18位纯数字，以10、11、12、13、14、15开头）
     * @param spBillCreateIp 支持IPV4和IPV6两种格式的IP地址。调用微信支付API的机器IP
     * @param others         其他参数，参考官方接口文档
     * @return 付款码支付结果
     */
    WxMicroPayResult microPay(String outTradeNo, Integer totalFee, String body,
                              String authCode, String spBillCreateIp, Map<String, String> others);

    /**
     * 提交刷卡支付，针对软POS，尽可能做成功,内置重试机制，最多60s
     *
     * @param outTradeNo     商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*且在同一个商户号下唯一
     * @param totalFee       订单总金额，只能为整数
     * @param body           商品或支付单简要描述，格式要求：门店品牌名-城市分店名-实际商品名称
     * @param authCode       扫码支付付款码，设备读取用户微信中的条码或者二维码信息
     *                       （注：用户付款码条形码规则：18位纯数字，以10、11、12、13、14、15开头）
     * @param spBillCreateIp 支持IPV4和IPV6两种格式的IP地址。调用微信支付API的机器IP
     * @param others         其他参数，参考官方接口文档
     * @return 付款码支付结果
     */
    WxMicroPayResult microPayByPos(String outTradeNo, Integer totalFee, String body,
                                   String authCode, String spBillCreateIp, Map<String, String> others);

    /**
     * 撤销订单
     * 支付交易返回失败或支付系统超时，调用该接口撤销交易。如果此订单用户支付失败，微信支付系统会将此订单关闭；
     * 如果用户支付成功，微信支付系统会将此订单资金退还给用户。
     * 注意：7天以内的交易单可调用撤销，其他正常支付的单如需实现相同功能请调用申请退款API。
     * 提交支付交易后调用【查询订单API】，没有明确的支付结果再调用【撤销订单API】。
     * 调用支付接口后请勿立即调用撤销订单API，建议支付后至少15s后再调用撤销订单接口。
     *
     * @param outTradeNo    微信的订单号，建议优先使用，outTradeNo 和 transactionId二选一
     * @param transactionId 商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一，outTradeNo 和 transactionId二选一
     * @return 付款码支付结果
     */
    WxPayReverseResult reverse(String outTradeNo, String transactionId);

    /**
     * 通过付款码查询公众号Openid，调用查询后，该付款码只能由此商户号发起扣款，直至付款码更新。
     *
     * @param authCode 扫码支付付款码，设备读取用户微信中的条码或者二维码信息
     * @return 公众号Openid
     */
    WxAuthCodeToOpenIdResult authCodeToOpenId(String authCode);

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
     * 下载资金账单
     * <p>
     * 商户可以通过该接口下载自2017年6月1日起 的历史资金流水账单。
     * <p>
     * 说明：
     * <p>
     * 1、资金账单中的数据反映的是商户微信账户资金变动情况；
     * <p>
     * 2、当日账单在次日上午9点开始生成，建议商户在上午10点以后获取；
     * <p>
     * 3、资金账单中涉及金额的字段单位为“元”。
     *
     * @param billDate 下载对账单的日期，格式：20140603
     * @param billType 账单的资金来源账户： Basic  基本账户 Operation 运营账户 Fees 手续费账户
     * @param tarType  非必传参数，固定值：GZIP，返回格式为.gzip的压缩包账单。不传(null)则默认为数据流形式。
     * @return 资金账单
     */
    WxDownloadFundFlowResult downloadFundFlow(String billDate, String billType, String tarType);

    /**
     * 拉取订单评价数据
     *
     * @param beginTime 按用户评论时间批量拉取的起始时间，格式为yyyyMMddHHmmss
     * @param endTime   按用户评论时间批量拉取的结束时间，格式为yyyyMMddHHmmss
     * @param offset    指定从某条记录的下一条开始返回记录。接口调用成功时，会返回本次查询最后一条数据的offset。
     *                  商户需要翻页时，应该把本次调用返回的offset 作为下次调用的入参。注意offset是评论数据在微信支付后台保存的索引，未必是连续的
     * @param limit     一次拉取的条数, 最大值是200，默认是200
     * @return 订单评价数据
     */
    WxBatchQueryCommentResult batchQueryComment(String beginTime, String endTime, Integer offset, Integer limit);

    /**
     * 解析退款通知结果
     *
     * @param longUrl 退款通知的xml
     * @return 退款通知结果
     */
    WxShortUrlResult shortUrl(String longUrl);


    /**
     * 交易保障
     * <p>
     * 商户在调用微信支付提供的相关接口时，会得到微信支付返回的相关信息以及获得整个接口的响应时间。
     * 为提高整体的服务水平，协助商户一起提高服务质量，微信支付提供了相关接口调用耗时和返回信息的主动上报接口，
     * 微信支付可以根据商户侧上报的数据进一步优化网络部署，完善服务监控，和商户更好的协作为用户提供更好的业务体验。
     *
     * @param interfaceUrl 上报对应的接口的完整URL，类似： https://api.mch.weixin.qq.com/pay/unifiedorder
     * @param executeTime  接口耗时情况，单位为毫秒
     * @param returnCode   SUCCESS/FAIL 此字段是通信标识，非交易标识，交易是否成功需要查看trade_state来判断
     * @param resultCode   业务结果, SUCCESS/FAIL
     * @param userIp       发起接口调用时的机器IP
     * @param others       其他参数，参考官方文档
     * @return 返回结果
     */
    WxBasePayResult report(String interfaceUrl, Integer executeTime, String returnCode, String resultCode,
                           String userIp, Map<String, String> others);


    /**
     * 解析退款通知结果
     *
     * @param xml 退款通知的xml
     * @return 退款通知结果
     */
    WxRefundNotifyResult refundNotifyParse(String xml);

    /**
     * 支付通知结果
     *
     * @param xml 支付通知的xml
     * @return 支付通知结果
     */
    WxPayNotifyResult payNotifyParse(String xml);

    /**
     * 通知回复Xml信息
     *
     * @param returnCode SUCCESS/FAIL SUCCESS表示商户接收通知成功并校验成功
     * @param returnMsg  返回信息，如非空，为错误原因： 签名失败 参数格式校验错误
     * @return 回复Xml信息
     */
    String getNotifyReplyXml(String returnCode, String returnMsg);
}
