package fan.lv.wechat.api.official.message.impl;

import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.official.message.MassSendService;
import fan.lv.wechat.entity.message.*;
import fan.lv.wechat.entity.result.WxResult;

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

    @Override
    public WxMassSendResult massSendAll(WxMassSendByTagParam wxMassSendByTagParam) {
        return client.post("/cgi-bin/message/mass/sendall", wxMassSendByTagParam, WxMassSendResult.class);
    }

    @Override
    public WxMassSendResult massSendToUser(WxMassSendByOpenIdParam wxMassSendByOpenIdParam) {
        return client.post("/cgi-bin/message/mass/send", wxMassSendByOpenIdParam, WxMassSendResult.class);
    }

    @Override
    public WxResult deleteMassMessage(WxDeleteMassSendParam wxDeleteMassSendParam) {
        return client.post("/cgi-bin/message/mass/delete", wxDeleteMassSendParam, WxResult.class);
    }

    @Override
    public WxMassSendResult massSendPreview(WxMassSendPreviewParam wxMassSendPreviewParam) {
        return client.post("/cgi-bin/message/mass/preview", wxMassSendPreviewParam, WxMassSendResult.class);
    }

    @Override
    public WxQueryMassSendResult queryMassSendStatus(WxQueryMassSendParam wxQueryMassSendParam) {
        return client.post("/cgi-bin/message/mass/get", wxQueryMassSendParam, WxQueryMassSendResult.class);
    }

    @Override
    public WxMassSendSpeedResult setMassSendSpeed(WxMassSendSpeedParam wxMassSendSpeedParam) {
        return client.post("/cgi-bin/message/mass/speed/get", wxMassSendSpeedParam, WxMassSendSpeedResult.class);
    }
}
