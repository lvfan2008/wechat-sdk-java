package fan.lv.wechat.api.open.service.open.impl;

import fan.lv.wechat.api.kernel.Cache;
import fan.lv.wechat.api.official.base.impl.ClientImpl;
import fan.lv.wechat.entity.official.base.WxAccessToken;
import fan.lv.wechat.entity.open.open.WxOpenAccessTokenResult;
import fan.lv.wechat.util.JsonUtil;
import fan.lv.wechat.util.RequestOptions;
import fan.lv.wechat.util.SimpleMap;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * @author lv_fan2008
 */
public class OpenClientImpl extends ClientImpl {

    public OpenClientImpl(String appId, String appSecret, Cache cache) {
        super(appId, appSecret, cache);
    }

    /**
     * 得到TokenKenKey
     *
     * @return 缓存token关键字
     */
    @Override
    protected String getAccessTokenCacheKey() {
        return "open-access-token-" + appId;
    }

    @Override
    public WxAccessToken getAccessToken(boolean tryCache) {
        if (tryCache) {
            String json = cache.get(getAccessTokenCacheKey());
            if (!StringUtils.isEmpty(json)) {
                return JsonUtil.parseJson(json, WxOpenAccessTokenResult.class);
            }
        }
        Map<String, String> map = SimpleMap.of("component_appid", appId,
                "component_appsecret", appSecret,
                "component_verify_ticket", cache.get("component_verify_ticket_" + appId)
        );
        WxOpenAccessTokenResult accessTokenResult = request("/cgi-bin/component/api_component_token",
                RequestOptions.defOpts().body(JsonUtil.toJson(map)).mimeType("application/json"),
                WxOpenAccessTokenResult.class, false);

        if (accessTokenResult.success()) {
            String json = JsonUtil.toJson(accessTokenResult);
            cache.put(getAccessTokenCacheKey(), json, 3600 * 2 - 10);
        }
        return accessTokenResult;
    }

    /**
     * url中令牌key值
     *
     * @return url中令牌key值
     */
    @Override
    protected String getUrlAccessTokenKey() {
        return "component_access_token";
    }
}
