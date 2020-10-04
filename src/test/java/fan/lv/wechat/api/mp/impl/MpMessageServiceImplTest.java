package fan.lv.wechat.api.mp.impl;

import fan.lv.wechat.api.mp.DataAnalysisService;
import fan.lv.wechat.api.mp.MpMessageService;
import fan.lv.wechat.api.official.Util;
import fan.lv.wechat.entity.mp.message.TextMpMessage;
import fan.lv.wechat.entity.mp.message.WxUploadTempMediaResult;
import fan.lv.wechat.entity.result.WxResult;
import junit.framework.TestCase;

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
}