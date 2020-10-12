package fan.lv.wechat.api.kernel.impl;

import fan.lv.wechat.entity.result.WxResult;
import fan.lv.wechat.util.JsonUtil;
import fan.lv.wechat.util.RequestOptions;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * @author lv_fan2008
 */
@Slf4j
abstract public class BaseAccessTokenClient extends BaseClient {

    /**
     * token过期码
     */
    public static final int ERROR_CODE_ACCESS_TOKEN_TIMEOUT = 42001;


    /**
     * 获取凭证Token
     *
     * @return 凭证结果，必须为WxResult子类的实例
     */
    public WxResult getAccessToken() {
        return getAccessToken(true);
    }

    /**
     * 获取凭证Token,如果缓存过期或者不从缓存取，需要缓存已得到的Token
     *
     * @param tryCache 是否尝试从cache里获取凭证
     * @return 凭证结果，必须为WxResult子类的实例
     */
    abstract public WxResult getAccessToken(boolean tryCache);


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
            if (isNotRawUrl(uri)) {
                url = getBaseUrl() + uri;
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
            }

            T wxResult = super.request(url, httpOptions, resultType);
            if (isNotRawUrl(uri) && isTokenExpired(wxResult)) {
                WxResult accessTokenResult = this.getAccessToken();
                if (accessTokenResult.success()) {
                    return this.request(uri, httpOptions, resultType);
                }
            }
            return wxResult;
        } catch (Exception e) {
            return errorResult(-3, e.getMessage(), resultType);
        }
    }

    /**
     * 是否为原生的url，则不使用token尝试机制
     *
     * @param uri uri地址
     * @return 是否为原生的url
     */
    private boolean isNotRawUrl(String uri) {
        return !uri.contains("://");
    }
}
