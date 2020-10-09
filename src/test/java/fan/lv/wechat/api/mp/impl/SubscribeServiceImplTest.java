package fan.lv.wechat.api.mp.impl;

import fan.lv.wechat.api.mp.service.SubscribeService;
import fan.lv.wechat.api.mp.service.impl.SubscribeServiceImpl;
import fan.lv.wechat.api.official.Util;
import fan.lv.wechat.entity.mp.subscribe.*;
import fan.lv.wechat.entity.result.WxResult;
import junit.framework.TestCase;

import java.util.Arrays;

/**
 * @author lv_fan2008
 */
public class SubscribeServiceImplTest extends TestCase {

    SubscribeService subscribeService;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        subscribeService = new SubscribeServiceImpl(Util.getMpClient());
    }

    public void testAll() {
        WxCategoryResult result = subscribeService.getCategory();
        assertTrue(result.success());

        WxPubTemplateTitleResult result2 = subscribeService.getPubTemplateTitle(String.valueOf(result.getData().get(0).getId()), 0, 30);
        assertTrue(result2.success());

        String tid = String.valueOf(result2.getData().get(0).getTid());
        WxPubTemplateKeywordsResult result3 = subscribeService.getPubTemplateKeywords(tid);
        assertTrue(result3.success());

        Integer kid1 = (result3.getData().get(0).getKid());
        Integer kid2 = (result3.getData().get(1).getKid());
        WxAddTemplateResult result4 = subscribeService.addTemplate(tid, Arrays.asList(kid1, kid2), "测试");
        assertTrue(result4.success());

        WxTemplateListResult result5 = subscribeService.getTemplateList();
        assertTrue(result5.success());

        WxResult result6 = subscribeService.deleteTemplate(result4.getPriTmplId());
        assertTrue(result6.success());

    }

}