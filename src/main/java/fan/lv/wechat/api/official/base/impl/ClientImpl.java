package fan.lv.wechat.api.official.base.impl;

import fan.lv.wechat.api.kernel.Cache;
import fan.lv.wechat.api.kernel.impl.BaseAccessTokenClient;
import fan.lv.wechat.entity.official.base.WxAccessTokenResult;
import fan.lv.wechat.entity.result.WxResult;
import fan.lv.wechat.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * @author lv_fan2008
 */
@Slf4j
public class ClientImpl extends BaseAccessTokenClient {

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

    /**
     * 得到缓存token
     *
     * @return token
     */
    @Override
    protected String getCacheToken() {
        String json = cache.get(getAccessTokenCacheKey());
        if (StringUtils.isEmpty(json)) {
            return null;
        }
        WxAccessTokenResult accessTokenResult = JsonUtil.parseJson(json, WxAccessTokenResult.class);
        assert accessTokenResult != null;
        return accessTokenResult.getAccessToken();
    }

    @Override
    protected String buildAccessTokenUrl(String url, String accessToken) {
        return url + (url.contains("?") ? "&" : "?") + "access_token=" + accessToken;
    }


    @Override
    public WxResult getAccessToken(boolean tryCache) {
        if (tryCache) {
            String json = cache.get(getAccessTokenCacheKey());
            if (!StringUtils.isEmpty(json)) {
                return JsonUtil.parseJson(json, WxAccessTokenResult.class);
            }
        }

        String url = String.format("/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s", appId, appSecret);
        WxAccessTokenResult accessTokenResult = this.get(url, WxAccessTokenResult.class);
        if (accessTokenResult.success()) {
            cacheToken(accessTokenResult);
        }
        return accessTokenResult;
    }


    /**
     * 是否为获取凭据uri
     *
     * @param uri uri
     * @return 是否获取凭据uri
     */
    @Override
    protected boolean isGetAccessTokenUrl(String uri) {
        return uri.startsWith("/cgi-bin/token?grant_type=client_credential&appid=");
    }

    @Override
    public String getBaseUrl() {
        return BASE_URL;
    }
}
