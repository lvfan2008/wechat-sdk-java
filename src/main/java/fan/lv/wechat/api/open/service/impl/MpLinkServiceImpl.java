package fan.lv.wechat.api.open.service.impl;

import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.open.service.MpLinkService;
import fan.lv.wechat.entity.open.official.WxMpLinkResult;
import fan.lv.wechat.entity.result.WxResult;
import fan.lv.wechat.util.SimpleMap;

/**
 * @author lv_fan2008
 */
public class MpLinkServiceImpl implements MpLinkService {


    /**
     * 请求客户端
     */
    protected Client client;

    /**
     * @param client 请求客户端
     */
    public MpLinkServiceImpl(Client client) {
        this.client = client;
    }


    @Override
    public WxMpLinkResult getMpLink() {
        return client.get("/cgi-bin/wxopen/wxamplinkget", WxMpLinkResult.class);
    }

    @Override
    public WxResult mpLink(String appId, Integer notifyUsers, Integer showProfile) {
        return client.postJson("/cgi-bin/wxopen/wxamplink",
                SimpleMap.of("appid", appId,
                        "notify_users", notifyUsers.toString(),
                        "show_profile", showProfile.toString()),
                WxMpLinkResult.class);
    }

    @Override
    public WxResult unMpLink(String appId) {
        return client.postJson("/cgi-bin/wxopen/wxamplink",
                SimpleMap.of("appid", appId),
                WxMpLinkResult.class);
    }
}
