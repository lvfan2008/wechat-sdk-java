package fan.lv.wechat.api.official.Intelligence.impl;

import fan.lv.wechat.api.official.Intelligence.AiService;
import fan.lv.wechat.api.official.Util;
import fan.lv.wechat.entity.official.intelligence.*;
import fan.lv.wechat.entity.result.WxResult;
import fan.lv.wechat.util.JsonUtil;
import junit.framework.TestCase;

/**
 * @author lv_fan2008
 */
public class AiServiceImplTest extends TestCase {

    AiService aiService;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        aiService = new AiServiceImpl(Util.getClient());
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
        WxSemanticResult result = aiService.search(param);
        assertTrue(result.success());
    }

    public void testAiSubmitVoiceForText() {
        WxResult result = aiService.aiSubmitVoiceForText("mp3", "voiceId12345",
                Util.getProperty("voice.path"), "en_US");
        assertTrue(result.success());
    }

    public void testAiQueryVoiceForText() {
        WxAiQueryVoiceTextResult result = aiService.aiQueryVoiceForText("voiceId12345", "en_US");
        assertTrue(result.success());
    }

    public void testAiTranslateVoice() {
        WxAiTranslateResult result = aiService.aiTranslateVoice("hello world", "en_US", "zh_CN");
        assertTrue(result.success());
    }
}