package fan.lv.wechat.api.official.account.impl;

import fan.lv.wechat.util.SimpleMap;
import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.official.account.AccountService;
import fan.lv.wechat.entity.official.account.WxCreateQrCodeParam;
import fan.lv.wechat.entity.official.account.WxCreateQrCodeResult;
import fan.lv.wechat.entity.official.account.WxGetShortUrlResult;

import java.util.Map;

/**
 * @author lv_fan2008
 */
public class AccountServiceImpl implements AccountService {


    /**
     * 请求客户端
     */
    protected Client client;

    /**
     * @param client 请求客户端
     */
    public AccountServiceImpl(Client client) {
        this.client = client;
    }

    @Override
    public WxCreateQrCodeResult createQrCode(Integer expireSeconds, String actionName, Integer sceneId, String sceneStr) {
        return client.postJson("/cgi-bin/qrcode/create",
                new WxCreateQrCodeParam(expireSeconds, actionName, sceneId, sceneStr),
                WxCreateQrCodeResult.class);
    }

    @Override
    public WxGetShortUrlResult getShortUrl(String longUrl) {
        Map<String, String> map = SimpleMap.of("action", "long2short", "long_url", longUrl);
        return client.postJson("/cgi-bin/shorturl", (Object) map, WxGetShortUrlResult.class);
    }
}
