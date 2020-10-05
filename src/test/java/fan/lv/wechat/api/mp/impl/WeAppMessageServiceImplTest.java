package fan.lv.wechat.api.mp.impl;

import fan.lv.wechat.api.mp.WeAppMessageService;
import fan.lv.wechat.api.official.Util;
import fan.lv.wechat.entity.mp.message.WxUniformMessageParam;
import fan.lv.wechat.entity.mp.message.base.TextWeAppMessage;
import fan.lv.wechat.entity.mp.message.WxUploadTempMediaResult;
import fan.lv.wechat.entity.official.message.template.base.WxDataValue;
import fan.lv.wechat.entity.result.WxResult;
import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lv_fan2008
 */
public class WeAppMessageServiceImplTest extends TestCase {

    WeAppMessageService weAppMessageService;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        weAppMessageService = new WeAppMessageServiceImpl(Util.getMpClient());
    }

    public void testGetTempMedia() {
        WxUploadTempMediaResult result = weAppMessageService.uploadTempMedia("image", Util.getProperty("thumb.path"));
        assertTrue(result.success());
        WxResult result2 = weAppMessageService.getTempMedia(result.getMediaId());
        assertTrue(result.success());
    }

    public void testSend() {
        WxResult result = weAppMessageService.send("eeee", new TextWeAppMessage("hello"));
        assertEquals(40003, (int) result.getErrorCode());

    }

    public void testSendKfTypingState() {
        WxResult result = weAppMessageService.sendKfTypingState("eeee", "Typing");
        assertEquals(40003, (int) result.getErrorCode());
    }

    public void testSendUniformMessage() {
        Map<String, WxDataValue> data = new HashMap<>();
        data.put("www", new WxDataValue("hello"));
        WxUniformMessageParam.WeAppTemplateMsg msg = new WxUniformMessageParam.WeAppTemplateMsg();
        msg.setTemplateId("test");
        msg.setPage("test");
        msg.setEmphasisKeyword("ewwe");
        msg.setData(data);
        WxUniformMessageParam param = new WxUniformMessageParam();
        param.setToUser("ewwewe");
        param.setWeappTemplateMsg(msg);
        WxResult result = weAppMessageService.sendUniformMessage(param);
        assertEquals(40003, (int) result.getErrorCode());
    }

    public void testCreateActivityId() {
        WxResult result = weAppMessageService.createActivityId(null);
        assertTrue(result.success());
    }

    public void testSetUpdatableMsg() {
    }
}