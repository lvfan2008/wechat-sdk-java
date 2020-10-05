package fan.lv.wechat.api.mp.impl;

import fan.lv.wechat.util.SimpleMap;
import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.mp.UserService;
import fan.lv.wechat.entity.mp.user.WxPaidUnionIdResult;
import fan.lv.wechat.entity.mp.user.WxSessionResult;

/**
 * @author lv_fan2008
 */
public class UserServiceImpl implements UserService {


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
    public UserServiceImpl(String appId, String appSecret, Client client) {
        this.client = client;
        this.appId = appId;
        this.appSecret = appSecret;
    }

    @Override
    public WxSessionResult codeToSession(String code) {
        String url = client.getBaseUrl() + "/sns/jscode2session?&grant_type=authorization_code";
        return client.get(url, SimpleMap.of("appid", appId, "secret", appSecret, "js_code", code),
                WxSessionResult.class);
    }

    @Override
    public WxPaidUnionIdResult getPaidUnionId(String openId, String transactionId, String mchId, String outTradeNo) {
        return client.get("/wxa/getpaidunionid",
                SimpleMap.of("openid", openId, "transaction_id", transactionId,
                        "mch_id", mchId, "out_trade_no", outTradeNo),
                WxPaidUnionIdResult.class);
    }
}
