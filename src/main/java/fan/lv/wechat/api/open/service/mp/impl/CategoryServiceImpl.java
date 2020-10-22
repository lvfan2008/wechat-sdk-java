package fan.lv.wechat.api.open.service.mp.impl;

import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.open.service.mp.CategoryService;
import fan.lv.wechat.entity.open.mp.category.*;
import fan.lv.wechat.entity.result.WxResult;
import fan.lv.wechat.util.SimpleMap;

/**
 * @author lv_fan2008
 */
public class CategoryServiceImpl implements CategoryService {

    /**
     * 请求客户端
     */
    protected Client client;

    /**
     * @param client 请求客户端
     */
    public CategoryServiceImpl(Client client) {
        this.client = client;
    }


    @Override
    public WxGetAllCategoriesResult getAllCategories() {
        return client.get("/cgi-bin/wxopen/getallcategories", WxGetAllCategoriesResult.class);
    }

    @Override
    public WxGetSettledCategoriesResult getSettledCategories() {
        return client.get("/cgi-bin/wxopen/getcategory", WxGetSettledCategoriesResult.class);
    }

    @Override
    public WxResult addCategory(WxAddCategoryParam param) {
        return client.postJson("/cgi-bin/wxopen/addcategory", param, WxResult.class);
    }

    @Override
    public WxResult delCategory(Integer first, Integer second) {
        return client.postJson("/cgi-bin/wxopen/deletecategory",
                SimpleMap.of("first", first, "second", second),
                WxResult.class);
    }

    @Override
    public WxResult modifyCategoryCertificate(WxModifyCategoryCertificateParam param) {
        return client.postJson("/cgi-bin/wxopen/modifycategory", param, WxResult.class);
    }

    @Override
    public WxGetCanModifyCategoriesResult getCanModifyCategories() {
        return client.get("/wxa/get_category", WxGetCanModifyCategoriesResult.class);
    }
}
