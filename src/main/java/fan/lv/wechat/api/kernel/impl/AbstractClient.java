package fan.lv.wechat.api.kernel.impl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.entity.result.WxResult;
import fan.lv.wechat.util.HttpUtils;
import fan.lv.wechat.util.JsonUtil;
import fan.lv.wechat.util.RequestOptions;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.entity.ContentType;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lv_fan2008
 */
@Slf4j
abstract public class AbstractClient implements Client {

    static final Pattern FILE_NAME_PATTERN = Pattern.compile("filename=[\"'](.*?)[\"']");

    /**
     * @param uri        uri地址
     * @param resultType 返回类型
     * @return 返回结果
     */
    @Override
    public <T extends WxResult> T get(String uri, Class<T> resultType) {
        return this.request(uri, new RequestOptions(), resultType);
    }

    /**
     * post请求
     *
     * @param uri        uri地址
     * @param object     json参数对象
     * @param resultType 返回类型
     * @return 返回结果
     */
    @Override
    public <T extends WxResult> T post(String uri, Object object, Class<T> resultType) {
        return this.request(uri, new RequestOptions(JsonUtil.toJson(object), ContentType.APPLICATION_JSON), resultType);
    }

    @Override
    public <T extends WxResult> T uploadFile(String uri, Map<String, String> formData,
                                             Map<String, String> filePathMap, Class<T> resultType) {
        return this.request(uri, new RequestOptions(formData, filePathMap), resultType);
    }

    @Override
    public <T extends WxResult> T get(String uri, Map<String, String> queryMap, Class<T> resultType) {
        return this.request(uri, new RequestOptions(queryMap), resultType);
    }

    @Override
    public <T extends WxResult> T post(String uri, Map<String, String> queryMap, Object object, Class<T> resultType) {
        return this.request(uri, new RequestOptions(queryMap, JsonUtil.toJson(object), ContentType.APPLICATION_JSON), resultType);
    }

    @Override
    public <T extends WxResult> T uploadFile(String uri,
                                             Map<String, String> queryMap,
                                             Map<String, String> formData,
                                             Map<String, String> filePathMap,
                                             Class<T> resultType) {
        return this.request(uri, new RequestOptions(queryMap, formData, filePathMap), resultType);
    }


    /**
     * 是否为获取凭据uri
     *
     * @param uri uri
     * @return 是否获取凭据uri
     */
    abstract protected boolean isGetAccessTokenUrl(String uri);

    /**
     * 得到基准Url
     *
     * @return 基准url
     */
    abstract protected String getBaseUrl();

    /**
     * 得到缓存Token
     *
     * @return 缓存Token
     */
    abstract protected String getCacheToken();

    /**
     * 获取凭证Token,并缓存当前Token
     *
     * @return 凭证
     */
    abstract protected WxResult getAccessToken();

    /**
     * 通过结果错误码，查看是否token过期
     *
     * @param wxResult 请求结果
     * @return 是否token过期
     */
    abstract protected boolean isTokenExpired(WxResult wxResult);

    /**
     * 创建带token的url
     *
     * @param url         url地址
     * @param accessToken Token串
     * @return 带token的url
     */
    abstract protected String buildAccessTokenUrl(String url, String accessToken);

    /**
     * Http请求
     *
     * @param uri         uri地址
     * @param httpOptions http选项
     * @param resultType  结果类型
     * @param <T>         类型变量
     * @return 请求结果
     */
    public <T extends WxResult> T request(String uri, RequestOptions httpOptions, Class<T> resultType) {
        try {
            String url = getBaseUrl() + uri;
            if (!isGetAccessTokenUrl(uri)) {
                String accessToken = getCacheToken();
                if (StringUtils.isEmpty(accessToken)) {
                    WxResult wxResult = this.getAccessToken();
                    if (!wxResult.success()) {
                        return errorResult(wxResult.getErrorCode(), wxResult.getErrorMessage(), resultType);
                    }
                }
                url = this.buildAccessTokenUrl(url, getCacheToken());
            }

            log.debug("request: url: {}, httpOptions: {}", url, httpOptions.toString());

            HttpResponse httpResponse = HttpUtils.httpRequest(url, httpOptions);

            int statusOk = 200;
            if (httpResponse.getStatusLine().getStatusCode() != statusOk) {
                log.error("getStatusCode() != statusOk httpResponse: {}", httpResponse.toString());
                return errorResult(-4, httpResponse.getStatusLine().toString(), resultType);
            }

            // 如果不是json类型，则为原始数据流
            if (isRawStream(httpResponse)) {
                T wxResult = rawResult(resultType, httpResponse);
                log.debug("rawResult: {}", JsonUtil.toJson(wxResult));
                return wxResult;
            }

            String result = EntityUtils.toString(httpResponse.getEntity());
            T wxResult = JsonUtil.parseJson(result, resultType);
            if (isTokenExpired(wxResult)) {
                WxResult accessTokenResult = this.getAccessToken();
                if (accessTokenResult.success()) {
                    return this.request(uri, httpOptions, resultType);
                }
            }
            log.debug("result: {}", JsonUtil.toJson(wxResult));
            return wxResult;
        } catch (IOException e) {
            return errorResult(-3, e.getMessage(), resultType);
        }
    }

    private boolean isRawStream(HttpResponse httpResponse) {
        if (getFileName(httpResponse) != null) {
            return true;
        }
        Header header = httpResponse.getEntity().getContentType();
        String contentType = header != null ? header.getValue() : null;
        return contentType != null && !contentType.contains("application/json")
                && !contentType.contains("text/plain");
    }

    /**
     * 原生结果
     *
     * @param resultType   结果类型
     * @param httpResponse http相应
     * @param <T>          模板类型
     * @return 原生结果
     */
    protected <T extends WxResult> T rawResult(Class<T> resultType, HttpResponse httpResponse) {
        T result;
        try {
            Header header = httpResponse.getEntity().getContentType();
            result = resultType.newInstance();
            result.setIsRawStream(true);
            result.setFilename(getFileName(httpResponse));
            result.setContentType(header != null ? header.getValue() : null);
            result.setContent(httpResponse.getEntity().getContent());
            result.setLength(httpResponse.getEntity().getContentLength());
            return result;
        } catch (Exception exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }

    /**
     * 获取http响应中的文件名字
     *
     * @param httpResponse http响应
     * @return 文件名字
     */
    private String getFileName(HttpResponse httpResponse) {
        Header[] headers = httpResponse.getHeaders("Content-disposition");
        if (headers == null) {
            return null;
        }
        for (Header header : headers) {
            String value = header.getValue();
            Matcher matcher = FILE_NAME_PATTERN.matcher(value);
            if (matcher.find()) {
                return matcher.group(1);
            }
        }
        return null;
    }

    /**
     * 转为相应的错误结果
     *
     * @param errorCode    错误码
     * @param errorMessage 错误消息
     * @param resultType   结果类型
     * @param <T>          模板类型
     * @return 错误结果
     */
    protected <T extends WxResult> T errorResult(Integer errorCode, String errorMessage, Class<T> resultType) {
        T result;
        try {
            result = resultType.newInstance();
            result.setErrorCode(errorCode);
            result.setErrorMessage(errorMessage);
            return result;
        } catch (Exception exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }

}
