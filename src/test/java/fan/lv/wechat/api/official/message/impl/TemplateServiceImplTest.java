package fan.lv.wechat.api.official.message.impl;

import fan.lv.wechat.api.official.Util;
import fan.lv.wechat.api.official.message.TemplateService;
import fan.lv.wechat.entity.message.template.*;
import fan.lv.wechat.entity.result.WxResult;
import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lv_fan2008
 */
public class TemplateServiceImplTest extends TestCase {

    TemplateService templateService;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        templateService = new TemplateServiceImpl(Util.getClient());
    }

    public void testSetIndustry() {
        WxResult result = templateService.setIndustry(1, 2);
        assertTrue(result.success());
    }

    public void testGetIndustry() {
        WxIndustryResult result = templateService.getIndustry();
        assertTrue(result.success());
    }

    public void testGetTemplateId() {
        WxGetTemplateIdResult result = templateService.getTemplateId("TM00303");
        WxResult result2 = templateService.deleteTemplateId(result.getTemplateId());
        assertTrue(result.success());
    }

    public void testGetTemplateList() {
        WxTemplateListResult result = templateService.getTemplateList();
        assertTrue(result.success());
    }

    public void testDeleteTemplateId() {
        WxGetTemplateIdResult result = templateService.getTemplateId("TM00303");
        WxResult result2 = templateService.deleteTemplateId(result.getTemplateId());
        assertTrue(result.success());
    }

    public void testSendTemplateMessage() {
        WxGetTemplateIdResult result = templateService.getTemplateId("TM00303");
        WxTemplateMessageParam param = new WxTemplateMessageParam();
        param.setToUser(Util.getProperty("user_id"));
        param.setTemplateId(result.getTemplateId());
        param.setUrl("http://www.baidu.com");

        Map<String, WxTemplateMessageParam.DataValue> data = new HashMap<>();
        data.put("first", new WxTemplateMessageParam.DataValue("你好", "#00ff00"));
        data.put("delivername", new WxTemplateMessageParam.DataValue("顺丰", "#00ffff"));
        data.put("ordername", new WxTemplateMessageParam.DataValue("9834983489982398", "#ffff00"));
        data.put("remark", new WxTemplateMessageParam.DataValue("祝你一路顺丰", "#ff00ff"));
        param.setData(data);

        WxSendTemplateMessageResult result2 = templateService.sendTemplateMessage(param);
        templateService.deleteTemplateId(result.getTemplateId());
        assertTrue(result2.success());
    }
}