package fan.lv.wechat.api.open.service.ofiicial.impl;

import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.official.sns.SnsService;
import fan.lv.wechat.entity.official.sns.WxSnsAccessTokenResult;
import fan.lv.wechat.entity.official.sns.WxSnsOpenIdResult;
import fan.lv.wechat.entity.official.sns.WxSnsUserInfoResult;
import fan.lv.wechat.entity.open.config.OpenPlatformConfig;
import fan.lv.wechat.util.*;

/**
 * @author lv_fan2008
 */
public class SnsServiceImpl implements SnsService {

    /**
     * 公众号appId
     */
    String appId;

    /**
     * 开放平台客户端
     */
    Client openClient;

    /**
     * 开放平台配置
     */
    OpenPlatformConfig config;

    public SnsServiceImpl(Client openClient, OpenPlatformConfig config, String appId) {
        this.openClient = openClient;
        this.config = config;
        this.appId = appId;
    }


    @Override
    public String getOpenAuthUrl(String redirectUrl, String scope, String state) {
        state = state == null ? SignUtil.timestamp() : state;
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?response_type=code";
        url = HttpUtils.buildUrlQuery(url, SimpleMap.of("appid", appId,
                "redirect_uri", redirectUrl,
                "scope", scope,
                "state", state,
                "component_appid", config.getComponentAppId()
        ));
        return url + "#wechat_redirect";
    }

    /**
     * 默认请求数据
     *
     * @return 默认请求数据
     */
    protected SimpleMap<String, String> defData() {
        return SimpleMap.of("component_appid", config.getComponentAppId());
    }

    @Override
    public WxSnsOpenIdResult getAuthToken(String code) {
        WxSnsAccessTokenResult result = openClient.postJson("/sns/oauth2/component/access_token",
                defData().add("appid", appId)
                        .add("code", code)
                        .add("grant_type", "authorization_code"),
                WxSnsAccessTokenResult.class);
        if (result.success()) {
            cacheSnsAccessToken(result, appId);
        }
        return result;
    }


    /**
     * 缓存Token
     *
     * @param result 网页授权令牌结果
     */
    protected void cacheSnsAccessToken(WxSnsAccessTokenResult result, String appId) {
        String cacheKey = "open-sns-access-token" + config.getComponentAppId() + "-" + appId + "-" + result.getOpenid();
        config.getCache().put(cacheKey, JsonUtil.toJson(result), result.getExpiresIn() - 60);
        String cacheOpenIdKey = "open-sns-access-token" + config.getComponentAppId() + "-" + appId + "-" + result.getOpenid();
        config.getCache().put(cacheOpenIdKey, result.getRefreshToken(), 30 * 24 * 3600 - 60);
    }

    /**
     * 刷新令牌
     *
     * @param openId 用户OpenId
     * @return 令牌
     */
    protected WxSnsAccessTokenResult getSnsAccessToken(String openId) {
        String cacheKey = "open-sns-access-token" + config.getComponentAppId() + "-" + appId + "-" + openId;
        String json = config.getCache().get(cacheKey);
        if (json != null) {
            return JsonUtil.parseJson(json, WxSnsAccessTokenResult.class);
        }

        String cacheOpenIdKey = "open-sns-access-token" + config.getComponentAppId() + "-" + appId + "-" + openId;
        String refreshToken = config.getCache().get(cacheOpenIdKey);
        WxSnsAccessTokenResult result = openClient.postJson("/sns/oauth2/component/refresh_token",
                defData().add("appid", appId)
                        .add("refresh_token", refreshToken)
                        .add("grant_type", "refresh_token"),
                WxSnsAccessTokenResult.class);
        if (result.success()) {
            cacheSnsAccessToken(result, appId);
        }
        return result;
    }

    @Override
    public WxSnsUserInfoResult getUserInfo(String openId, String lang) {
        WxSnsAccessTokenResult result = getSnsAccessToken(openId);
        if (!result.success()) {
            WxSnsUserInfoResult wxResult = new WxSnsUserInfoResult();
            wxResult.setErrorCode(result.getErrorCode());
            wxResult.setErrorMessage(result.getErrorMessage());
            return wxResult;
        }
        return openClient.request("/sns/userinfo?" +
                        HttpUtils.buildQuery(SimpleMap.of("access_token", result.getAccessToken(),
                                "openid", openId,
                                "lang", lang)),
                RequestOptions.defOpts(),
                WxSnsUserInfoResult.class,
                false);
    }

}
