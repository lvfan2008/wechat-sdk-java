package fan.lv.wechat.api.official.jssdk.imp;

import fan.lv.wechat.api.kernel.Cache;
import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.official.jssdk.JsSdkService;
import fan.lv.wechat.entity.official.jssdk.*;
import fan.lv.wechat.util.JsonUtil;
import fan.lv.wechat.util.SignUtil;
import fan.lv.wechat.util.crpto.SHA1;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    public WxJsSdkTicketResult getJsSdkTicket(boolean tryCache) {
        String key = "fan.lv.wechat.jssdk." + appId;
        if (tryCache) {
            String json = cache.get(key);
            if (!StringUtils.isEmpty(json)) {
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
    public String signatureJsSdk(String nonce, String timestamp, String url, String ticket) {
        return SignUtil.sha1(String.format("jsapi_ticket=%s&noncestr=%s&timestamp=%s&url=%s",
                ticket, nonce, timestamp, url));
    }

    @Override
    public WxJsConfig getJsConfig(Boolean debug, List<String> jsApiList, String url, String ticket) {
        WxJsConfig jsConfig = new WxJsConfig();
        jsConfig.setDebug(debug);
        jsConfig.setAppId(appId);
        jsConfig.setNonceStr(SignUtil.nonceStr());
        jsConfig.setTimestamp(SignUtil.timestamp());
        jsConfig.setJsApiList(jsApiList);
        jsConfig.setSignature(signatureJsSdk(jsConfig.getNonceStr(), jsConfig.getTimestamp(), url, ticket));
        return jsConfig;
    }

    @Override
    public WxCardApiTicketResult getCardApiTicket(boolean tryCache) {
        String key = "fan.lv.wechat.cardapi." + appId;
        if (tryCache) {
            String json = cache.get(key);
            if (!StringUtils.isEmpty(json)) {
                return JsonUtil.parseJson(json, WxCardApiTicketResult.class);
            }
        }
        WxCardApiTicketResult result = client.get("/cgi-bin/ticket/getticket?type=wx_card", WxCardApiTicketResult.class);
        if (result.success()) {
            cache.put(key, JsonUtil.toJson(result), result.getExpiresIn() - 10);
        }
        return result;
    }

    @Override
    public WxCardExt signatureChooseCard(WxCardExt cardExt, String cardApiTicket, String cardId, String balance) {
        cardExt.setNonceStr(SignUtil.nonceStr());
        cardExt.setTimestamp(SignUtil.timestamp());
        String[] values = new String[]{
                cardExt.getCode(), cardExt.getNonceStr(), cardExt.getTimestamp(), cardApiTicket,
                cardExt.getOpenId(), cardExt.getOuterStr(), cardId, balance,
                cardExt.getFixedBeginTimestamp()
        };
        Arrays.sort(values);
        cardExt.setSignature(SignUtil.sha1(StringUtils.join(values)));
        return cardExt;
    }

    @Override
    public WxChooseCard signatureChooseCard(WxChooseCard chooseCard, String cardApiTicket, String locationId) {
        chooseCard.setNonceStr(SignUtil.nonceStr());
        chooseCard.setTimestamp(SignUtil.timestamp());
        String[] values = new String[]{
                appId, cardApiTicket, locationId,
                chooseCard.getNonceStr(), chooseCard.getTimestamp(),
                chooseCard.getCardId(), chooseCard.getCardType()
        };
        Arrays.sort(values);
        chooseCard.setCardSign(SignUtil.sha1(StringUtils.join(values)));
        return chooseCard;
    }
}
