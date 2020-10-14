package fan.lv.wechat.api.payment.service.impl;

import fan.lv.wechat.api.payment.service.PaymentService;
import fan.lv.wechat.entity.pay.WxPayConfig;
import fan.lv.wechat.entity.pay.payment.*;
import fan.lv.wechat.entity.result.WxBasePayResult;
import fan.lv.wechat.entity.result.WxCommonPayResult;
import fan.lv.wechat.util.RequestOptions;
import fan.lv.wechat.util.SimpleMap;
import fan.lv.wechat.util.SslCert;
import fan.lv.wechat.util.XmlUtil;
import fan.lv.wechat.util.pay.WxPayUtil;

import java.util.Map;

/**
 * @author lv_fan2008
 */
public class PaymentServiceImpl extends PayClientImpl implements PaymentService {

    public PaymentServiceImpl(WxPayConfig payConfig) {
        super(payConfig);
    }

    @Override
    public WxMicroPayResult microPay(String outTradeNo, Integer totalFee, String body, String authCode, String spBillCreateIp, Map<String, String> others) {
        SimpleMap<String, String> map = SimpleMap.of("out_trade_no", outTradeNo)
                .add("total_fee", totalFee.toString())
                .add("body", body)
                .add("auth_code", authCode)
                .add("spbill_create_ip", spBillCreateIp);
        if (others != null) {
            map.putAll(others);
        }
        return postXml("/pay/micropay", map, WxMicroPayResult.class, (RequestOptions) null);
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
                    .add("auth_code", authCode).add("spbill_create_ip", spBillCreateIp);
            if (others != null) {
                map.putAll(others);
            }
            lastResult = postXml("/pay/micropay", map, WxMicroPayResult.class, defOpts);

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
        RequestOptions defOpts = RequestOptions.defOpts().sslCert(new SslCert(payConfig.getGetMchId(), payConfig.getCertBytes()));
        return postXml("/secapi/pay/reverse", SimpleMap.of("out_trade_no", outTradeNo, "transaction_id", transactionId),
                WxPayReverseResult.class, defOpts);
    }

    @Override
    public WxUnifiedOrderResult unifiedOrder(String outTradeNo, Integer totalFee, String tradeType, String body, String openId,
                                             String spBillCreateIp, Map<String, String> others) {
        SimpleMap<String, String> map = SimpleMap.of("out_trade_no", outTradeNo)
                .add("trade_type", tradeType)
                .add("total_fee", totalFee.toString())
                .add("body", body)
                .add("openid", openId)
                .add("spbill_create_ip", spBillCreateIp)
                .add("notify_url", payConfig.getNotifyUrl());
        if (others != null) {
            map.putAll(others);
        }
        return postXml("/pay/unifiedorder", map, WxUnifiedOrderResult.class, (RequestOptions) null);
    }

    @Override
    public WxOrderQueryResult orderQuery(String outTradeNo, String transactionId) {
        return postXml("/pay/orderquery", SimpleMap.of("out_trade_no", outTradeNo, "transaction_id", transactionId),
                WxOrderQueryResult.class, (RequestOptions) null);
    }

    @Override
    public WxCommonPayResult closeOrder(String outTradeNo) {
        return postXml("/pay/orderquery", SimpleMap.of("out_trade_no", outTradeNo),
                WxOrderQueryResult.class, (RequestOptions) null);
    }

    @Override
    public WxOrderRefundResult orderRefund(String outTradeNo, String transactionId, String outRefundNo, Integer totalFee,
                                           Integer refundFee, Map<String, String> others) {
        SimpleMap<String, String> map = SimpleMap.of("out_trade_no", outTradeNo, "transaction_id", transactionId,
                "total_fee", totalFee.toString(), "refund_fee", refundFee.toString());
        if (others != null) {
            map.putAll(others);
        }
        RequestOptions defOpts = RequestOptions.defOpts().sslCert(new SslCert(payConfig.getGetMchId(), payConfig.getCertBytes()));
        return postXml("/secapi/pay/refund", map, WxOrderRefundResult.class, defOpts);
    }

    @Override
    public WxRefundQueryResult refundQuery(String outTradeNo, String transactionId, String outRefundNo, String refundId, Integer offset) {
        return postXml("/pay/refundquery",
                SimpleMap.of("out_trade_no", outTradeNo,
                        "transaction_id", transactionId,
                        "out_refund_no", outRefundNo,
                        "refund_id", refundId,
                        "offset", offset == null ? null : offset.toString()),
                WxRefundQueryResult.class, (RequestOptions) null);
    }

    @Override
    public WxDownloadBillResult downloadBill(String billDate, String billType, String tarType) {
        return postXml("/pay/downloadbill",
                SimpleMap.of("bill_date", billDate,
                        "bill_type", billType,
                        "tar_type", tarType),
                WxDownloadBillResult.class, (RequestOptions) null);
    }

    @Override
    public WxShortUrlResult shortUrl(String longUrl) {
        return postXml("/tools/shorturl", SimpleMap.of("long_url", longUrl), WxShortUrlResult.class, (RequestOptions) null);
    }

    @Override
    public WxAuthCodeToOpenIdResult authCodeToOpenId(String authCode) {
        return postXml("/tools/authcodetoopenid",
                SimpleMap.of("auth_code", authCode),
                WxAuthCodeToOpenIdResult.class, (RequestOptions) null);
    }

    @Override
    public WxBasePayResult report(String interfaceUrl, Integer executeTime, String returnCode, String resultCode,
                                  String userIp, Map<String, String> others) {
        Map<String, String> map = SimpleMap.of("auth_code", interfaceUrl, "auth_code", executeTime.toString(),
                "auth_code", returnCode, "auth_code", resultCode,
                "auth_code", userIp);
        if (others != null) {
            map.putAll(others);
        }
        return postXml("/payitil/report", map, WxBasePayResult.class, (RequestOptions) null);
    }

    @Override
    public WxRefundNotifyResult refundNotifyParse(String xml) {
        WxRefundNotifyResult wxPayResult = this.convertResult(xml, WxRefundNotifyResult.class);
        if (wxPayResult.getReqInfo() != null) {
            try {
                String decodeXml = WxPayUtil.aesDecode(payConfig.getKey(), wxPayResult.getReqInfo());
                WxRefundNotifyResult.WxReqInfo reqInfo = XmlUtil.parseXml(decodeXml, WxRefundNotifyResult.WxReqInfo.class, "root");
                wxPayResult.setDecodeReqInfo(reqInfo);
            } catch (Exception e) {
                wxPayResult.setErrorMessage("decode reqInfo failed: " + e.getMessage());
            }
        }
        return wxPayResult;
    }


    @Override
    public WxPayNotifyResult payNotifyParse(String xml) {
        return this.convertResult(xml, WxPayNotifyResult.class);
    }

    @Override
    public String getNotifyReplyXml(String returnCode, String returnMsg) {
        WxBasePayResult result = new WxBasePayResult();
        result.setResultCode(returnCode);
        result.setReturnMsg(returnMsg);
        return XmlUtil.toXml(result);
    }
}
