package fan.lv.wechat.api.payment.v2.service.impl;

import fan.lv.wechat.api.payment.v2.PayClientV2;
import fan.lv.wechat.entity.pay.base.WxBasePayResult;
import fan.lv.wechat.entity.pay.config.WxPayConfig;
import fan.lv.wechat.entity.pay.payment.WxSandboxSignKeyResult;
import fan.lv.wechat.entity.result.WxResult;
import fan.lv.wechat.util.*;
import fan.lv.wechat.util.pay.WxPayConstants;
import fan.lv.wechat.util.pay.WxPayUtil;
import lombok.Getter;
import lombok.Setter;
import org.apache.http.HttpResponse;

import java.util.Map;

/**
 * @author lv_fan2008
 */
public class PayClientV2Impl implements PayClientV2 {

    /**
     * 基础Url
     */
    protected static String baseUrl = "https://api.mch.weixin.qq.com";

    WxPayConfig payConfig;

    public PayClientV2Impl(WxPayConfig payConfig) {
        this.payConfig = payConfig;
    }

    @Override
    public <T extends WxBasePayResult> T postXml(String uri, Map<String, String> reqData, Class<T> resultType, RequestOptions defOpts) {
        String url = uri.contains("://") ? uri : baseUrl + uri;
        try {
            addSign(reqData, payConfig.getKey());
            HttpResponse httpResponse = HttpUtils.httpRequest(url, RequestOptions.defOpts(defOpts).body(WxPayUtil.mapToXml(reqData))
                    .mimeType("application/xml"));
            SimpleHttpResp simpleHttpResp = HttpUtils.from(httpResponse);
            if (simpleHttpResp.isXml()) {
                T payResult = XmlUtil.parseXml(simpleHttpResp.content(), resultType);
                payResult.setHttpResp(simpleHttpResp);
                return payResult;
            } else {
                T payResult = resultType.getDeclaredConstructor().newInstance();
                payResult.setHttpResp(simpleHttpResp);
                return payResult;
            }
        } catch (Exception e) {
            return errorResult(e.getMessage(), resultType);
        }
    }


    /**
     * 判断不是沙盒取签名密钥的Url
     *
     * @param url url
     * @return 如果不是，则返回true，否则false
     */
    protected boolean notGetSandboxSignKeyUrl(String url) {
        return url.contains("/pay/getsignkey");
    }

    protected Map<String, String> addSign(Map<String, String> reqData, String key) throws Exception {
        SignUtil.filterBlank(reqData);
        String signTypeName = reqData.get("sign_type") == null ? payConfig.getSignType() : reqData.get("sign_type");
        WxPayConstants.SignType signType = WxPayConstants.SignType.MD5;
        if (signTypeName.equals(WxPayConstants.HMACSHA256)) {
            signType = WxPayConstants.SignType.HMACSHA256;
            reqData.put("sign_type", signTypeName);
        }
        reqData.put("sign", WxPayUtil.generateSignature(reqData, key, signType));
        return reqData;
    }


    protected <T extends WxBasePayResult> T errorResult(String errorMessage, Class<T> resultType) {
        T result;
        try {
            result = resultType.getDeclaredConstructor().newInstance();
            result.setReturnCode("FAIL");
            result.setErrorMessage(errorMessage);
            return result;
        } catch (Exception exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }
}
