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

import static java.util.stream.Collectors.toList;

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
        if (StringUtils.isEmpty(jsConfig.getNonceStr())) {
            jsConfig.setNonceStr(SignUtil.nonceStr());
        }
        if (StringUtils.isEmpty(jsConfig.getTimestamp())) {
            jsConfig.setTimestamp(SignUtil.timestamp());
        }
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
    public WxCardExt signatureCartExt(WxCardExt cardExt, String cardApiTicket, String cardId, String balance) {
        if (StringUtils.isEmpty(cardExt.getNonceStr())) {
            cardExt.setNonceStr(SignUtil.nonceStr());
        }
        if (StringUtils.isEmpty(cardExt.getTimestamp())) {
            cardExt.setTimestamp(SignUtil.timestamp());
        }
        String[] values = new String[]{
                cardExt.getCode(), cardExt.getNonceStr(), cardExt.getTimestamp(), cardApiTicket,
                cardExt.getOpenId(), cardExt.getOuterStr(), cardId, balance,
                cardExt.getFixedBeginTimestamp()
        };
        values = Arrays.stream(values).map(StringUtils::defaultString).toArray(String[]::new);
        Arrays.sort(values);
        cardExt.setSignature(SignUtil.sha1(StringUtils.join(values)));
        return cardExt;
    }

    @Override
    public WxChooseCard signatureChooseCard(WxChooseCard chooseCard, String cardApiTicket, String locationId) {
        if (StringUtils.isEmpty(chooseCard.getNonceStr())) {
            chooseCard.setNonceStr(SignUtil.nonceStr());
        }
        if (StringUtils.isEmpty(chooseCard.getTimestamp())) {
            chooseCard.setTimestamp(SignUtil.timestamp());
        }
        String[] values = new String[]{
                appId, cardApiTicket, locationId,
                chooseCard.getNonceStr(), chooseCard.getTimestamp(),
                chooseCard.getCardId(), chooseCard.getCardType()
        };
        values = Arrays.stream(values).map(StringUtils::defaultString).toArray(String[]::new);
        Arrays.sort(values);
        chooseCard.setCardSign(SignUtil.sha1(StringUtils.join(values)));
        return chooseCard;
    }
}
