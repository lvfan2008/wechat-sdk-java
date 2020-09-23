package fan.lv.wechat.api.official.asset.impl;

import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.official.asset.MaterialService;
import fan.lv.wechat.entity.asset.*;
import fan.lv.wechat.entity.message.mass.WxUploadMediaResult;
import fan.lv.wechat.entity.message.mass.base.WxArticles;
import fan.lv.wechat.entity.result.WxResult;
import fan.lv.wechat.util.JsonUtil;

import java.util.Collections;

/**
 * @author lv_fan2008
 */
public class MaterialServiceImpl implements MaterialService {

    /**
     * 请求客户端
     */
    protected Client client;

    public MaterialServiceImpl(Client client) {
        this.client = client;
    }

    @Override
    public WxAddTemporaryMaterialResult addTemporaryMaterial(String type, String filePath) {
        return client.uploadFile("/cgi-bin/media/upload",
                Collections.singletonMap("type", type),
                Collections.<String, String>emptyMap(),
                Collections.singletonMap("media", filePath),
                WxAddTemporaryMaterialResult.class);
    }

    @Override
    public WxGetTemporaryMaterialResult getTemporaryMaterial(String mediaId) {
        return client.get("/cgi-bin/media/get",
                Collections.singletonMap("media_id", mediaId),
                WxGetTemporaryMaterialResult.class);
    }


    @Override
    public WxAddNewsResult addNews(WxArticles articles) {
        return client.post("/cgi-bin/material/add_news", articles, WxAddNewsResult.class);
    }


    @Override
    public WxUploadMediaResult uploadPicture(String picturePath) {
        return client.uploadFile("/cgi-bin/media/uploadimg",
                Collections.<String, String>emptyMap(),
                Collections.singletonMap("media", picturePath), WxUploadMediaResult.class);
    }


    @Override
    public WxAddOtherMaterialResult addOtherMaterial(String type, String filePath, WxVideoMaterialParam wxVideoMaterialParam) {
        String video = "video";
        return client.uploadFile("/cgi-bin/material/add_material",
                Collections.singletonMap("type", type),
                video.equals(type) ? Collections.<String, String>emptyMap()
                        : Collections.singletonMap("description", JsonUtil.toJson(wxVideoMaterialParam)),
                Collections.singletonMap("media", filePath),
                WxAddOtherMaterialResult.class);
    }


    @Override
    public WxGetMaterialResult getMaterial(String mediaId) {
        return client.post("/cgi-bin/material/get_material", new WxMaterialParam(mediaId), WxGetMaterialResult.class);
    }

    @Override
    public WxResult deleteMaterial(String mediaId) {
        return client.post("/cgi-bin/material/del_material", new WxMaterialParam(mediaId), WxResult.class);
    }

    @Override
    public WxResult updateNews(WxUpdateNewsParam wxUpdateNewsParam) {
        return client.post("/cgi-bin/material/update_news", wxUpdateNewsParam, WxResult.class);
    }

    @Override
    public WxMaterialCountResult getMaterialCount() {
        return client.get("/cgi-bin/material/get_materialcount", WxMaterialCountResult.class);
    }

    @Override
    public WxBatchGetMaterialResult batchGetMaterial(String type, Integer offset, Integer count) {
        return client.post("/cgi-bin/material/batchget_material",
                new WxBatchGetMaterialParam(type, offset, count),
                WxBatchGetMaterialResult.class);
    }

}
