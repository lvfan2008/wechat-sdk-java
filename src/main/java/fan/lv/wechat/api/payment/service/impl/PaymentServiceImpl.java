package fan.lv.wechat.api.payment.service.impl;

import fan.lv.wechat.api.payment.service.PaymentService;
import fan.lv.wechat.entity.pay.WxPayConfig;
import fan.lv.wechat.entity.pay.payment.*;
import fan.lv.wechat.entity.result.WxBasePayResult;
import fan.lv.wechat.entity.result.WxCommonPayResult;
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
        return postXml("/pay/micropay", map, WxMicroPayResult.class, (SslCert) null);
    }

    @Override
    public WxPayReverseResult reverse(String outTradeNo, String transactionId) {
        return postXml("/secapi/pay/reverse", SimpleMap.of("out_trade_no", outTradeNo, "transaction_id", transactionId),
                WxPayReverseResult.class, new SslCert(payConfig.getGetMchId(), payConfig.getCertBytes()));
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
        return postXml("/pay/unifiedorder", map, WxUnifiedOrderResult.class, (SslCert) null);
    }

    @Override
    public WxOrderQueryResult orderQuery(String outTradeNo, String transactionId) {
        return postXml("/pay/orderquery", SimpleMap.of("out_trade_no", outTradeNo, "transaction_id", transactionId),
                WxOrderQueryResult.class, (SslCert) null);
    }

    @Override
    public WxCommonPayResult closeOrder(String outTradeNo) {
        return postXml("/pay/orderquery", SimpleMap.of("out_trade_no", outTradeNo),
                WxOrderQueryResult.class, (SslCert) null);
    }

    @Override
    public WxOrderRefundResult orderRefund(String outTradeNo, String transactionId, String outRefundNo, Integer totalFee,
                                           Integer refundFee, Map<String, String> others) {
        SimpleMap<String, String> map = SimpleMap.of("out_trade_no", outTradeNo, "transaction_id", transactionId,
                "total_fee", totalFee.toString(), "refund_fee", refundFee.toString());
        if (others != null) {
            map.putAll(others);
        }
        return postXml("/secapi/pay/refund", map,
                WxOrderRefundResult.class, new SslCert(payConfig.getGetMchId(), payConfig.getCertBytes()));
    }

    @Override
    public WxRefundQueryResult refundQuery(String outTradeNo, String transactionId, String outRefundNo, String refundId, Integer offset) {
        return postXml("/pay/refundquery",
                SimpleMap.of("out_trade_no", outTradeNo,
                        "transaction_id", transactionId,
                        "out_refund_no", outRefundNo,
                        "refund_id", refundId,
                        "offset", offset == null ? null : offset.toString()),
                WxRefundQueryResult.class, (SslCert) null);
    }

    @Override
    public WxDownloadBillResult downloadBill(String billDate, String billType, String tarType) {
        return postXml("/pay/downloadbill",
                SimpleMap.of("bill_date", billDate,
                        "bill_type", billType,
                        "tar_type", tarType),
                WxDownloadBillResult.class, (SslCert) null);
    }

    @Override
    public WxAuthCodeToOpenIdResult authCodeToOpenId(String authCode) {
        return postXml("/tools/authcodetoopenid",
                SimpleMap.of("auth_code", authCode),
                WxAuthCodeToOpenIdResult.class, (SslCert) null);
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
        return postXml("/payitil/report", map, WxBasePayResult.class, (SslCert) null);
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
