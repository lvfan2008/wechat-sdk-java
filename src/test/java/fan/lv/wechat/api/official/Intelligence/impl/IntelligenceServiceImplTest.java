package fan.lv.wechat.api.official.Intelligence.impl;

import fan.lv.wechat.api.official.Intelligence.IntelligenceService;
import fan.lv.wechat.api.official.Util;
import fan.lv.wechat.entity.official.intelligence.*;
import fan.lv.wechat.entity.result.WxResult;
import fan.lv.wechat.util.JsonUtil;
import junit.framework.TestCase;

/**
 * @author lv_fan2008
 */
public class IntelligenceServiceImplTest extends TestCase {

    IntelligenceService intelligenceService;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        intelligenceService = new IntelligenceServiceImpl(Util.getClient());
    }


    public void testSearch() {
        String json = "{\n" +
                "\"query\":\"查一下明天从北京到上海的南航机票\",\n" +
                "\"city\":\"北京\",\n" +
                "\"category\": \"flight,hotel\",\n" +
                "\"appid\":\"wxaaaaaaaaaaaaaaaa\",\n" +
                "\"uid\":\"123456\"\n" +
                "}";
        WxSemanticParam param = JsonUtil.parseJson(json, WxSemanticParam.class);
        WxSemanticResult result = intelligenceService.search(param);
        assertTrue(result.success());
    }

    public void testAiSubmitVoiceForText() {
        WxResult result = intelligenceService.aiSubmitVoiceForText("mp3", "voiceId12345",
                Util.getProperty("voice.path"), "en_US");
        assertTrue(result.success());
    }

    public void testAiQueryVoiceForText() {
        WxAiQueryVoiceTextResult result = intelligenceService.aiQueryVoiceForText("voiceId12345", "en_US");
        assertTrue(result.success());
    }

    public void testAiTranslateVoice() {
        WxAiTranslateResult result = intelligenceService.aiTranslateVoice("hello world", "en_US", "zh_CN");
        assertTrue(result.success());
    }

    public void testOcrIdCard() {
        WxOcrIdCardResult result = intelligenceService.ocrIdCard(Util.getProperty("ocr.idCardFront"), false);
        assertTrue(result.success() || result.getErrorCode() == 48001);

        result = intelligenceService.ocrIdCard(Util.getProperty("ocr.idCardBack"), false);
        assertTrue(result.success() || result.getErrorCode() == 48001);
    }

    public void testOcrBankCard() {
        WxOcrBankCardResult result = intelligenceService.ocrBankCard(Util.getProperty("ocr.bankCard"), false);
        assertTrue(result.success() || result.getErrorCode() == 48001);
    }

    public void testOcrDrivingCard() {
        WxOcrDrivingCardResult result = intelligenceService.ocrDrivingCard(Util.getProperty("ocr.drivingCard"), false);
        assertTrue(result.success() || result.getErrorCode() == 48001);
    }

    public void testOcrDrivingLicenseCard() {
        WxOcrDrivingLicenseCardResult result = intelligenceService.ocrDrivingLicenseCard(Util.getProperty("ocr.drivingLicenseCard"), false);
        assertTrue(result.success() || result.getErrorCode() == 48001);
    }

    public void testOcrBizLicense() {
        WxOcrBizLicenseResult result = intelligenceService.ocrBizLicense(Util.getProperty("ocr.drivingLicenseCard"), false);
        assertTrue(result.success() || result.getErrorCode() == 48001);
    }

    public void testOcrCommon() {
        WxOcrCommonResult result = intelligenceService.ocrCommon(Util.getProperty("ocr.common"), false);
        assertTrue(result.success() || result.getErrorCode() == 48001);
    }

}