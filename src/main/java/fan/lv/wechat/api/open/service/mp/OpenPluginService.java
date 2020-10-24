package fan.lv.wechat.api.open.service.mp;

import fan.lv.wechat.api.mp.service.PluginService;
import fan.lv.wechat.entity.mp.plugin.WxPluginListResult;

/**
 * @author lv_fan2008
 */
public interface OpenPluginService extends PluginService {
    /**
     * 小程序插件管理
     * <p>
     * 插件管理权限集用于第三方平台代小程序管理插件。使用过程中如遇到问题，可在开放平台服务商专区发帖交流。
     * <p>
     * 具体包括：
     * <p>
     * 申请使用插件
     * 查询已添加的插件列表
     * 删除已添加的插件
     * 快速更新插件版本号
     *
     * @param action      操作类型
     *                    apply	    申请使用插件
     *                    list	    查询已添加的插件列表
     *                    unbind	删除已添加的插件
     *                    update	快速更新插件版本号
     * @param pluginAppId 插件的 appid
     * @param userVersin  升级至版本号，要求此插件版本支持快速更新
     * @return 操作结果
     */
    WxPluginListResult operatePlugin(String action, String pluginAppId, String userVersin);
}
