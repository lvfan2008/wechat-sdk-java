package fan.lv.wechat.api.mp.impl;

import com.google.common.collect.ImmutableMap;
import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.mp.SubscribeService;
import fan.lv.wechat.entity.mp.subscribe.*;
import fan.lv.wechat.entity.result.WxResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lv_fan2008
 */
public class SubscribeServiceImpl implements SubscribeService {
    /**
     * 请求客户端
     */
    protected Client client;


    /**
     * @param client 请求客户端
     */
    public SubscribeServiceImpl(Client client) {
        this.client = client;
    }

    @Override
    public WxAddTemplateResult addTemplate(String tid, List<Integer> kidList, String sceneDesc) {
        Map<String, Object> map = new HashMap<>();
        map.put("tid", tid);
        map.put("kidList", kidList);
        if (sceneDesc != null) {
            map.put("sceneDesc", sceneDesc);
        }
        return client.postJson("/wxaapi/newtmpl/addtemplate", map, WxAddTemplateResult.class);
    }

    @Override
    public WxResult deleteTemplate(String priTmplId) {
        return client.postJson("/wxaapi/newtmpl/deltemplate", ImmutableMap.of("priTmplId", priTmplId), WxResult.class);
    }

    @Override
    public WxCategoryResult getCategory() {
        return client.get("/wxaapi/newtmpl/getcategory", WxCategoryResult.class);
    }

    @Override
    public WxPubTemplateKeywordsResult getPubTemplateKeywords(String tid) {
        return client.get("/wxaapi/newtmpl/getpubtemplatekeywords", ImmutableMap.of("tid", tid),
                WxPubTemplateKeywordsResult.class);
    }

    @Override
    public WxPubTemplateTitleResult getPubTemplateTitle(String ids, Integer start, Integer limit) {
        return client.get("/wxaapi/newtmpl/getpubtemplatetitles",
                ImmutableMap.of("ids", ids, "start", String.valueOf(start), "limit", String.valueOf(limit)),
                WxPubTemplateTitleResult.class);
    }

    @Override
    public WxTemplateListResult getTemplateList() {
        return client.get("/wxaapi/newtmpl/gettemplate", WxTemplateListResult.class);
    }

    @Override
    public WxResult send(WxSendTemplateParam param) {
        return client.postJson("/cgi-bin/message/subscribe/send", param, WxResult.class);
    }
}
