package fan.lv.wechat.api.mp.service.impl;

import fan.lv.wechat.util.SimpleMap;
import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.mp.service.PluginService;
import fan.lv.wechat.entity.mp.plugin.WxPluginDevApplyListResult;
import fan.lv.wechat.entity.mp.plugin.WxPluginListResult;
import fan.lv.wechat.entity.result.WxResult;
import org.apache.commons.lang3.StringUtils;

/**
 * @author lv_fan2008
 */
public class PluginServiceImpl implements PluginService {

    /**
     * 请求客户端
     */
    protected Client client;


    /**
     * @param client 请求客户端
     */
    public PluginServiceImpl(Client client) {
        this.client = client;
    }


    @Override
    public WxResult applyPlugin(String pluginAppId, String reason) {
        return client.postJson("/wxa/plugin",
                SimpleMap.of("action", "apply", "plugin_appid", pluginAppId,
                        "reason", StringUtils.defaultString(reason)),
                WxResult.class);
    }

    @Override
    public WxPluginDevApplyListResult getPluginDevApplyList(Integer page, Integer num) {
        return client.postJson("/wxa/devplugin",
                SimpleMap.of("action", "dev_apply_list", "page", page, "num", num),
                WxPluginDevApplyListResult.class);
    }

    @Override
    public WxPluginListResult getPluginList() {
        return client.postJson("/wxa/plugin", SimpleMap.of("action", "list"), WxPluginListResult.class);
    }

    @Override
    public WxResult setDevPluginApplyStatus(String action, String appId, String reason) {
        return client.postJson("/wxa/devplugin",
                SimpleMap.of("action", action,
                        "appid", StringUtils.defaultString(appId),
                        "reason", StringUtils.defaultString(reason)),
                WxResult.class);
    }

    @Override
    public WxResult unbindPlugin(String pluginAppId) {
        return client.postJson("/wxa/plugin",
                SimpleMap.of("action", "unbind", "plugin_appid", pluginAppId),
                WxResult.class);
    }
}
