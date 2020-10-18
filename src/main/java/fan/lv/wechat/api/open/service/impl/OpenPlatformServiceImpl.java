package fan.lv.wechat.api.open.service.impl;

import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.open.service.OpenPlatformService;
import fan.lv.wechat.entity.open.config.OpenPlatformConfig;
import fan.lv.wechat.entity.open.open.WxOpenAccessTokenResult;
import fan.lv.wechat.entity.open.open.WxPreAuthCodeResult;
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

    @Override
    public WxPreAuthCodeResult getPreAuthCode() {
        String cacheKey = "pre_auth_code_" + config.getComponentAppId();
        String json = config.getCache().get(cacheKey);
        if (!StringUtils.isEmpty(json)) {
            return JsonUtil.parseJson(json, WxPreAuthCodeResult.class);
        }
        WxPreAuthCodeResult result = client.postJson("/cgi-bin/component/api_create_preauthcode",
                SimpleMap.of("component_appid", config.getComponentAppId()),
                WxPreAuthCodeResult.class);
        if (result.success()) {
            config.getCache().put(cacheKey, JsonUtil.toJson(result), result.getExpireIn() - 10);
        }
        return result;
    }
}
