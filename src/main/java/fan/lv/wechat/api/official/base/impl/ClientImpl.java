package fan.lv.wechat.api.official.base.impl;

import fan.lv.wechat.api.kernel.Cache;
import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.entity.official.base.WxAccessToken;
import fan.lv.wechat.entity.official.base.WxAccessTokenResult;
import fan.lv.wechat.entity.official.base.WxResultUtil;
import fan.lv.wechat.entity.result.WxResult;
import fan.lv.wechat.util.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;

/**
 * @author lv_fan2008
 */
@Slf4j
public class ClientImpl implements Client {

    /**
     * token过期码
     */
    public static final int ERROR_CODE_ACCESS_TOKEN_TIMEOUT = 42001;

    /**
     * api base url
     */
    protected static final String BASE_URL = "https://api.weixin.qq.com";

    /**
     * 公众号appId
     */
    protected String appId;

    /**
     * 公众号密钥
     */
    protected String appSecret;

    /**
     * Cache，用于保存token
     */
    protected Cache cache;

    /**
     * 缓存token键值
     */
    protected String accessTokenCacheKey = "official-access-token-";

    /**
     * @param appId     公众号appId
     * @param appSecret 公众号密钥
     * @param cache     缓存接口，用于存储token
     */
    public ClientImpl(String appId, String appSecret, Cache cache) {
        this.appId = appId;
        this.appSecret = appSecret;
        this.cache = cache;
        this.accessTokenCacheKey = "official-access-token-" + this.appId;
    }


    /**
     * 得到TokenKenKey
     *
     * @return 缓存token关键字
     */
    protected String getAccessTokenCacheKey() {
        return this.accessTokenCacheKey;
    }

    /**
     * 缓存token
     *
     * @param accessTokenResult accessToken结果
     */
    protected void cacheToken(WxAccessTokenResult accessTokenResult) {
        String json = JsonUtil.toJson(accessTokenResult);
        cache.put(getAccessTokenCacheKey(), json, 3600 * 2 - 10);

    }


    protected String buildAccessTokenUrl(String url, String accessToken) {
        return url + (url.contains("?") ? "&" : "?") + "access_token=" + accessToken;
    }


    public WxAccessToken getAccessToken(boolean tryCache) {
        if (tryCache) {
            String json = cache.get(getAccessTokenCacheKey());
            if (!StringUtils.isEmpty(json)) {
                return JsonUtil.parseJson(json, WxAccessTokenResult.class);
            }
        }

        WxAccessTokenResult accessTokenResult = request("/cgi-bin/token?grant_type=client_credential",
                RequestOptions.defOpts().queryMap(SimpleMap.of("appid", appId, "secret", appSecret)),
                WxAccessTokenResult.class, false);

        if (accessTokenResult.success()) {
            cacheToken(accessTokenResult);
        }
        return accessTokenResult;
    }


    @Override
    public String getBaseUrl() {
        return BASE_URL;
    }

    @Override
    public <T extends WxResult> T request(String uri, RequestOptions httpOptions, Class<T> resultType, Boolean needAccessToken) {
        String url = uri.contains("://") ? uri : getBaseUrl() + uri;
        try {
            if (needAccessToken) {
                WxAccessToken tokenResult = getAccessToken(true);
                url = HttpUtils.buildUrlQuery(url, SimpleMap.of("access_token", tokenResult.getAccessToken()));
            }
            log.debug("request url: {}", url);
            log.debug("request opt: {}", httpOptions.toString());
            HttpResponse httpResponse = HttpUtils.httpRequest(url, httpOptions);
            SimpleHttpResp simpleHttpResp = HttpUtils.from(httpResponse);
            T wxResult = WxResultUtil.convertResult(simpleHttpResp, resultType);
            if (needAccessToken && wxResult.getErrorCode() == ERROR_CODE_ACCESS_TOKEN_TIMEOUT) {
                getAccessToken(false);
                return request(uri, httpOptions, resultType, true);
            }
            log.debug("origin result: {}", wxResult.getHttpResp().getIsText() ? wxResult.getHttpResp().content() : "raw Stream");
            log.debug("response result: {}", JsonUtil.toJson(wxResult));
            return wxResult;
        } catch (Exception e) {
            log.debug("error result: {}", e.getMessage());
            return WxResultUtil.errorResult(e.getMessage(), resultType);
        }
    }
}
