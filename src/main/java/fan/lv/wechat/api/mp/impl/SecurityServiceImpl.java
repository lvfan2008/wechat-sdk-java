package fan.lv.wechat.api.mp.impl;

import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.mp.SecurityService;
import fan.lv.wechat.entity.mp.security.WxMediaCheckAsyncResult;
import fan.lv.wechat.entity.result.WxResult;
import fan.lv.wechat.util.SimpleMap;

/**
 * @author lv_fan2008
 */
public class SecurityServiceImpl implements SecurityService {

    /**
     * 请求客户端
     */
    protected Client client;

    /**
     * @param client 请求客户端
     */
    public SecurityServiceImpl(Client client) {
        this.client = client;
    }

    @Override
    public WxResult imgSecCheck(String filePath) {
        return client.uploadFile("/wxa/img_sec_check", SimpleMap.of(),
                SimpleMap.of("media", filePath), WxResult.class);
    }

    @Override
    public WxMediaCheckAsyncResult mediaCheckAsync(String mediaUrl, Integer mediaType) {
        return client.postJson("/wxa/media_check_async",
                SimpleMap.of("media_url", mediaUrl, "media_type", mediaType),
                WxMediaCheckAsyncResult.class);
    }

    @Override
    public WxResult msgSecCheck(String content) {
        return client.postJson("/wxa/msg_sec_check", SimpleMap.of("content", content), WxResult.class);
    }
}
