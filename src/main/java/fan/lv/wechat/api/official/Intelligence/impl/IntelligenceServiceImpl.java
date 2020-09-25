package fan.lv.wechat.api.official.Intelligence.impl;

import com.google.common.collect.ImmutableMap;
import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.official.Intelligence.IntelligenceService;
import fan.lv.wechat.entity.official.intelligence.*;
import fan.lv.wechat.entity.result.WxResult;

import java.util.Map;

/**
 * @author lv_fan2008
 */
public class IntelligenceServiceImpl implements IntelligenceService {

    /**
     * 请求客户端
     */
    protected Client client;

    /**
     * @param client 请求客户端
     */
    public IntelligenceServiceImpl(Client client) {
        this.client = client;
    }

    @Override
    public WxSemanticResult search(WxSemanticParam wxSemanticParam) {
        return client.post("/semantic/semproxy/search", wxSemanticParam, WxSemanticResult.class);
    }

    @Override
    public WxResult aiSubmitVoiceForText(String format, String voiceId, String filePath, String lang) {
        Map<String, String> queryMap = ImmutableMap.of("format", format, "voice_id", voiceId,
                "lang", lang);
        return client.uploadFile("/cgi-bin/media/voice/addvoicetorecofortext", queryMap,
                ImmutableMap.<String, String>of(),
                ImmutableMap.of("media", filePath),
                WxResult.class);
    }

    @Override
    public WxAiQueryVoiceTextResult aiQueryVoiceForText(String voiceId, String lang) {
        return client.post("/cgi-bin/media/voice/queryrecoresultfortext",
                ImmutableMap.of("lang", lang, "voice_id", voiceId),
                ImmutableMap.<String, String>of(), WxAiQueryVoiceTextResult.class);
    }

    @Override
    public WxAiTranslateResult aiTranslateVoice(String content, String fromLanguage, String toLanguage) {
        return client.post("/cgi-bin/media/voice/translatecontent",
                ImmutableMap.of("lfrom", fromLanguage, "lto", toLanguage),
                content,
                WxAiTranslateResult.class);
    }

    @Override
    public WxOcrIdCardResult ocrIdCard(String imagePathOrUrl, boolean isUrl) {
        return ocrCard("/cv/ocr/idcard", imagePathOrUrl, isUrl, WxOcrIdCardResult.class);
    }

    @Override
    public WxOcrBankCardResult ocrBankCard(String imagePathOrUrl, boolean isUrl) {
        return ocrCard("/cv/ocr/bankcard", imagePathOrUrl, isUrl, WxOcrBankCardResult.class);
    }

    @Override
    public WxOcrDrivingCardResult ocrDrivingCard(String imagePathOrUrl, boolean isUrl) {
        return ocrCard("/cv/ocr/driving", imagePathOrUrl, isUrl, WxOcrDrivingCardResult.class);
    }

    @Override
    public WxOcrDrivingLicenseCardResult ocrDrivingLicenseCard(String imagePathOrUrl, boolean isUrl) {
        return ocrCard("/cv/ocr/drivinglicense", imagePathOrUrl, isUrl, WxOcrDrivingLicenseCardResult.class);
    }

    @Override
    public WxOcrBizLicenseResult ocrBizLicense(String imagePathOrUrl, boolean isUrl) {
        return ocrCard("/cv/ocr/bizlicense", imagePathOrUrl, isUrl, WxOcrBizLicenseResult.class);
    }

    @Override
    public WxOcrCommonResult ocrCommon(String imagePathOrUrl, boolean isUrl) {
        return ocrCard("/cv/ocr/comm", imagePathOrUrl, isUrl, WxOcrCommonResult.class);
    }


    /**
     * 获取Ocr识别结果
     *
     * @param uri            uri地址
     * @param imagePathOrUrl 图片文件或者url
     * @param isUrl          imagePathOrUrl是否为url
     * @param resultType     返回类型
     * @param <T>            类型模板
     * @return 识别结果
     */
    protected <T extends WxResult> T ocrCard(String uri, String imagePathOrUrl, boolean isUrl, Class<T> resultType) {
        if (isUrl) {
            return client.get(uri, ImmutableMap.of("img_url", imagePathOrUrl), resultType);
        } else {
            return client.uploadFile(uri, ImmutableMap.<String, String>of(), ImmutableMap.of("img", imagePathOrUrl), resultType);
        }
    }
}
