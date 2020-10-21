package fan.lv.wechat.api.open.service.authorizer.impl;

import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.open.service.authorizer.OpenAccountService;
import fan.lv.wechat.entity.open.open.WxOpenAccountResult;
import fan.lv.wechat.entity.result.WxResult;
import fan.lv.wechat.util.SimpleMap;

/**
 * 开放平台账户管理
 *
 * @author lv_fan2008
 */
public class OpenAccountServiceImpl implements OpenAccountService {

    /**
     * 第三方授权到appId
     */
    String appId;

    /**
     * 客户端
     */
    Client client;

    public OpenAccountServiceImpl(String appId, Client client) {
        this.appId = appId;
        this.client = client;
    }

    protected SimpleMap<String, String> defData() {
        return SimpleMap.of("appid", appId);
    }

    @Override
    public WxOpenAccountResult createOpenAccount() {
        return client.postJson("/cgi-bin/open/create", defData(), WxOpenAccountResult.class);
    }

    @Override
    public WxResult bindOpenAccount(String openAppId) {
        return client.postJson("/cgi-bin/open/bind", defData().add("open_appid", openAppId), WxResult.class);
    }

    @Override
    public WxResult unbindOpenAccount(String openAppId) {
        return client.postJson("/cgi-bin/open/unbind", defData().add("open_appid", openAppId), WxResult.class);
    }

    @Override
    public WxOpenAccountResult getOpenAccount() {
        return client.postJson("/cgi-bin/open/get", defData(), WxOpenAccountResult.class);
    }
}
