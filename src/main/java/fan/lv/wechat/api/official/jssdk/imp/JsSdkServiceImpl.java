package fan.lv.wechat.api.official.jssdk.imp;

import fan.lv.wechat.api.kernel.Cache;
import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.official.jssdk.JsSdkService;
import fan.lv.wechat.entity.official.jssdk.WxJsSdkTicketResult;
import fan.lv.wechat.util.JsonUtil;
import fan.lv.wechat.util.crpto.SHA1;
import org.apache.commons.lang3.StringUtils;

/**
 * @author lv_fan2008
 */
public class JsSdkServiceImpl implements JsSdkService {

    /**
     * 公众号appId
     */
    protected String appId;

    /**
     * Cache，用于保存token
     */
    protected Cache cache;

    /**
     * 客户端
     */
    Client client;


    /**
     * @param client 客户端
     * @param cache  缓存接口，用于存储token
     */
    public JsSdkServiceImpl(String appId, Client client, Cache cache) {
        this.appId = appId;
        this.client = client;
        this.cache = cache;
    }

    @Override
    public WxJsSdkTicketResult getTicket(boolean tryCache) {
        String key = "fan.lv.wechat.jssdk." + appId;
        if (tryCache) {
            String json = cache.get(key);
            if (StringUtils.isEmpty(json)) {
                return JsonUtil.parseJson(json, WxJsSdkTicketResult.class);
            }
        }
        WxJsSdkTicketResult result = client.get("/cgi-bin/ticket/getticket?type=jsapi", WxJsSdkTicketResult.class);
        if (result.success()) {
            cache.put(key, JsonUtil.toJson(result), result.getExpiresIn() - 10);
        }
        return result;
    }

    @Override
    public String signature(String nonce, String timestamp, String url, String ticket) {
        try {
            String str = String.format("jsapi_ticket=%s&noncestr=%s&timestamp=%s&url=%s",
                    ticket, nonce, timestamp, url);
            return SHA1.getSha1(str);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
