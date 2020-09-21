package fan.lv.wechat.api.official.kernel.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import fan.lv.wechat.api.official.kernel.Cache;
import fan.lv.wechat.api.official.kernel.Client;
import fan.lv.wechat.entity.base.result.WxAccessTokenResult;
import fan.lv.wechat.entity.result.WxResult;
import fan.lv.wechat.util.HttpUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

/**
 * @author lixinguo
 */
@Slf4j
public class ClientImpl implements Client {

    public static final int ERROR_CODE_ACCESS_TOKEN_TIMEOUT = 42001;
    /**
     * api base url
     */
    protected final String BASE_URL = "https://api.weixin.qq.com";

    /**
     * 公众号appId
     */
    protected String appId;

    /**
     * 公众号密钥
     */
    protected String appSecret;

    /**
     * Cache，用于保存token
     */
    protected Cache cache;

    /**
     * 缓存token键值
     */
    protected String accessTokenCacheKey = "official-access-token-";

    /**
     * @param appId     公众号appId
     * @param appSecret 公众号密钥
     * @param cache     缓存接口，用于存储token
     */
    public ClientImpl(String appId, String appSecret, Cache cache) {
        this.appId = appId;
        this.appSecret = appSecret;
        this.cache = cache;
        this.accessTokenCacheKey = "official-access-token-" + this.appId;
    }


    /**
     * @param uri        uri地址
     * @param resultType 返回类型
     * @return 返回结果
     */
    @Override
    public <T extends WxResult> T get(String uri, Class<T> resultType) {
        return this.request(uri, null, resultType);
    }

    /**
     * post请求
     *
     * @param uri        uri地址
     * @param object     json参数对象
     * @param resultType 返回类型
     * @return 返回结果
     */
    @Override
    public <T extends WxResult> T post(String uri, Object object, Class<T> resultType) {
        return this.request(uri, object, resultType);
    }

    /**
     * 得到TokenKenKey
     *
     * @return 缓存token关键字
     */
    private String getAccessTokenCacheKey() {
        return this.accessTokenCacheKey;
    }

    /**
     * 缓存token
     *
     * @param accessTokenResult accessToken结果
     * @throws JsonProcessingException json处理异常
     */
    private void cacheToken(WxAccessTokenResult accessTokenResult) throws JsonProcessingException {
        String json = accessTokenResult.toJson();
        cache.put(getAccessTokenCacheKey(), json, 3600 * 2 - 10);

    }

    /**
     * 得到缓存token
     *
     * @return token
     */
    private String getCacheToken() {
        String json = cache.get(getAccessTokenCacheKey());
        if (json == null || json.isEmpty()) {
            return null;
        }
        WxAccessTokenResult accessTokenResult = WxAccessTokenResult.parseJson(json, WxAccessTokenResult.class);
        return accessTokenResult.getAccessToken();
    }

    /**
     * 获取全局唯一接口调用凭据
     *
     * @return 接口调用凭据
     * @throws JsonProcessingException json处理异常
     */
    private WxAccessTokenResult getAccessToken() throws JsonProcessingException {
        String url = String.format("/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s", appId, appSecret);
        WxAccessTokenResult accessTokenResult = this.get(url, WxAccessTokenResult.class);
        if (accessTokenResult.success()) {
            cacheToken(accessTokenResult);
        }
        return accessTokenResult;
    }


    /**
     * post请求
     *
     * @param uri        uri地址
     * @param object     json参数对象
     * @param resultType 返回类型
     * @return 返回结果
     */
    private <T extends WxResult> T request(String uri, Object object, Class<T> resultType) {
        try {
            String url = BASE_URL + uri;
            if (!isGetAccessTokenUrl(uri)) {
                String accessToken = getCacheToken();
                if (StringUtils.isEmpty(accessToken)) {
                    WxAccessTokenResult accessTokenResult = this.getAccessToken();
                    if (!accessTokenResult.success()) {
                        return errorResult(accessTokenResult.getErrorCode(), accessTokenResult.getErrorMessage(), resultType);
                    }
                }
                url += (url.contains("?") ? "&" : "?") + "access_token=" + getCacheToken();
            }
            String result = object == null ? HttpUtils.get(url) : HttpUtils.postJson(url, object);
            log.debug("uri: {}, object: {}, result: {}", url, object != null ? object.toString() : "null", result);
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            T wxResult = mapper.readValue(result, resultType);
            if (wxResult.getErrorCode() == ERROR_CODE_ACCESS_TOKEN_TIMEOUT) {
                WxAccessTokenResult accessTokenResult = this.getAccessToken();
                if (accessTokenResult.success()) {
                    return this.request(uri, object, resultType);
                }
            }
            return wxResult;
        } catch (IOException e) {
            return errorResult(-3, e.getMessage(), resultType);
        }
    }

    /**
     * 转为相应的错误结果
     *
     * @param errorCode    错误码
     * @param errorMessage 错误消息
     * @param resultType   结果类型
     * @param <T>          模板类型
     * @return 错误结果
     */
    private <T extends WxResult> T errorResult(Integer errorCode, String errorMessage, Class<T> resultType) {
        T result;
        try {
            result = resultType.newInstance();
            result.setErrorCode(errorCode);
            result.setErrorMessage(errorMessage);
            return result;
        } catch (Exception exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }

    /**
     * 是否为获取凭据uri
     *
     * @param uri uri
     * @return 是否获取凭据uri
     */
    private boolean isGetAccessTokenUrl(String uri) {
        return uri.startsWith("/cgi-bin/token?grant_type=client_credential&appid=");
    }
}
