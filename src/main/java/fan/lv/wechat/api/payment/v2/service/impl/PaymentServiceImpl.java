package fan.lv.wechat.api.payment.v2.service.impl;

import fan.lv.wechat.api.payment.v2.PayClientV2;
import fan.lv.wechat.api.payment.v2.service.PaymentService;
import fan.lv.wechat.entity.pay.base.WxBasePayResult;
import fan.lv.wechat.entity.pay.base.WxCommonPayResult;
import fan.lv.wechat.entity.pay.base.WxPayResultUtil;
import fan.lv.wechat.entity.pay.config.WxPayConfig;
import fan.lv.wechat.entity.pay.payment.*;
import fan.lv.wechat.util.RequestOptions;
import fan.lv.wechat.util.SimpleMap;
import fan.lv.wechat.util.XmlUtil;
import fan.lv.wechat.util.pay.WxPayUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @author lv_fan2008
 */
@Slf4j
public class PaymentServiceImpl extends BaseService implements PaymentService {

    public PaymentServiceImpl(PayClientV2 client, WxPayConfig payConfig) {
        super(client, payConfig);
    }

    /**
     * 默认初始化数据
     *
     * @return 初始化数据
     */
    protected SimpleMap<String, String> defData() {
        return SimpleMap.of("appid", payConfig.getAppId())
                .add("mch_id", payConfig.getMchId())
                .add("nonce_str", WxPayUtil.generateNonceStr())
                .add("sub_mch_id", payConfig.getSubMchId())
                .add("sub_appid", payConfig.getSubAppId());
    }

    @Override
    public WxMicroPayResult microPay(String outTradeNo, Integer totalFee, String body, String authCode, String spBillCreateIp, Map<String, String> others) {
        SimpleMap<String, String> map = defData().add("out_trade_no", outTradeNo)
                .add("total_fee", totalFee.toString())
                .add("body", body)
                .add("auth_code", authCode)
                .add("spbill_create_ip", spBillCreateIp)
                .addAll(others);
        return client.postXml("/pay/micropay", map, WxMicroPayResult.class, defOpts());
    }

    @Override
    public WxMicroPayResult microPayByPos(String outTradeNo, Integer totalFee, String body, String authCode, String spBillCreateIp, Map<String, String> others) {
        int remainingTimeMs = 60 * 1000;
        int connectTimeoutMs = payConfig.getConnectTimeoutMs();
        long startTimestampMs = 0;
        WxMicroPayResult lastResult = null;
        while (true) {
            startTimestampMs = WxPayUtil.getCurrentTimestampMs();
            int readTimeoutMs = remainingTimeMs - connectTimeoutMs;
            if (readTimeoutMs <= 1000) {
                break;
            }
            // 支付请求
            RequestOptions defOpts = RequestOptions.defOpts().readTimeoutMs(readTimeoutMs).connectTimeoutMs(connectTimeoutMs);
            SimpleMap<String, String> map = SimpleMap.of("out_trade_no", outTradeNo)
                    .add("total_fee", totalFee.toString()).add("body", body)
                    .add("auth_code", authCode).add("spbill_create_ip", spBillCreateIp)
                    .addAll(others);
            lastResult = client.postXml("/pay/micropay", map, WxMicroPayResult.class, defOpts);

            // 支付成功或者支付业务成功则返回结果
            if (!lastResult.success() || lastResult.resultSuccess()) {
                return lastResult;
            }
            // 看错误码，若支付结果未知，则重试提交刷卡支付
            if ("SYSTEMERROR".equals(lastResult.getPayErrCode())
                    || "BANKERROR".equals(lastResult.getPayErrCode()) || "USERPAYING".equals(lastResult.getPayErrCode())) {
                remainingTimeMs = remainingTimeMs - (int) (WxPayUtil.getCurrentTimestampMs() - startTimestampMs);
                if (remainingTimeMs <= 100) {
                    break;
                } else {
                    WxPayUtil.getLogger().info("microPayWithPos: try micropay again");
                    try {
                        Thread.sleep((remainingTimeMs > 5 * 1000) ? 5 * 1000 : 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return lastResult;
    }

    @Override
    public WxPayReverseResult reverse(String outTradeNo, String transactionId) {
        return client.postXml("/secapi/pay/reverse",
                defData().add("out_trade_no", outTradeNo).add("transaction_id", transactionId),
                WxPayReverseResult.class, defSslOpts());
    }

    @Override
    public WxUnifiedOrderResult unifiedOrder(String outTradeNo, Integer totalFee, String tradeType, String body, String openId,
                                             String spBillCreateIp, Map<String, String> others) {
        SimpleMap<String, String> map = defData()
                .add("out_trade_no", outTradeNo)
                .add("trade_type", tradeType)
                .add("total_fee", totalFee.toString())
                .add("body", body)
                .add("openid", openId)
                .add("spbill_create_ip", spBillCreateIp)
                .add("notify_url", payConfig.getNotifyUrl())
                .addAll(others);
        return client.postXml("/pay/unifiedorder", map, WxUnifiedOrderResult.class, defOpts());
    }

    @Override
    public WxOrderQueryResult orderQuery(String outTradeNo, String transactionId) {
        return client.postXml("/pay/orderquery",
                defData().add("out_trade_no", outTradeNo).add("transaction_id", transactionId),
                WxOrderQueryResult.class, defOpts());
    }

    @Override
    public WxCommonPayResult closeOrder(String outTradeNo) {
        return client.postXml("/pay/orderquery", defData().add("out_trade_no", outTradeNo),
                WxOrderQueryResult.class, defOpts());
    }

    @Override
    public WxOrderRefundResult orderRefund(String outTradeNo, String transactionId, String outRefundNo, Integer totalFee,
                                           Integer refundFee, Map<String, String> others) {
        SimpleMap<String, String> map = defData().add("out_trade_no", outTradeNo)
                .add("transaction_id", transactionId)
                .add("total_fee", totalFee.toString())
                .add("refund_fee", refundFee.toString())
                .addAll(others);
        return client.postXml("/secapi/pay/refund", map, WxOrderRefundResult.class, defSslOpts());
    }

    @Override
    public WxRefundQueryResult refundQuery(String outTradeNo, String transactionId, String outRefundNo, String refundId, Integer offset) {
        return client.postXml("/pay/refundquery",
                defData().add("out_trade_no", outTradeNo)
                        .add("transaction_id", transactionId)
                        .add("out_refund_no", outRefundNo)
                        .add("refund_id", refundId)
                        .add("offset", offset == null ? null : offset.toString()),
                WxRefundQueryResult.class, defOpts());
    }

    @Override
    public WxDownloadBillResult downloadBill(String billDate, String billType, String tarType) {
        return client.postXml("/pay/downloadbill",
                defData().add("bill_date", billDate)
                        .add("bill_type", billType)
                        .add("tar_type", tarType),
                WxDownloadBillResult.class, defOpts());
    }

    @Override
    public WxDownloadFundFlowResult downloadFundFlow(String billDate, String billType, String tarType) {
        return client.postXml("/pay/downloadfundflow",
                defData().add("bill_date", billDate)
                        .add("bill_type", billType)
                        .add("tar_type", tarType)
                        .add("sign_type", "HMAC-SHA256"),
                WxDownloadFundFlowResult.class, defSslOpts());
    }

    @Override
    public WxBatchQueryCommentResult batchQueryComment(String beginTime, String endTime, Integer offset, Integer limit) {
        return client.postXml("/billcommentsp/batchquerycomment",
                defData().add("begin_time", beginTime)
                        .add("end_time", endTime)
                        .add("offset", offset.toString())
                        .add("limit", limit == null ? null : limit.toString())
                        .add("sign_type", "HMAC-SHA256"),
                WxBatchQueryCommentResult.class, defSslOpts());
    }

    @Override
    public WxShortUrlResult shortUrl(String longUrl) {
        return client.postXml("/tools/shorturl", defData().add("long_url", longUrl), WxShortUrlResult.class, defOpts());
    }

    @Override
    public WxAuthCodeToOpenIdResult authCodeToOpenId(String authCode) {
        return client.postXml("/tools/authcodetoopenid",
                defData().add("auth_code", authCode),
                WxAuthCodeToOpenIdResult.class, defOpts());
    }

    @Override
    public WxBasePayResult report(String interfaceUrl, Integer executeTime, String returnCode, String resultCode,
                                  String userIp, Map<String, String> others) {
        Map<String, String> map = defData().add("interface_url", interfaceUrl)
                .add("execute_time_", executeTime.toString())
                .add("return_code", returnCode)
                .add("result_code", resultCode)
                .add("user_ip", userIp)
                .addAll(others);
        return client.postXml("/payitil/report", map, WxBasePayResult.class, defOpts());
    }

    @Override
    public WxRefundNotifyResult refundNotifyParse(String xml) {
        WxRefundNotifyResult wxPayResult = WxPayResultUtil.convertResult(xml, WxRefundNotifyResult.class);
        if (wxPayResult.getReqInfo() != null) {
            try {
                String decodeXml = WxPayUtil.aesDecode(payConfig.getKey(), wxPayResult.getReqInfo());
                WxRefundNotifyResult.WxReqInfo reqInfo = XmlUtil.parseXml(decodeXml, WxRefundNotifyResult.WxReqInfo.class, "root");
                wxPayResult.setDecodeReqInfo(reqInfo);
            } catch (Exception e) {
                wxPayResult.setDecodeFailReason("decode reqInfo failed: " + e.getMessage());
            }
        }
        return wxPayResult;
    }


    @Override
    public WxPayNotifyResult payNotifyParse(String xml) {
        return WxPayResultUtil.convertResult(xml, WxPayNotifyResult.class);
    }

    @Override
    public String getNotifyReplyXml(String returnCode, String returnMsg) {
        WxBasePayResult result = new WxBasePayResult();
        result.setReturnCode(returnCode);
        result.setReturnMsg(returnMsg);
        return XmlUtil.toXml(result);
    }
}
