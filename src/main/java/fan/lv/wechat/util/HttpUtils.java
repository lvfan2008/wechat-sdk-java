package fan.lv.wechat.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.CharEncoding;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import static org.apache.http.entity.ContentType.APPLICATION_JSON;

/**
 * @author lixinguo
 */
public class HttpUtils {

    /**
     * get请求
     *
     * @param url url地址
     * @return 返回内容
     * @throws IOException 异常
     */
    public static String get(String url) throws IOException {
        return httpRequest(url, HttpGet.METHOD_NAME, null, null, null);
    }

    /**
     * 提交Json
     *
     * @param url    url地址
     * @param object json对象
     * @return 返回内容
     * @throws IOException 异常
     */
    public static String postJson(String url, Object object) throws IOException {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json; encoding=utf-8");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(object);
        return httpRequest(url, HttpPost.METHOD_NAME, json, ContentType.APPLICATION_JSON, headers);
    }


    /**
     * http请求类
     *
     * @param url     url地址
     * @param method  方法，支持POST和GET
     * @param body    post请求body实体
     * @param headers 方法头
     * @return HttpResponse
     * @throws IOException 例外
     */
    public static String httpRequest(String url, String method, String body, ContentType contentType, Map<String, String> headers) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpUriRequest httpUriRequest = (method.equals(HttpGet.METHOD_NAME)) ? new HttpGet(url) : new HttpPost(url);
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                httpUriRequest.addHeader(entry.getKey(), entry.getValue());
            }
        }
        if (method.equals(HttpPost.METHOD_NAME) && !body.isEmpty()) {
            ((HttpPost) httpUriRequest).setEntity(new StringEntity(body, contentType));
        }
        HttpResponse httpResponse = httpClient.execute(httpUriRequest);
        return EntityUtils.toString(httpResponse.getEntity());
    }

    /**
     * 创建Url编码参数,包含Url
     *
     * @param url    url地址
     * @param params 参数对
     * @return url
     * @throws UnsupportedEncodingException 编码异常
     */
    public static String buildUrlQuery(String url, Map<String, String> params) throws UnsupportedEncodingException {
        String query = buildQuery(params);
        return query.isEmpty() ? url : (url + (url.contains("?") ? "&" : "?") + query);
    }

    /**
     * 创建Url编码参数
     *
     * @param params 参数对
     * @return url参数串
     * @throws UnsupportedEncodingException 编码异常
     */
    public static String buildQuery(Map<String, String> params) throws UnsupportedEncodingException {
        if (params == null || params.size() == 0) {
            return "";
        }
        StringBuilder buffer = new StringBuilder();
        int i = 0;
        for (Map.Entry<String, String> entry : params.entrySet()) {
            buffer.append(String.format("%s=%s", entry.getKey(), URLEncoder.encode(entry.getValue(), CharEncoding.UTF_8)));
            if (i != params.size() - 1) {
                buffer.append("&");
            }
        }
        return buffer.toString();
    }
}
