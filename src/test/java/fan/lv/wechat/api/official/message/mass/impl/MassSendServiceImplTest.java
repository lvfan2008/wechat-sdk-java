package fan.lv.wechat.api.official.message.mass.impl;

import fan.lv.wechat.api.official.Util;
import fan.lv.wechat.api.official.message.mass.MassSendService;
import fan.lv.wechat.entity.message.mass.Articles;
import fan.lv.wechat.entity.message.mass.WxUploadArticlesResult;
import fan.lv.wechat.entity.message.mass.WxUploadMediaResult;
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
        WxUploadArticlesResult wxUploadArticlesResult = massSendService.uploadNews(articles);
        assertTrue(wxUploadArticlesResult.success());
    }
}