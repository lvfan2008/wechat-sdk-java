package fan.lv.wechat.api.official.asset.impl;

import fan.lv.wechat.api.official.Util;
import fan.lv.wechat.api.official.asset.MaterialService;
import fan.lv.wechat.entity.official.asset.*;
import fan.lv.wechat.entity.official.message.mass.base.WxArticles;
import fan.lv.wechat.entity.official.message.mass.base.WxNews;
import fan.lv.wechat.entity.result.WxResult;
import fan.lv.wechat.util.JsonUtil;
import junit.framework.TestCase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author lv_fan2008
 */
public class MaterialServiceImplTest extends TestCase {

    MaterialService materialService;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        materialService = new MaterialServiceImpl(Util.getClient());
    }

    public void testAddTemporaryMaterial() {
        WxAddTemporaryMaterialResult result = materialService.addTemporaryMaterial("image", Util.getProperty("mass.send.picture"));
        assertTrue(result.success());
    }

    public void testGetTemporaryMaterial() throws IOException {
        WxAddTemporaryMaterialResult result = materialService.addTemporaryMaterial("image", Util.getProperty("mass.send.picture"));
        WxGetTemporaryMaterialResult result2 = materialService.getTemporaryMaterial(result.getMediaId());
        assertTrue(result2.success());
    }

    public void testAddNews() {
        WxAddOtherMaterialResult result = materialService.addOtherMaterial("thumb", Util.getProperty("thumb.path"), null);
        String mediaId1 = result.getMediaId();
        result = materialService.addOtherMaterial("thumb", Util.getProperty("thumb.path"), null);
        String mediaId2 = result.getMediaId();
        String json = "{\n" +
                "   \"articles\": [\t \n" +
                "        {\n" +
                "            \"thumb_media_id\":\"" + mediaId1 + "\",\n" +
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
                "            \"thumb_media_id\":\"" + mediaId2 + "\",\n" +
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
        WxArticles wxArticles = JsonUtil.parseJson(json, WxArticles.class);
        WxAddNewsResult wxAddNewsResult = materialService.addNews(wxArticles);
        assertTrue(wxAddNewsResult.success());
    }

    public void testAddOtherMaterial() {
        WxAddOtherMaterialResult result = materialService.addOtherMaterial("thumb", Util.getProperty("thumb.path"), null);
        assertTrue(result.success());
    }

    public void testGetMaterial() {
        WxAddOtherMaterialResult result = materialService.addOtherMaterial("thumb", Util.getProperty("thumb.path"), null);
        WxGetMaterialResult result2 = materialService.getMaterial(result.getMediaId());
        assertTrue(result2.success());
    }

    public void testDeleteMaterial() {
        WxAddOtherMaterialResult result = materialService.addOtherMaterial("thumb", Util.getProperty("thumb.path"), null);
        WxResult result2 = materialService.deleteMaterial(result.getMediaId());
        assertTrue(result2.success());
    }

    public void testUpdateNews() {

        WxAddOtherMaterialResult result = materialService.addOtherMaterial("thumb", Util.getProperty("thumb.path"), null);
        String mediaId1 = result.getMediaId();
        result = materialService.addOtherMaterial("thumb", Util.getProperty("thumb.path"), null);
        String mediaId2 = result.getMediaId();
        String json = "{\n" +
                "   \"articles\": [\t \n" +
                "        {\n" +
                "            \"thumb_media_id\":\"" + mediaId1 + "\",\n" +
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
                "            \"thumb_media_id\":\"" + mediaId2 + "\",\n" +
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

        String json2 = "        {\n" +
                "            \"thumb_media_id\":\"" + mediaId1 + "\",\n" +
                "            \"author\":\"xxx2\",\t\t\n" +
                "            \"title\":\"Happy2 Day2\",\t\t \n" +
                "            \"content_source_url\":\"www2.qq.com\",\t\t\n" +
                "            \"content\":\"content2\",\t\t \n" +
                "            \"digest\":\"digest2\",\n" +
                "            \"show_cover_pic\":1,\n" +
                "            \"need_open_comment\":1,\n" +
                "            \"only_fans_can_comment\":1\n" +
                "        },\t \n";
        WxArticles wxArticles = JsonUtil.parseJson(json, WxArticles.class);
        WxAddNewsResult wxAddNewsResult = materialService.addNews(wxArticles);
        WxUpdateNewsParam wxUpdateNewsParam = new WxUpdateNewsParam();
        wxUpdateNewsParam.setIndex(0);
        wxUpdateNewsParam.setMediaId(wxAddNewsResult.getMediaId());
        wxUpdateNewsParam.setArticles(JsonUtil.parseJson(json2, WxNews.class));
        WxResult result3 = materialService.updateNews(wxUpdateNewsParam);
        assertTrue(result3.success());
    }

    public void testGetMaterialCount() {
        WxMaterialCountResult result = materialService.getMaterialCount();
        assertTrue(result.success());
    }

    public void testBatchGetMaterial() {
        WxBatchGetMaterialResult result = materialService.batchGetMaterial("news", 0, 20);
        assertTrue(result.success());
    }
}