package fan.lv.wechat.api.open.service.impl;

import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.official.server.ServerService;
import fan.lv.wechat.api.open.OpenMpApp;
import fan.lv.wechat.api.open.OpenOfficialApp;
import fan.lv.wechat.api.open.service.OpenPlatformService;
import fan.lv.wechat.entity.official.sns.WxSnsAccessTokenResult;
import fan.lv.wechat.entity.open.config.OpenPlatformConfig;
import fan.lv.wechat.entity.open.open.*;
import fan.lv.wechat.entity.result.WxResult;
import fan.lv.wechat.util.HttpUtils;
import fan.lv.wechat.util.JsonUtil;
import fan.lv.wechat.util.SimpleMap;
import org.apache.commons.lang3.StringUtils;

/**
 * @author lixinguo
 */
public class OpenPlatformServiceImpl implements OpenPlatformService {

    Client client;

    OpenPlatformConfig config;

    public OpenPlatformServiceImpl(Client client, OpenPlatformConfig config) {
        this.client = client;
        this.config = config;
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
    public WxPreAuthCodeResult getPreAuthCode() {
        String cacheKey = "pre_auth_code_" + config.getComponentAppId();
        String json = config.getCache().get(cacheKey);
        if (!StringUtils.isEmpty(json)) {
            return JsonUtil.parseJson(json, WxPreAuthCodeResult.class);
        }
        WxPreAuthCodeResult result = client.postJson("/cgi-bin/component/api_create_preauthcode",
                defData(),
                WxPreAuthCodeResult.class);
        if (result.success()) {
            config.getCache().put(cacheKey, JsonUtil.toJson(result), result.getExpireIn() - 10);
        }
        return result;
    }

    @Override
    public WxAuthorizationInfoResult getAuthorizationInfo(String authorizationCode) {
        WxAuthorizationInfoResult result = client.postJson("/cgi-bin/component/api_query_auth",
                defData().add("authorization_code", authorizationCode),
                WxAuthorizationInfoResult.class);
        if (result.success()) {
            WxAuthorizationInfoResult.AuthorizationInfo info = result.getAuthorizationInfo();
            cacheToken(info.getAuthorizerAppId(), info.getAuthorizerAccessToken(),
                    info.getAuthorizerRefreshToken(), info.getExpiresIn());
        }
        return result;
    }

    /**
     * 缓存令牌信息
     *
     * @param appId        授权店公众号或小程序appId
     * @param accessToken  令牌
     * @param refreshToken 刷新令牌
     * @param expireIn     令牌有效期
     */
    protected void cacheToken(String appId, String accessToken, String refreshToken, Integer expireIn) {
        // 缓存accessToken，永久保存refreshToken
        String cacheKey = "com_app_access_token_" + config.getComponentAppId() + "_" + appId;
        config.getCache().put(cacheKey, accessToken, expireIn - 60);
        String cacheRefreshKey = "com_app_refresh_access_token_" + config.getComponentAppId() + "_" + appId;
        config.getCache().put(cacheRefreshKey, refreshToken, 10000 * 24 * 3600);
    }

    @Override
    public String getAuthorityPageUrl(String preAuthCode, String redirectUrl, String authType, String bizAppId) {
        String url = "https://mp.weixin.qq.com/cgi-bin/componentloginpage";
        return HttpUtils.buildUrlQuery(url, SimpleMap.of("component_appid", config.getComponentAppId(),
                "pre_auth_code", preAuthCode,
                "redirect_uri", redirectUrl,
                "auth_type", authType,
                "biz_appid", bizAppId));
    }

    @Override
    public String getMobileAuthorityPageUrl(String preAuthCode, String redirectUrl, String authType, String bizAppId) {
        String url = "https://mp.weixin.qq.com/safe/bindcomponent?action=bindcomponent&no_scan=1";
        return HttpUtils.buildUrlQuery(url, SimpleMap.of("component_appid", config.getComponentAppId(),
                "pre_auth_code", preAuthCode,
                "redirect_uri", redirectUrl,
                "auth_type", authType,
                "biz_appid", bizAppId))
                + "#wechat_redirect";
    }

    @Override
    public WxRefreshAuthorizerAccessTokenResult refreshAuthorizerToken(String authorizerAppId) {
        String cacheRefreshKey = "com_app_refresh_access_token_" + config.getComponentAppId() + "_" + authorizerAppId;
        String refreshToken = config.getCache().get(cacheRefreshKey);
        WxRefreshAuthorizerAccessTokenResult result = client.postJson("/cgi-bin/component/api_authorizer_token",
                defData().add("authorizer_refresh_token", refreshToken)
                        .add("authorizer_appid", authorizerAppId),
                WxRefreshAuthorizerAccessTokenResult.class);
        if (result.success()) {
            cacheToken(authorizerAppId, result.getAccessToken(),
                    result.getRefreshToken(), result.getExpiresIn());
        }
        return result;
    }

    @Override
    public WxAuthorizerInfoResult getAuthorizerInfo(String authorizerAppId) {
        return client.postJson("/cgi-bin/component/api_get_authorizer_info",
                defData().add("authorizer_appid", authorizerAppId),
                WxAuthorizerInfoResult.class);
    }

    @Override
    public WxAuthorizerOptionResult getAuthorizerOption(String authorizerAppId, String optionName) {
        return client.postJson("/cgi-bin/component/api_get_authorizer_option",
                defData().add("authorizer_appid", authorizerAppId)
                        .add("option_name", optionName),
                WxAuthorizerOptionResult.class);
    }

    @Override
    public WxResult setAuthorizerOption(String authorizerAppId, String optionName, String optionValue) {
        return client.postJson("/cgi-bin/component/api_set_authorizer_option",
                defData().add("authorizer_appid", authorizerAppId)
                        .add("option_name", optionName)
                        .add("option_value", optionValue),
                WxAuthorizerOptionResult.class);
    }

    @Override
    public WxAuthorizerListResult getAuthorizerList(Integer offset, Integer count) {
        return client.postJson("/cgi-bin/component/api_get_authorizer_list",
                defData().add("offset", offset.toString())
                        .add("count", count.toString()),
                WxAuthorizerListResult.class);
    }

    @Override
    public WxResult clearQuota() {
        return client.postJson("/cgi-bin/component/clear_quota",
                defData(),
                WxResult.class);
    }

    @Override
    public OpenMpApp getMpApp(String appId) {
        return new OpenMpApp(this, config, appId);
    }

    @Override
    public OpenOfficialApp getOfficialApp(String appId) {
        return new OpenOfficialApp(this, client, config, appId);
    }
}
