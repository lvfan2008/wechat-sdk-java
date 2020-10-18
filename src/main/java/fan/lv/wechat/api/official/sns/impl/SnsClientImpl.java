package fan.lv.wechat.api.official.sns.impl;

import fan.lv.wechat.api.kernel.Cache;
import fan.lv.wechat.api.official.base.impl.ClientImpl;
import fan.lv.wechat.entity.official.base.WxAccessToken;
import fan.lv.wechat.entity.official.sns.WxSnsAccessTokenResult;
import fan.lv.wechat.entity.result.WxResult;
import fan.lv.wechat.util.JsonUtil;
import org.apache.commons.lang3.StringUtils;

/**
 * 网页授权客户端
 *
 * @author lv_fan2008
 */
public class SnsClientImpl extends ClientImpl {

    /**
     * 作为换取access_token的票据
     */
    String code;


    /**
     * @param appId     公众号appId
     * @param appSecret 公众号密钥
     * @param cache     缓存接口，用于存储token
     * @param code      作为换取access_token的票据
     */
    public SnsClientImpl(String appId, String appSecret, Cache cache, String code) {
        super(appId, appSecret, cache);
        this.code = code;
    }


    @Override
    public WxAccessToken getAccessToken(boolean tryCache) {
        if (tryCache) {
            String json = cache.get("sns-access-token-" + appId + "_" + code);
            if (!StringUtils.isEmpty(json)) {
                return JsonUtil.parseJson(json, WxSnsAccessTokenResult.class);
            }
        }
        String refreshTokenJson = cache.get("sns-refresh-token-" + appId + "_" + code);
        if (!StringUtils.isEmpty(refreshTokenJson)) {
            WxSnsAccessTokenResult result = JsonUtil.parseJson(refreshTokenJson, WxSnsAccessTokenResult.class);
            return refreshAccessToken(result.getRefreshToken());
        } else {
            return getSnsAccessToken();
        }
    }

    /**
     * 通过code获取token
     *
     * @return token
     */
    protected WxSnsAccessTokenResult getSnsAccessToken() {
        String url = String.format("/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code",
                appId, appSecret, code);
        WxSnsAccessTokenResult accessTokenResult = this.get(url, WxSnsAccessTokenResult.class);
        if (accessTokenResult.success()) {
            cacheToken(accessTokenResult);
        }
        return accessTokenResult;
    }

    /**
     * 刷新token
     *
     * @param refreshToken 刷新Token
     * @return 新的token结果
     */
    protected WxSnsAccessTokenResult refreshAccessToken(String refreshToken) {
        String refreshUrlFormat = "/sns/oauth2/refresh_token?appid=%s&grant_type=refresh_token&refresh_token=%s";
        String url = String.format(refreshUrlFormat, appId, refreshToken);
        WxSnsAccessTokenResult accessTokenResult = this.get(url, WxSnsAccessTokenResult.class);
        if (accessTokenResult.success()) {
            cacheToken(accessTokenResult);
        }
        return accessTokenResult;
    }

    /**
     * 缓存token
     *
     * @param result token
     */
    protected void cacheToken(WxSnsAccessTokenResult result) {
        cache.put("sns-access-token-" + appId + "_" + code, JsonUtil.toJson(result), result.getExpiresIn() - 60);
        cache.put("sns-refresh-token-" + appId + "_" + code, JsonUtil.toJson(result), 30 * 24 * 3600 - 60);
    }
}
