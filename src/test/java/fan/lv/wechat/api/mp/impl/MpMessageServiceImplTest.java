package fan.lv.wechat.api.mp.impl;

import fan.lv.wechat.api.mp.MpMessageService;
import fan.lv.wechat.api.official.Util;
import fan.lv.wechat.entity.mp.message.WxCreateActivityIdResult;
import fan.lv.wechat.entity.mp.message.WxUniformMessageParam;
import fan.lv.wechat.entity.mp.message.WxUpdatableMsgParam;
import fan.lv.wechat.entity.mp.message.base.TextMpMessage;
import fan.lv.wechat.entity.mp.message.WxUploadTempMediaResult;
import fan.lv.wechat.entity.official.message.template.base.WxDataValue;
import fan.lv.wechat.entity.result.WxResult;
import junit.framework.TestCase;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lv_fan2008
 */
public class MpMessageServiceImplTest extends TestCase {

    MpMessageService mpMessageService;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mpMessageService = new MpMessageServiceImpl(Util.getMpClient());
    }

    public void testGetTempMedia() {
        WxUploadTempMediaResult result = mpMessageService.uploadTempMedia("image", Util.getProperty("thumb.path"));
        assertTrue(result.success());
        WxResult result2 = mpMessageService.getTempMedia(result.getMediaId());
        assertTrue(result.success());
    }

    public void testSend() {
        WxResult result = mpMessageService.send("eeee", new TextMpMessage("hello"));
        assertEquals(40003, (int) result.getErrorCode());

    }

    public void testSendKfTypingState() {
        WxResult result = mpMessageService.sendKfTypingState("eeee", "Typing");
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
        WxResult result = mpMessageService.sendUniformMessage(param);
        assertEquals(40003, (int) result.getErrorCode());
    }

    public void testCreateActivityId() {
        WxCreateActivityIdResult result = mpMessageService.createActivityId(null);
        assertTrue(result.success());
    }

    public void testSetUpdatableMsg() {
        WxCreateActivityIdResult result = mpMessageService.createActivityId(null);
        assertTrue(result.success());
        WxUpdatableMsgParam param = new WxUpdatableMsgParam();
        WxUpdatableMsgParam.TemplateInfo info = new WxUpdatableMsgParam.TemplateInfo();
        info.setParameterList(Arrays.asList(new WxUpdatableMsgParam.TemplateParameter("member_count", "10"),
                new WxUpdatableMsgParam.TemplateParameter("room_limit", "20")
        ));
        param.setActivityId(result.getActivityId());
        param.setTargetState(0);
        param.setTemplateInfo(info);
        WxResult result2 = mpMessageService.setUpdatableMsg(param);
        assertTrue(result2.success());
    }
}