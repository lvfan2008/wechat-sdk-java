package fan.lv.wechat.api.official.message.mass.impl;

import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.official.message.mass.MassSendService;
import fan.lv.wechat.entity.message.mass.Articles;
import fan.lv.wechat.entity.message.mass.WxUploadArticlesResult;
import fan.lv.wechat.entity.message.mass.WxUploadMediaResult;

import java.util.Collections;

/**
 * @author lv_fan2008
 */
public class MassSendServiceImpl implements MassSendService {

    /**
     * 请求客户端
     */
    protected Client client;

    public MassSendServiceImpl(Client client) {
        this.client = client;
    }

    @Override
    public WxUploadMediaResult uploadPicture(String picturePath) {
        return client.uploadFile("/cgi-bin/media/uploadimg",
                Collections.<String, String>emptyMap(),
                Collections.singletonMap("media", picturePath), WxUploadMediaResult.class);
    }

    @Override
    public WxUploadArticlesResult uploadNews(Articles articles) {
        return client.post("/cgi-bin/media/uploadnews", articles, WxUploadArticlesResult.class);
    }
}
