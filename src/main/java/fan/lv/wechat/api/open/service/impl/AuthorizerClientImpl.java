package fan.lv.wechat.api.open.service.impl;

import fan.lv.wechat.api.kernel.Cache;
import fan.lv.wechat.api.official.base.impl.ClientImpl;
import fan.lv.wechat.api.open.service.OpenPlatformService;
import fan.lv.wechat.entity.official.base.WxAccessToken;
import fan.lv.wechat.entity.open.config.OpenPlatformConfig;
import fan.lv.wechat.entity.open.open.WxOpenAccessTokenResult;
import fan.lv.wechat.util.JsonUtil;
import fan.lv.wechat.util.RequestOptions;
import fan.lv.wechat.util.SimpleMap;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * @author lv_fan2008
 */
public class AuthorizerClientImpl extends ClientImpl {

    OpenPlatformService open;
    OpenPlatformConfig config;

    public AuthorizerClientImpl(OpenPlatformService open, OpenPlatformConfig config, String appId) {
        super(appId, null, config.getCache());
        this.open = open;
        this.config = config;
    }

    /**
     * 得到TokenKenKey
     *
     * @return 缓存token关键字
     */
    @Override
    protected String getAccessTokenCacheKey() {
        return "com_app_access_token_" + config.getComponentAppId() + "_" + appId;
    }

    @Override
    public WxAccessToken getAccessToken(boolean tryCache) {
        if (tryCache) {
            String accessToken = cache.get(getAccessTokenCacheKey());
            if (!StringUtils.isEmpty(accessToken)) {
                return new WxAccessToken() {
                    @Override
                    public String getAccessToken() {
                        return accessToken;
                    }
                };
            }
        }
        return open.refreshAuthorizerToken(appId);
    }

    /**
     * url中令牌key值
     *
     * @return url中令牌key值
     */
    @Override
    protected String getUrlAccessTokenKey() {
        return "access_token";
    }
}
