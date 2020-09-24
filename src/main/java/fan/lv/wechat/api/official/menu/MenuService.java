package fan.lv.wechat.api.official.menu;

import fan.lv.wechat.entity.official.menu.WxDeletePersonalizeMenuParam;
import fan.lv.wechat.entity.official.menu.WxMenuParam;
import fan.lv.wechat.entity.official.menu.WxPersonalizeMenuParam;
import fan.lv.wechat.entity.official.menu.WxTryMatchPersonalizeMenuParam;
import fan.lv.wechat.entity.official.menu.WxCreatePersonalizeMenuResult;
import fan.lv.wechat.entity.official.menu.WxGetMenuResult;
import fan.lv.wechat.entity.official.menu.WxQueryMenuResult;
import fan.lv.wechat.entity.official.menu.WxTryMatchPersonalizeMenuResult;
import fan.lv.wechat.entity.result.WxResult;

/**
 * 菜单Api
 *
 * @author lv_fan2008
 */
public interface MenuService {

    /**
     * 创建自定义菜单
     *
     * @param wxMenuParam 菜单参数
     * @return 创建菜单结果
     */
    WxResult createMenu(WxMenuParam wxMenuParam);

    /**
     * 查询菜单
     *
     * @return 菜单
     */
    WxQueryMenuResult queryMenu();

    /**
     * 删除菜单
     *
     * @return 删除结果
     */
    WxResult deleteMenu();

    /**
     * 创建个性化菜单
     *
     * @param wxPersonalizeMenuParam 个性化菜单
     * @return 个性化菜单Id
     */
    WxCreatePersonalizeMenuResult createPersonalizeMenu(WxPersonalizeMenuParam wxPersonalizeMenuParam);


    /**
     * 删除个性化菜单
     *
     * @param wxDeletePersonalizeMenuParam 个性化菜单参数
     * @return 删除结果
     */
    WxResult deletePersonalizeMenu(WxDeletePersonalizeMenuParam wxDeletePersonalizeMenuParam);


    /**
     * 测试个性化菜单匹配结果
     *
     * @param wxTryMatchPersonalizeMenuParam 测试个性化菜单参数
     * @return 测试个性化菜单匹配结果
     */
    WxTryMatchPersonalizeMenuResult tryMatchPersonalizeMenu(WxTryMatchPersonalizeMenuParam wxTryMatchPersonalizeMenuParam);

    /**
     * 使用接口创建自定义菜单后，开发者还可使用接口查询自定义菜单的结构。
     * 另外请注意，在设置了个性化菜单后，使用本自定义菜单查询接口可以获取默认菜单和全部个性化菜单信息。
     *
     * @return 自定义菜单的结构
     */
    WxGetMenuResult getMenu();

}
