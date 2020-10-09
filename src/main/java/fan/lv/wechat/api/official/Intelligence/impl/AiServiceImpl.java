package fan.lv.wechat.api.official.Intelligence.impl;

import fan.lv.wechat.util.SimpleMap;
import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.official.Intelligence.AiService;
import fan.lv.wechat.entity.official.intelligence.*;
import fan.lv.wechat.entity.result.WxResult;

import java.util.Map;

/**
 * @author lv_fan2008
 */
public class AiServiceImpl implements AiService {

    /**
     * 请求客户端
     */
    protected Client client;

    /**
     * @param client 请求客户端
     */
    public AiServiceImpl(Client client) {
        this.client = client;
    }

    @Override
    public WxSemanticResult search(WxSemanticParam wxSemanticParam) {
        return client.postJson("/semantic/semproxy/search", wxSemanticParam, WxSemanticResult.class);
    }

    @Override
    public WxResult aiSubmitVoiceForText(String format, String voiceId, String filePath, String lang) {
        Map<String, String> queryMap = SimpleMap.of("format", format, "voice_id", voiceId,
                "lang", lang);
        return client.uploadFile("/cgi-bin/media/voice/addvoicetorecofortext", queryMap,
                SimpleMap.<String, String>of(),
                SimpleMap.of("media", filePath),
                WxResult.class);
    }

    @Override
    public WxAiQueryVoiceTextResult aiQueryVoiceForText(String voiceId, String lang) {
        return client.postJson("/cgi-bin/media/voice/queryrecoresultfortext",
                SimpleMap.of("lang", lang, "voice_id", voiceId),
                SimpleMap.<String, String>of(), WxAiQueryVoiceTextResult.class);
    }

    @Override
    public WxAiTranslateResult aiTranslateVoice(String content, String fromLanguage, String toLanguage) {
        return client.postJson("/cgi-bin/media/voice/translatecontent",
                SimpleMap.of("lfrom", fromLanguage, "lto", toLanguage),
                content,
                WxAiTranslateResult.class);
    }
}
