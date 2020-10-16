package fan.lv.wechat.api.payment.v2.service.impl;

import fan.lv.wechat.api.kernel.impl.BaseClient;
import fan.lv.wechat.entity.pay.config.WxPayConfig;
import fan.lv.wechat.entity.pay.payment.WxSandboxSignKeyResult;
import fan.lv.wechat.entity.pay.base.WxBasePayResult;
import fan.lv.wechat.entity.result.WxResult;
import fan.lv.wechat.util.RequestOptions;
import fan.lv.wechat.util.SimpleMap;
import fan.lv.wechat.util.SslCert;
import fan.lv.wechat.util.XmlUtil;
import fan.lv.wechat.util.pay.WxPayConstants;
import fan.lv.wechat.util.pay.WxPayUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static fan.lv.wechat.util.pay.WxPayConstants.FIELD_SIGN_TYPE;

/**
 * @author lv_fan2008
 */
@Slf4j
public class PayClientImpl extends BaseClient {

    WxPayConfig payConfig;

    public PayClientImpl(WxPayConfig payConfig) {
        this.payConfig = payConfig;
    }

    @Override
    public String getBaseUrl() {
        return "https://api.mch.weixin.qq.com";
    }

    /**
     * 获取沙盒Key
     *
     * @return 沙盒Key
     */
    protected String getSandboxSignKey() {
        WxSandboxSignKeyResult result = this.postXml("/pay/getsignkey",
                SimpleMap.of("mch_id", payConfig.getMchId(), "nonce_str", WxPayUtil.generateNonceStr()),
                false, WxSandboxSignKeyResult.class, defOpts());
        return result.success() ? result.getSandboxSignKey() : "";
    }

    /**
     * 原生结果
     *
     * @param errorCode  错误码
     * @param resultType 返回类型
     * @param <T>        模板类型
     * @return 原生结果
     */
    @Override
    protected <T extends WxResult> T errorResult(int errorCode, String errorMessage, Class<T> resultType) {
        T result = super.errorResult(errorCode, errorMessage, resultType);
        WxBasePayResult wxPayResult = (WxBasePayResult) result;
        wxPayResult.setResultCode("FAIL");
        wxPayResult.setReturnMsg(result.getErrorMessage());
        return result;
    }

    /**
     * 转换结果
     *
     * @param result     接收的字符串
     * @param resultType 结果类型
     * @param <T>        模板类型
     * @return 返回结果
     */
    @Override
    protected <T extends WxResult> T convertResult(String result, Class<T> resultType) {
        try {
            Map<String, String> mapResult = WxPayUtil.xmlToMap(result);
            T wxResult = XmlUtil.parseXml(result, resultType);
            WxBasePayResult wxPayResult = (WxBasePayResult) wxResult;
            wxPayResult.setMapResult(mapResult);
            if (WxPayConstants.SUCCESS.equals(wxPayResult.getReturnCode())) {
                WxPayConstants.SignType signType = WxPayConstants.SignType.MD5;
                String signTypeName = mapResult.get(FIELD_SIGN_TYPE);
                if (signTypeName != null) {
                    signType = WxPayConstants.MD5.equals(signTypeName) ? WxPayConstants.SignType.MD5
                            : WxPayConstants.SignType.HMACSHA256;
                }
                // 请求沙盒签名结果，不用验证签名
                boolean sandboxSignKeyResult = resultType.getName().equals(WxSandboxSignKeyResult.class.getName());
                if (!sandboxSignKeyResult) {
                    String key = payConfig.getSandbox() ? payConfig.getSandboxSignKey() : payConfig.getKey();
                    boolean valid = WxPayUtil.isSignatureValid(mapResult, key, signType);
                    wxPayResult.setValidSignature(valid);
                }
            }
            return wxResult;
        } catch (Exception e) {
            return errorResult(-1, e.getMessage(), resultType);
        }
    }

    @Override
    public <T extends WxResult> T request(String uri, RequestOptions httpOptions, Class<T> resultType) {
        if (httpOptions.getConnectTimeoutMs() == null) {
            httpOptions.setConnectTimeoutMs(payConfig.getConnectTimeoutMs());
        }
        if (httpOptions.getReadTimeoutMs() == null) {
            httpOptions.setReadTimeoutMs(payConfig.getReadTimeoutMs());
        }
        if (payConfig.getSandbox()) {
            uri = "/sandboxnew" + uri;
        }
        return super.request(uri, httpOptions, resultType);
    }

    /**
     * 检测沙盒模式下的密钥
     */
    protected void checkSandboxSignKey() {
        if (payConfig.getSandbox() && payConfig.getSandboxSignKey() == null) {
            payConfig.setSandboxSignKey(getSandboxSignKey());
        }
    }

    /**
     * 添加请求必要信息
     *
     * @param reqData 请求数据
     * @return 请求数据
     * @throws Exception 异常
     */
    protected Map<String, String> fullRequest(Map<String, String> reqData) throws Exception {
        reqData.put("appid", payConfig.getAppId());
        reqData.put("mch_id", payConfig.getMchId());
        reqData.put("nonce_str", WxPayUtil.generateNonceStr());
        reqData.put("sub_mch_id", payConfig.getSubMchId());
        reqData.put("sub_appid", payConfig.getSubAppId());
        return reqData;
    }

    protected Map<String, String> addSign(Map<String, String> reqData) throws Exception {
        reqData = filterBlank(reqData);
        String signTypeName = reqData.get("sign_type");
        signTypeName = signTypeName == null ? payConfig.getSignType() : signTypeName;
        WxPayConstants.SignType signType = WxPayConstants.MD5.equals(signTypeName) ? WxPayConstants.SignType.MD5
                : WxPayConstants.SignType.HMACSHA256;
        if (signType.equals(WxPayConstants.SignType.HMACSHA256)) {
            reqData.put("sign_type", signTypeName);
        }
        String key = payConfig.getSandbox() ? payConfig.getSandboxSignKey() : payConfig.getKey();
        reqData.put("sign", WxPayUtil.generateSignature(reqData, key, signType));
        return reqData;
    }

    /**
     * 过滤空数据
     *
     * @param reqData 请求数据
     * @return 过滤的书籍
     */
    protected Map<String, String> filterBlank(Map<String, String> reqData) {
        List<String> removeKeys = new ArrayList<>();
        for (Map.Entry<String, String> entry : reqData.entrySet()) {
            if (StringUtils.isBlank(entry.getKey()) || StringUtils.isBlank(entry.getValue())) {
                removeKeys.add(entry.getKey());
            }
        }
        removeKeys.forEach(reqData::remove);
        return reqData;
    }

    protected RequestOptions defOpts() {
        return RequestOptions.defOpts();
    }

    protected RequestOptions defSslOpts() {
        return RequestOptions.defOpts().sslCert(new SslCert(payConfig.getMchId(), payConfig.getCertBytes()));
    }

    public <T extends WxBasePayResult> T postXml(String uri, Map<String, String> reqData,
                                                 Class<T> resultType, RequestOptions defOpts) {
        return postXml(uri, reqData, true, resultType, defOpts);
    }

    public <T extends WxBasePayResult> T postXml(String uri, Map<String, String> reqData, Boolean useCommonData,
                                                 Class<T> resultType, RequestOptions defOpts) {
        try {
            checkSandboxSignKey();
            if (useCommonData) {
                reqData = fullRequest(reqData);
            }
            reqData = addSign(reqData);
            return request(uri, RequestOptions.defOpts(defOpts).body(WxPayUtil.mapToXml(reqData))
                    .mimeType("application/xml"), resultType);
        } catch (Exception e) {
            return errorResult(-1, e.getMessage(), resultType);
        }
    }
}
