package fan.lv.wechat.api.open.service.mp.impl;

import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.mp.service.impl.PluginServiceImpl;
import fan.lv.wechat.api.open.service.mp.OpenPluginService;
import fan.lv.wechat.entity.mp.plugin.WxPluginListResult;
import fan.lv.wechat.util.SimpleMap;

public class OpenPluginServiceImpl extends PluginServiceImpl implements OpenPluginService {
    /**
     * 请求客户端
     */
    protected Client client;

    /**
     * @param client 请求客户端
     */
    public OpenPluginServiceImpl(Client client) {
        super(client);
    }

    @Override
    public WxPluginListResult operatePlugin(String action, String pluginAppId, String userVersion) {
        return client.postJson("/wxa/plugin",
                SimpleMap.of("action", action,
                        "plugin_appid", pluginAppId,
                        "user_version", userVersion),
                WxPluginListResult.class);
    }
}
