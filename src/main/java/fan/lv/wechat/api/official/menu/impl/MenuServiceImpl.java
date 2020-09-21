package fan.lv.wechat.api.official.menu.impl;

import fan.lv.wechat.api.official.kernel.Client;
import fan.lv.wechat.api.official.menu.MenuService;
import fan.lv.wechat.entity.menu.param.WxDeletePersonalizeMenuParam;
import fan.lv.wechat.entity.menu.param.WxMenuParam;
import fan.lv.wechat.entity.menu.param.WxPersonalizeMenuParam;
import fan.lv.wechat.entity.menu.param.WxTryMatchPersonalizeMenuParam;
import fan.lv.wechat.entity.menu.result.WxCreatePersonalizeMenuResult;
import fan.lv.wechat.entity.menu.result.WxGetMenuResult;
import fan.lv.wechat.entity.menu.result.WxQueryMenuResult;
import fan.lv.wechat.entity.menu.result.WxTryMatchPersonalizeMenuResult;
import fan.lv.wechat.entity.result.WxResult;

/**
 * @author lixinguo
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
        return client.post("/cgi-bin/menu/create", wxMenuParam, WxResult.class);
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
        return client.post("/cgi-bin/menu/addconditional", wxPersonalizeMenuParam, WxCreatePersonalizeMenuResult.class);
    }

    @Override
    public WxResult deletePersonalizeMenu(WxDeletePersonalizeMenuParam wxDeletePersonalizeMenuParam) {
        return client.post("/cgi-bin/menu/delconditional", wxDeletePersonalizeMenuParam, WxResult.class);
    }

    @Override
    public WxTryMatchPersonalizeMenuResult tryMatchPersonalizeMenu(WxTryMatchPersonalizeMenuParam wxTryMatchPersonalizeMenuParam) {
        return client.post("/cgi-bin/menu/trymatch", wxTryMatchPersonalizeMenuParam, WxTryMatchPersonalizeMenuResult.class);
    }

    @Override
    public WxGetMenuResult getMenu() {
        return client.get("/cgi-bin/menu/get", WxGetMenuResult.class);
    }
}
