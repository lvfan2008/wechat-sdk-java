package fan.lv.wechat.api.official.menu.impl;

import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.official.menu.MenuService;
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
 * @author lv_fan2008
 */
public class MenuServiceImpl implements MenuService {

    /**
     * 客户端
     */
    protected Client client;

    public MenuServiceImpl(Client client) {
        this.client = client;
    }

    @Override
    public WxResult createMenu(WxMenuParam wxMenuParam) {
        return client.postJson("/cgi-bin/menu/create", wxMenuParam, WxResult.class);
    }

    @Override
    public WxQueryMenuResult queryMenu() {
        return client.get("/cgi-bin/get_current_selfmenu_info", WxQueryMenuResult.class);
    }

    @Override
    public WxResult deleteMenu() {
        return client.get("/cgi-bin/menu/delete", WxResult.class);
    }

    @Override
    public WxCreatePersonalizeMenuResult createPersonalizeMenu(WxPersonalizeMenuParam wxPersonalizeMenuParam) {
        return client.postJson("/cgi-bin/menu/addconditional", wxPersonalizeMenuParam, WxCreatePersonalizeMenuResult.class);
    }

    @Override
    public WxResult deletePersonalizeMenu(WxDeletePersonalizeMenuParam wxDeletePersonalizeMenuParam) {
        return client.postJson("/cgi-bin/menu/delconditional", wxDeletePersonalizeMenuParam, WxResult.class);
    }

    @Override
    public WxTryMatchPersonalizeMenuResult tryMatchPersonalizeMenu(WxTryMatchPersonalizeMenuParam wxTryMatchPersonalizeMenuParam) {
        return client.postJson("/cgi-bin/menu/trymatch", wxTryMatchPersonalizeMenuParam, WxTryMatchPersonalizeMenuResult.class);
    }

    @Override
    public WxGetMenuResult getMenu() {
        return client.get("/cgi-bin/menu/get", WxGetMenuResult.class);
    }
}
