package fan.lv.wechat.api.mp.service.impl;

import fan.lv.wechat.util.RequestOptions;
import fan.lv.wechat.util.SimpleMap;
import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.mp.service.AuthService;
import fan.lv.wechat.entity.mp.user.WxSessionResult;

/**
 * @author lv_fan2008
 */
public class AuthServiceImpl implements AuthService {


    /**
     * 公众号appId
     */
    protected String appId;

    /**
     * 公众号密钥
     */
    protected String appSecret;

    /**
     * 请求客户端
     */
    protected Client client;


    /**
     * @param client 请求客户端
     */
    public AuthServiceImpl(String appId, String appSecret, Client client) {
        this.client = client;
        this.appId = appId;
        this.appSecret = appSecret;
    }

    @Override
    public WxSessionResult codeToSession(String code) {
        String url = client.getBaseUrl() + "/sns/jscode2session?&grant_type=authorization_code";
        return client.request(url,
                RequestOptions.defOpts().queryMap(
                        SimpleMap.of("appid", appId, "secret", appSecret, "js_code", code)
                ),
                WxSessionResult.class, false);
    }
}
