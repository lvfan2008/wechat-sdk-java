package fan.lv.wechat.api.official.message.impl;

import fan.lv.wechat.api.official.Util;
import fan.lv.wechat.api.official.message.MassSendService;
import fan.lv.wechat.entity.message.*;
import fan.lv.wechat.entity.result.WxResult;
import fan.lv.wechat.util.JsonUtil;
import junit.framework.TestCase;

/**
 * @author lv_fan2008
 */
public class MassSendServiceImplTest extends TestCase {

    MassSendService massSendService;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        massSendService = new MassSendServiceImpl(Util.getClient());
    }

    public void testUploadPicture() {
        WxUploadMediaResult wxUploadMediaResult = massSendService.uploadPicture(Util.getProperty("mass.send.picture"));
        assertTrue(wxUploadMediaResult.success());
    }

    public void testUploadNews() {
        String json = "{\n" +
                "   \"articles\": [\t \n" +
                "        {\n" +
                "            \"thumb_media_id\":\"qI6_Ze_6PtV7svjolgs-rN6stStuHIjs9_DidOHaj0Q-mwvBelOXCFZiq2OsIU-p\",\n" +
                "            \"author\":\"xxx\",\t\t\n" +
                "            \"title\":\"Happy Day\",\t\t \n" +
                "            \"content_source_url\":\"www.qq.com\",\t\t\n" +
                "            \"content\":\"content\",\t\t \n" +
                "            \"digest\":\"digest\",\n" +
                "            \"show_cover_pic\":1,\n" +
                "            \"need_open_comment\":1,\n" +
                "            \"only_fans_can_comment\":1\n" +
                "        },\t \n" +
                "        {\n" +
                "            \"thumb_media_id\":\"qI6_Ze_6PtV7svjolgs-rN6stStuHIjs9_DidOHaj0Q-mwvBelOXCFZiq2OsIU-p\",\n" +
                "            \"author\":\"xxx\",\t\t\n" +
                "            \"title\":\"Happy Day\",\t\t \n" +
                "            \"content_source_url\":\"www.qq.com\",\t\t\n" +
                "            \"content\":\"content\",\t\t \n" +
                "            \"digest\":\"digest\",\n" +
                "            \"show_cover_pic\":0,\n" +
                "            \"need_open_comment\":1,\n" +
                "            \"only_fans_can_comment\":1\n" +
                "        }\n" +
                "   ]\n" +
                "}";
        Articles articles = JsonUtil.parseJson(json,Articles.class);
        WxUploadArticlesResult result = massSendService.uploadNews(articles);
        assertTrue(result.getErrorCode() > 0);
    }

    public void testMassSendAll() {
        String json = "{\n" +
                "   \"filter\":{\n" +
                "      \"is_to_all\":true\n" +
                "   },\n" +
                "   \"text\":{\n" +
                "      \"content\":\"CONTENT\"\n" +
                "   },\n" +
                "    \"msgtype\":\"text\"\n" +
                "}";

        WxMassSendByTagParam param = JsonUtil.parseJson(json,WxMassSendByTagParam.class);
        WxMassSendResult result = massSendService.massSendAll(param);
        assertTrue(result.getErrorCode() > 0);
    }

    public void testMassSendToUser() {
        String json = "{\n" +
                "   \"touser\":[\n" +
                "    \"oKCQet5s9pHv6MdylHQ9L_BX-n6E\",\n" +
                "    \"oKCQet5s9pHv6MdylHQ9L_BX-n6E\"\n" +
                "   ],\n" +
                "    \"msgtype\": \"text\",\n" +
                "    \"text\": { \"content\": \"hello from boxer.\"}\n" +
                "}";

        WxMassSendByOpenIdParam param = JsonUtil.parseJson(json,WxMassSendByOpenIdParam.class);
        WxMassSendResult result = massSendService.massSendToUser(param);
        assertTrue(result.getErrorCode() > 0);
    }

    public void testDeleteMassMessage() {
        WxDeleteMassSendParam param = new WxDeleteMassSendParam();
        param.setMsgId(323223);
        WxResult result =  massSendService.deleteMassMessage(param);
        assertTrue(result.getErrorCode() > 0);
    }

    public void testMassSendPreview() {
        String json = "{     \n" +
                "    \"touser\":\""+Util.getProperty("user_id")+"\",\n" +
                "    \"text\":{           \n" +
                "      \"content\":\"CONTENT\"            \n" +
                "    },     \n" +
                "    \"msgtype\":\"text\"\n" +
                "}";

        WxMassSendPreviewParam param = JsonUtil.parseJson(json,WxMassSendPreviewParam.class);
        WxMassSendResult result = massSendService.massSendPreview(param);
        assertTrue(result.success());
    }

    public void testQueryMassSendStatus() {
        WxQueryMassSendParam param = new WxQueryMassSendParam();
        param.setMsgId(323223);
        WxQueryMassSendResult result = massSendService.queryMassSendStatus(param);
        assertTrue(result.getErrorCode() > 0);
    }

    public void testSetMassSendSpeed() {
        WxMassSendSpeedParam param = new WxMassSendSpeedParam();
        param.setSpeed(1);
        WxMassSendSpeedResult result = massSendService.setMassSendSpeed(param);
        assertTrue(result.success());
    }
}