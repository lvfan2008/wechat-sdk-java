package fan.lv.wechat.api.official.menu.impl;

import fan.lv.wechat.api.official.Util;
import fan.lv.wechat.api.official.menu.MenuService;
import fan.lv.wechat.entity.menu.WxDeletePersonalizeMenuParam;
import fan.lv.wechat.entity.menu.WxMenuParam;
import fan.lv.wechat.entity.menu.WxPersonalizeMenuParam;
import fan.lv.wechat.entity.menu.WxTryMatchPersonalizeMenuParam;
import fan.lv.wechat.entity.menu.WxCreatePersonalizeMenuResult;
import fan.lv.wechat.entity.menu.WxGetMenuResult;
import fan.lv.wechat.entity.menu.WxQueryMenuResult;
import fan.lv.wechat.entity.menu.WxTryMatchPersonalizeMenuResult;
import fan.lv.wechat.entity.result.WxResult;
import fan.lv.wechat.util.JsonUtil;
import junit.framework.TestCase;

/**
 * @author lv_fan2008
 */
public class MenuServiceImplTest extends TestCase {

    MenuService menuService;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        menuService = new MenuServiceImpl(Util.getClient());
    }

    private WxResult createMenu() {
        String json = " {\"button\": [\n" +
                "            {\n" +
                "                \"type\": \"click\", \n" +
                "                \"name\": \"今日歌曲\", \n" +
                "                \"key\": \"V1001_TODAY_MUSIC\", \n" +
                "                \"sub_button\": [ ]\n" +
                "            }, \n" +
                "            {\n" +
                "                \"type\": \"click\", \n" +
                "                \"name\": \"歌手简介\", \n" +
                "                \"key\": \"V1001_TODAY_SINGER\", \n" +
                "                \"sub_button\": [ ]\n" +
                "            }, \n" +
                "            {\n" +
                "                \"name\": \"菜单\", \n" +
                "                \"sub_button\": [\n" +
                "                    {\n" +
                "                        \"type\": \"view\", \n" +
                "                        \"name\": \"搜索\", \n" +
                "                        \"url\": \"http://www.soso.com/\", \n" +
                "                        \"sub_button\": [ ]\n" +
                "                    }, \n" +
                "                    {\n" +
                "                        \"type\": \"view\", \n" +
                "                        \"name\": \"视频\", \n" +
                "                        \"url\": \"http://v.qq.com/\", \n" +
                "                        \"sub_button\": [ ]\n" +
                "                    }, \n" +
                "                    {\n" +
                "                        \"type\": \"click\", \n" +
                "                        \"name\": \"赞一下我们\", \n" +
                "                        \"key\": \"V1001_GOOD\", \n" +
                "                        \"sub_button\": [ ]\n" +
                "                    }\n" +
                "                ]\n" +
                "            }\n" +
                "        ]}";
        WxMenuParam wxMenuParam = JsonUtil.parseJson(json, WxMenuParam.class);
        return menuService.createMenu(wxMenuParam);
    }

    public void testCreateMenu() {
        WxResult wxResult = createMenu();
        assertTrue(wxResult.success());
    }

    public void testQueryMenu() {
        WxQueryMenuResult queryMenuResult = menuService.queryMenu();
        assertTrue(queryMenuResult.success());
    }

    public void testDeleteMenu() {
        WxResult wxResult = menuService.deleteMenu();
        assertTrue(wxResult.success());
    }

    private WxCreatePersonalizeMenuResult createPersonalizeMenu() {
        String json = "{\n" +
                "    \"button\": [\n" +
                "        {\n" +
                "            \"type\": \"click\", \n" +
                "            \"name\": \"今日歌曲\", \n" +
                "            \"key\": \"V1001_TODAY_MUSIC\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"name\": \"菜单\", \n" +
                "            \"sub_button\": [\n" +
                "                {\n" +
                "                    \"type\": \"view\", \n" +
                "                    \"name\": \"搜索\", \n" +
                "                    \"url\": \"http://www.soso.com/\"\n" +
                "                }, \n" +
                "                {\n" +
                "                    \"type\": \"miniprogram\", \n" +
                "                    \"name\": \"wxa\", \n" +
                "                    \"url\": \"http://mp.weixin.qq.com\", \n" +
                "                    \"appid\": \"wx286b93c14bbf93aa\", \n" +
                "                    \"pagepath\": \"pages/lunar/index\"\n" +
                "                }, \n" +
                "                {\n" +
                "                    \"type\": \"click\", \n" +
                "                    \"name\": \"赞一下我们\", \n" +
                "                    \"key\": \"V1001_GOOD\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ], \n" +
                "    \"matchrule\": {\n" +
                "        \"tag_id\": \"2\", \n" +
                "        \"sex\": \"1\", \n" +
                "        \"country\": \"中国\", \n" +
                "        \"province\": \"广东\", \n" +
                "        \"city\": \"广州\", \n" +
                "        \"client_platform_type\": \"2\", \n" +
                "        \"language\": \"zh_CN\"\n" +
                "    }\n" +
                "}";
        WxPersonalizeMenuParam wxPersonalizeMenuParam = JsonUtil.parseJson(json, WxPersonalizeMenuParam.class);
        return menuService.createPersonalizeMenu(wxPersonalizeMenuParam);
    }

    public void testCreatePersonalizeMenu() {
        createMenu();
        WxCreatePersonalizeMenuResult createPersonalizeMenuResult = createPersonalizeMenu();
        assertTrue(createPersonalizeMenuResult.success());
    }

    public void testDeletePersonalizeMenu() {
        createMenu();
        WxCreatePersonalizeMenuResult createPersonalizeMenuResult = createPersonalizeMenu();
        WxDeletePersonalizeMenuParam deletePersonalizeMenuParam = new WxDeletePersonalizeMenuParam();
        deletePersonalizeMenuParam.setMenuId(createPersonalizeMenuResult.getMenuId());
        WxResult wxResult = menuService.deletePersonalizeMenu(deletePersonalizeMenuParam);
        assertTrue(wxResult.success());
    }

    public void testTryMatchPersonalizeMenu() {
        createMenu();
        createPersonalizeMenu();
        WxTryMatchPersonalizeMenuParam tryMatchPersonalizeMenuParam = new WxTryMatchPersonalizeMenuParam();
        tryMatchPersonalizeMenuParam.setUserId(Util.getProperty("user_id"));
        WxTryMatchPersonalizeMenuResult result = menuService.tryMatchPersonalizeMenu(tryMatchPersonalizeMenuParam);
        assertTrue(result.success());
    }

    public void testGetMenu() {
        createMenu();
        createPersonalizeMenu();
        WxGetMenuResult menu = menuService.getMenu();
        assertTrue(menu.success());
    }
}