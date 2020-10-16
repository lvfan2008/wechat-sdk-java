package fan.lv.wechat.api.kernel.impl;

import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.entity.result.WxResult;
import fan.lv.wechat.util.HttpUtils;
import fan.lv.wechat.util.JsonUtil;
import fan.lv.wechat.util.RequestOptions;
import fan.lv.wechat.util.XmlUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.entity.ContentType;
import org.apache.http.util.EntityUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lv_fan2008
 */
@Slf4j
abstract public class BaseClient implements Client {

    /**
     * 下载文件名字匹配
     */
    static final Pattern FILE_NAME_PATTERN = Pattern.compile("filename=[\"'](.*?)[\"']");

    /**
     * 转换结果
     *
     * @param result     接收的字符串
     * @param resultType 结果类型
     * @param <T>        模板类型
     * @return 返回结果
     */
    protected <T extends WxResult> T convertResult(String result, Class<T> resultType) {
        return result.trim().startsWith("{") ? JsonUtil.parseJson(result, resultType)
                : XmlUtil.parseXml(result, resultType);
    }

    @Override
    public <T extends WxResult> T request(String uri, RequestOptions httpOptions, Class<T> resultType) {
        String url = uri.contains("://") ? uri : getBaseUrl() + uri;
        log.debug("request: url: {}, httpOptions: {}", url, httpOptions.toString());

        HttpResponse httpResponse = null;
        try {
            httpResponse = HttpUtils.httpRequest(url, httpOptions);
        } catch (Exception e) {
            log.error("errorResult: {}", e.getMessage());
            return errorResult(-1, e.getMessage(), resultType);
        }

        int statusOk = 200;
        if (httpResponse.getStatusLine().getStatusCode() != statusOk) {
            log.error("getStatusCode() != statusOk httpResponse: {}", httpResponse.toString());
            return errorResult(-1, httpResponse.getStatusLine().toString(), resultType);
        }

        String result = null;
        T wxResult;
        try {
            String filename = getFileName(httpResponse);
            byte[] bytes = EntityUtils.toByteArray(httpResponse.getEntity());
            String charset = getCharset(httpResponse);
            if (isSupportText(httpResponse)) {
                charset = charset == null ? "UTF-8" : charset;
                result = new String(bytes, charset).trim();
                if (isXmlOrJson(result)) {
                    log.debug("origin result: {}", result);
                    wxResult = convertResult(result, resultType);
                    wxResult.setCharset(charset);
                    wxResult.setContent(bytes);
                } else {
                    log.debug("origin rawResult len: {}", result.length());
                    wxResult = rawResult(resultType, filename, charset, bytes);
                }
            } else {
                log.debug("origin rawResult len: {}", bytes.length);
                wxResult = rawResult(resultType, filename, charset, bytes);
            }
        } catch (Exception e) {
            log.error("errorResult: {}", e.getMessage());
            return errorResult(-1, e.getMessage(), resultType);
        }
        log.debug("result: {}", JsonUtil.toJson(wxResult));
        return wxResult;
    }

    private boolean isSupportText(HttpResponse httpResponse) {
        ContentType contentType = ContentType.get(httpResponse.getEntity());
        String filename = getFileName(httpResponse);
        return filename == null && (contentType == null
                || contentType.getMimeType().contains("json")
                || contentType.getMimeType().contains("xml")
                || contentType.getMimeType().contains("text"));
    }

    private boolean isXmlOrJson(String result) {
        return result.startsWith("{") || result.startsWith("<xml") || result.startsWith("<?xml");
    }

    private String getCharset(HttpResponse httpResponse) {
        ContentType contentType = ContentType.get(httpResponse.getEntity());
        if (contentType != null && contentType.getCharset() != null) {
            return contentType.getCharset().name();
        }
        return null;
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
     * 原生结果
     *
     * @param resultType 结果类型
     * @param fileName   http相应
     * @param charset    字符集
     * @param content    内容
     * @param <T>        模板类型
     * @return 原生结果
     */
    protected <T extends WxResult> T rawResult(Class<T> resultType, String fileName, String charset, byte[] content) {
        T result;
        try {
            result = resultType.getDeclaredConstructor().newInstance();
            result.setIsRawStream(true);
            result.setFilename(fileName);
            result.setCharset(charset);
            result.setContent(content);
            return result;
        } catch (Exception exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }

    /**
     * 原生结果
     *
     * @param errorCode  错误码
     * @param resultType 返回类型
     * @param <T>        模板类型
     * @return 原生结果
     */
    protected <T extends WxResult> T errorResult(int errorCode, String errorMessage, Class<T> resultType) {
        T result;
        try {
            result = resultType.getDeclaredConstructor().newInstance();
            result.setErrorCode(errorCode);
            result.setErrorMessage(errorMessage);
            return result;
        } catch (Exception exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }
}
