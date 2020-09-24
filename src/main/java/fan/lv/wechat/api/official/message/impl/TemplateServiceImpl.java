package fan.lv.wechat.api.official.message.impl;

import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.official.message.TemplateService;
import fan.lv.wechat.entity.official.message.template.*;
import fan.lv.wechat.entity.result.WxResult;

/**
 * @author lv_fan2008
 */
public class TemplateServiceImpl implements TemplateService {

    /**
     * 请求客户端
     */
    protected Client client;

    public TemplateServiceImpl(Client client) {
        this.client = client;
    }

    @Override
    public WxResult setIndustry(Integer industryId1, Integer industryId2) {
        return client.post("/cgi-bin/template/api_set_industry", new WxIndustryParam(industryId1, industryId2),
                WxResult.class);
    }

    @Override
    public WxIndustryResult getIndustry() {
        return client.get("/cgi-bin/template/get_industry", WxIndustryResult.class);
    }

    @Override
    public WxGetTemplateIdResult getTemplateId(String templateIdShort) {
        return client.post("/cgi-bin/template/api_add_template", new WxGetTemplateIdParam(templateIdShort),
                WxGetTemplateIdResult.class);
    }

    @Override
    public WxTemplateListResult getTemplateList() {
        return client.get("/cgi-bin/template/get_all_private_template", WxTemplateListResult.class);
    }

    @Override
    public WxResult deleteTemplateId(String templateId) {
        return client.post("/cgi-bin/template/api_add_template", new WxDeleteTemplateIdParam(templateId), WxResult.class);
    }

    @Override
    public WxSendTemplateMessageResult sendTemplateMessage(WxTemplateMessageParam wxTemplateMessageParam) {
        return client.post("/cgi-bin/message/template/send", wxTemplateMessageParam, WxSendTemplateMessageResult.class);
    }

    @Override
    public WxResult sendSubscribeMessage(WxSubscribeMessageParam wxSubscribeMessageParam) {
        return client.post("/cgi-bin/message/template/subscribe", wxSubscribeMessageParam, WxResult.class);
    }
}
