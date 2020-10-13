package fan.lv.wechat.api.payment.service.impl;

import fan.lv.wechat.api.kernel.impl.BaseClient;
import fan.lv.wechat.entity.pay.WxPayConfig;
import fan.lv.wechat.entity.result.WxBasePayResult;
import fan.lv.wechat.entity.result.WxResult;
import fan.lv.wechat.util.RequestOptions;
import fan.lv.wechat.util.SslCert;
import fan.lv.wechat.util.XmlUtil;
import fan.lv.wechat.util.pay.WxPayConstants;
import fan.lv.wechat.util.pay.WxPayUtil;

import java.util.Map;

import static fan.lv.wechat.util.pay.WxPayConstants.FIELD_SIGN_TYPE;

/**
 * @author lv_fan2008
 */
public class PayClientImpl extends BaseClient {

    WxPayConfig payConfig;

    public PayClientImpl(WxPayConfig payConfig) {
        this.payConfig = payConfig;
    }

    @Override
    public String getBaseUrl() {
        return WxPayConstants.DOMAIN_API;
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
                boolean valid = WxPayUtil.isSignatureValid(mapResult, payConfig.getKey(), signType);
                wxPayResult.setValidSignature(valid);
            }
            return wxResult;
        } catch (Exception e) {
            return errorResult(-1, e.getMessage(), resultType);
        }

    }

    @Override
    public <T extends WxResult> T request(String uri, RequestOptions httpOptions, Class<T> resultType) {
        T wxResult = super.request(uri, httpOptions, resultType);
        WxBasePayResult wxPayResult = (WxBasePayResult) wxResult;
        if (wxResult.getErrorCode() == 0 && !WxPayConstants.SUCCESS.equals(wxPayResult.getResultCode())) {
            wxResult.setErrorCode(-1);
            wxResult.setErrorMessage(wxPayResult.getReturnMsg());
        }
        return wxResult;
    }

    /**
     * Post Xml请求
     *
     * @param uri        uri地址
     * @param reqData    请求Map
     * @param resultType 返回类型
     * @param sslCert    证书
     * @param <T>        模板变量
     * @return 返回结果
     */
    public <T extends WxResult> T postXml(String uri, Map<String, String> reqData, Class<T> resultType, SslCert sslCert) {

        try {
            reqData = fullRequest(reqData);
            return request(uri, RequestOptions.builder().sslCert(sslCert).body(XmlUtil.toXml(reqData))
                    .mimeType("application/xml").build(), resultType);
        } catch (Exception e) {
            return errorResult(-1, e.getMessage(), resultType);
        }
    }

    /**
     * Post Xml请求
     *
     * @param uri        uri地址
     * @param queryMap   get参数
     * @param object     json参数对象
     * @param resultType 返回类型
     * @param sslCert    证书
     * @param <T>        模板变量
     * @return 返回结果
     */
    @Override
    public <T extends WxResult> T postXml(String uri, Map<String, String> queryMap, Object object, Class<T> resultType, SslCert sslCert) {

        try {
            String xml = XmlUtil.toXml(object);
            Map<String, String> map = WxPayUtil.xmlToMap(xml);
            map = fullRequest(map);
            return request(uri, RequestOptions.builder().queryMap(queryMap).sslCert(sslCert).body(XmlUtil.toXml(map))
                    .mimeType("application/xml").build(), resultType);
        } catch (Exception e) {
            return errorResult(-1, e.getMessage(), resultType);
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
        WxPayConstants.SignType signType = WxPayConstants.MD5.equals(payConfig.getSignType()) ? WxPayConstants.SignType.MD5
                : WxPayConstants.SignType.HMACSHA256;
        reqData.put("appid", payConfig.getAppId());
        reqData.put("mch_id", payConfig.getGetMchId());
        reqData.put("nonce_str", WxPayUtil.generateNonceStr());
        reqData.put("sub_mch_id", payConfig.getSubMchId());
        reqData.put("sub_appid", payConfig.getSubAppId());
        reqData.put("sign_type", payConfig.getSignType());
        reqData.put("sign", WxPayUtil.generateSignature(reqData, payConfig.getKey(), signType));
        return reqData;
    }
}
