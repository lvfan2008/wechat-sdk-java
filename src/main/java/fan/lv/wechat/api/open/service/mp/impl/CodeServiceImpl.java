package fan.lv.wechat.api.open.service.mp.impl;

import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.open.service.mp.CodeService;
import fan.lv.wechat.entity.open.mp.code.WxGetTemplateDraftListResult;
import fan.lv.wechat.entity.open.mp.code.WxGetTemplateListResult;
import fan.lv.wechat.entity.result.WxResult;
import fan.lv.wechat.util.SimpleMap;

/**
 * @author lv_fan2008
 */
public class CodeServiceImpl implements CodeService {
    /**
     * 请求客户端
     */
    protected Client client;

    /**
     * @param client 请求客户端
     */
    public CodeServiceImpl(Client client) {
        this.client = client;
    }

    @Override
    public WxGetTemplateDraftListResult getTemplateDraftList() {
        return client.get("/wxa/gettemplatedraftlist", WxGetTemplateDraftListResult.class);
    }

    @Override
    public WxResult addToTemplate(Integer draftId) {
        return client.postJson("/wxa/addtotemplate", SimpleMap.of("draft_id", draftId), WxResult.class);
    }

    @Override
    public WxGetTemplateListResult getTemplateList() {
        return client.get("/wxa/gettemplatelist", WxGetTemplateListResult.class);
    }

    @Override
    public WxResult deleteTemplate(String templateId) {
        return client.postJson("/wxa/deletetemplate", SimpleMap.of("template_id", templateId), WxResult.class);

    }
}
