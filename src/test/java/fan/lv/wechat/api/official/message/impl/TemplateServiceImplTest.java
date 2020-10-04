package fan.lv.wechat.api.official.message.impl;

import fan.lv.wechat.api.official.Util;
import fan.lv.wechat.api.official.message.TemplateService;
import fan.lv.wechat.entity.official.message.template.*;
import fan.lv.wechat.entity.official.message.template.base.WxDataColorValue;
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

        Map<String, WxDataColorValue> data = new HashMap<>();
        data.put("first", new WxDataColorValue("你好", "#00ff00"));
        data.put("delivername", new WxDataColorValue("顺丰", "#00ffff"));
        data.put("ordername", new WxDataColorValue("9834983489982398", "#ffff00"));
        data.put("remark", new WxDataColorValue("祝你一路顺丰", "#ff00ff"));
        param.setData(data);

        WxSendTemplateMessageResult result2 = templateService.sendTemplateMessage(param);
        templateService.deleteTemplateId(result.getTemplateId());
        assertTrue(result2.success());
    }

    public void testSendSubscribeMessage() {
        WxGetTemplateIdResult result = templateService.getTemplateId("TM00303");
        WxSubscribeMessageParam param = new WxSubscribeMessageParam();
        param.setToUser(Util.getProperty("user_id"));
        param.setTemplateId(result.getTemplateId());
        param.setUrl("http://www.baidu.com");

        WxSubscribeMessageParam.DataContent dataContent = new WxSubscribeMessageParam.DataContent(
                new WxDataColorValue("测试一次性订阅接口", "#00ff00")
        );
        param.setData(dataContent);

        WxResult result2 = templateService.sendSubscribeMessage(param);
        templateService.deleteTemplateId(result.getTemplateId());
        assertTrue(result2.getErrorCode() > 0);
    }
}