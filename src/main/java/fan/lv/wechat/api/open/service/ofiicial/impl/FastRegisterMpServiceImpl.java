package fan.lv.wechat.api.open.service.ofiicial.impl;

import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.open.service.ofiicial.FastRegisterMpService;
import fan.lv.wechat.entity.open.config.OpenPlatformConfig;
import fan.lv.wechat.entity.open.official.WxFastRegisterResult;
import fan.lv.wechat.entity.result.WxResult;
import fan.lv.wechat.util.HttpUtils;
import fan.lv.wechat.util.SimpleMap;

/**
 * @author lv_fan2008
 */
public class FastRegisterMpServiceImpl implements FastRegisterMpService {

    /**
     * 公众号appId
     */
    String appId;

    /**
     * 客户端
     */
    Client client;

    /**
     * 开放平台配置
     */
    OpenPlatformConfig config;

    public FastRegisterMpServiceImpl(Client client, OpenPlatformConfig config, String appId) {
        this.client = client;
        this.config = config;
        this.appId = appId;
    }


    @Override
    public String getFastRegisterAuthUrl(Integer copyWxVerify, String redirectUri) {
        return HttpUtils.buildUrlQuery("https://mp.weixin.qq.com/cgi-bin/fastregisterauth",
                SimpleMap.of("appid", appId,
                        "component_appid", config.getComponentAppId(),
                        "copy_wx_verify", copyWxVerify.toString(),
                        "redirect_uri", redirectUri));
    }

    @Override
    public WxFastRegisterResult fasterRegister(String tikcet) {
        return client.postJson("/cgi-bin/account/fastregister",
                SimpleMap.of("ticket", tikcet),
                WxFastRegisterResult.class);
    }

    @Override
    public String getRebindMpAdminUrl(String redirectUri) {
        return HttpUtils.buildUrlQuery("https://mp.weixin.qq.com/wxopen/componentrebindadmin",
                SimpleMap.of("appid", appId,
                        "component_appid", config.getComponentAppId(),
                        "redirect_uri", redirectUri));
    }

    @Override
    public WxResult rebindMpAdmin(String taskId) {
        return client.postJson("/cgi- bin/account/componentrebindadmin",
                SimpleMap.of("taskid", taskId),
                WxResult.class);
    }
}
