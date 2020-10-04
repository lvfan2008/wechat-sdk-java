package fan.lv.wechat.api.kernel.impl;

import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.entity.result.WxResult;
import fan.lv.wechat.util.HttpUtils;
import fan.lv.wechat.util.JsonUtil;
import fan.lv.wechat.util.RequestOptions;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.entity.ContentType;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lv_fan2008
 */
@Slf4j
abstract public class AbstractClient implements Client {

    /**
     * token过期码
     */
    public static final int ERROR_CODE_ACCESS_TOKEN_TIMEOUT = 42001;

    /**
     * 下载文件名字匹配
     */
    static final Pattern FILE_NAME_PATTERN = Pattern.compile("filename=[\"'](.*?)[\"']");


    @Override
    public <T extends WxResult> T get(String uri, Class<T> resultType) {
        return this.request(uri, new RequestOptions(), resultType);
    }

    @Override
    public <T extends WxResult> T postJson(String uri, Object object, Class<T> resultType) {
        return this.request(uri, new RequestOptions(JsonUtil.toJson(object), ContentType.APPLICATION_JSON), resultType);
    }

    @Override
    public <T extends WxResult> T postForm(String uri, Map<String, String> formData, Class<T> resultType) {
        return this.request(uri, new RequestOptions(Collections.<String, String>emptyMap(), formData,
                Collections.<String, String>emptyMap()), resultType);
    }

    @Override
    public <T extends WxResult> T postForm(String uri, Map<String, String> queryMap, Map<String, String> formData, Class<T> resultType) {
        return this.request(uri, new RequestOptions(queryMap, formData, Collections.<String, String>emptyMap()), resultType);
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
    public <T extends WxResult> T postJson(String uri, Map<String, String> queryMap, Object object, Class<T> resultType) {
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
     * 获取缓存中的token
     *
     * @return token串
     */
    protected abstract String getCacheToken();

    /**
     * 通过结果错误码，查看是否token过期
     *
     * @param wxResult 请求结果
     * @return 是否token过期
     */
    protected boolean isTokenExpired(WxResult wxResult) {
        return wxResult.getErrorCode() == ERROR_CODE_ACCESS_TOKEN_TIMEOUT;
    }

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
    @Override
    public <T extends WxResult> T request(String uri, RequestOptions httpOptions, Class<T> resultType) {
        try {
            String url = uri;
            if (!isRawUrl(uri)) {
                url = getBaseUrl() + uri;
                if (!isGetAccessTokenUrl(uri)) {
                    String accessToken = getCacheToken();
                    if (StringUtils.isEmpty(accessToken)) {
                        WxResult wxResult = this.getAccessToken();
                        if (!wxResult.success()) {
                            return WxResult.errorResult(wxResult.getErrorCode(), wxResult.getErrorMessage(), resultType);
                        }
                    }
                    url = this.buildAccessTokenUrl(url, getCacheToken());
                }
            }

            log.debug("request: url: {}, httpOptions: {}", url, httpOptions.toString());

            HttpResponse httpResponse = HttpUtils.httpRequest(url, httpOptions);

            int statusOk = 200;
            if (httpResponse.getStatusLine().getStatusCode() != statusOk) {
                log.error("getStatusCode() != statusOk httpResponse: {}", httpResponse.toString());
                return WxResult.errorResult(-4, httpResponse.getStatusLine().toString(), resultType);
            }

            // 如果不是json类型，则为原始数据流
            if (isRawStream(httpResponse)) {
                T wxResult = rawResult(resultType, httpResponse);
                log.debug("rawResult: {}", JsonUtil.toJson(wxResult));
                return wxResult;
            }

            String result = EntityUtils.toString(httpResponse.getEntity());
            log.debug("origin result: {}", result);

            T wxResult = JsonUtil.parseJson(result, resultType);
            if (!isRawUrl(uri) && isTokenExpired(wxResult)) {
                WxResult accessTokenResult = this.getAccessToken();
                if (accessTokenResult.success()) {
                    return this.request(uri, httpOptions, resultType);
                }
            }
            log.debug("result: {}", JsonUtil.toJson(wxResult));
            return wxResult;
        } catch (IOException e) {
            return WxResult.errorResult(-3, e.getMessage(), resultType);
        }
    }

    /**
     * 是否为原生的url，则不使用token尝试机制
     *
     * @param uri uri地址
     * @return 是否为原生的url
     */
    private boolean isRawUrl(String uri) {
        return uri.contains("://");
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

}
