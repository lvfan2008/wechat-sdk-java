package fan.lv.wechat.api.mp;

import fan.lv.wechat.entity.mp.plugin.WxPluginDevApplyListResult;
import fan.lv.wechat.entity.mp.plugin.WxPluginListResult;
import fan.lv.wechat.entity.result.WxResult;

/**
 * 插件管理服务
 *
 * @author lv_fan2008
 */
public interface PluginService {
    /**
     * 向插件开发者发起使用插件的申请
     *
     * @param pluginAppId 插件 appId
     * @param reason      申请使用理由
     * @return 返回结果
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/plugin-management/pluginManager.applyPlugin.html" target="_blank">微信官方文档</a>
     */
    WxResult applyPlugin(String pluginAppId, String reason);

    /**
     * 向插件开发者发起使用插件的申请
     *
     * @param page 要拉取第几页的数据
     * @param num  每页的记录数
     * @return 返回结果
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/plugin-management/pluginManager.getPluginDevApplyList.html" target="_blank">微信官方文档</a>
     */
    WxPluginDevApplyListResult getPluginDevApplyList(Integer page, Integer num);


    /**
     * 查询已添加的插件
     *
     * @return 插件列表
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/plugin-management/pluginManager.getPluginList.html" target="_blank">微信官方文档</a>
     */
    WxPluginListResult getPluginList();


    /**
     * 修改插件使用申请的状态（供插件开发者调用）
     *
     * @param action 修改操作：dev_agree 同意申请  dev_refuse 拒绝申请  dev_delete 删除已拒绝的申请者
     * @param appId  使用者的 appid。同意申请时填写。
     * @param reason 拒绝理由。拒绝申请时填写。
     * @return 返回结果
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/plugin-management/pluginManager.setDevPluginApplyStatus.html" target="_blank">微信官方文档</a>
     */
    WxResult setDevPluginApplyStatus(String action, String appId, String reason);

    /**
     * 删除已添加的插件
     *
     * @param pluginAppId 插件 appId
     * @return 返回结果
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/plugin-management/pluginManager.unbindPlugin.html" target="_blank">微信官方文档</a>
     */
    WxResult unbindPlugin(String pluginAppId);

}
