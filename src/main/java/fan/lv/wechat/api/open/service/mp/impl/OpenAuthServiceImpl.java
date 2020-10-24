package fan.lv.wechat.api.open.service.mp.impl;

import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.mp.service.AuthService;
import fan.lv.wechat.api.open.service.open.OpenPlatformService;
import fan.lv.wechat.entity.mp.user.WxSessionResult;

/**
 * @author lv_fan2008
 */
public class OpenAuthServiceImpl implements AuthService {
    /**
     * 小程序appId
     */
    protected String appId;

    /**
     * 小程序客户端
     */
    protected Client client;

    /**
     * 开放平台微信登陆服务
     */
    OpenPlatformService open;


    public OpenAuthServiceImpl(String appId, Client client, OpenPlatformService open) {
        this.appId = appId;
        this.client = client;
        this.open = open;
    }

    @Override
    public WxSessionResult codeToSession(String code) {
        return open.codeToSession(appId, code);
    }
}
