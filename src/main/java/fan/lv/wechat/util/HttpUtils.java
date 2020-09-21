package fan.lv.wechat.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.apache.commons.codec.CharEncoding;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lv_fan2008
 */
public class HttpUtils {
    /**
     * http请求类
     *
     * @param url url地址
     * @return String
     * @throws IOException 例外
     */
    public static String httpRequest(String url, HttpOptions httpOptions) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        url = HttpUtils.buildUrlQuery(url, httpOptions.getQueryMap());
        HttpUriRequest httpUriRequest;
        MultipartEntityBuilder builder;
        if (httpOptions.uploadFiles.size() > 0 || httpOptions.body != null) {
            httpUriRequest = new HttpPost(url);
        } else {
            httpUriRequest = new HttpGet(url);
        }

        for (Map.Entry<String, String> entry : httpOptions.headers.entrySet()) {
            httpUriRequest.addHeader(entry.getKey(), entry.getValue());
        }
        if (httpOptions.formData.size() > 0 || httpOptions.uploadFiles.size() > 0) {
            builder = MultipartEntityBuilder.create();
            builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
            for (Map.Entry<String, String> entry : httpOptions.uploadFiles.entrySet()) {
                FileBody fileBody = new FileBody(new File(entry.getValue()), ContentType.DEFAULT_BINARY);
                builder.addPart(entry.getKey(), fileBody);
            }
            for (Map.Entry<String, String> entry : httpOptions.formData.entrySet()) {
                builder.addPart(entry.getKey(), new StringBody(entry.getValue(), ContentType.MULTIPART_FORM_DATA));
            }
            assert httpUriRequest instanceof HttpPost;
            ((HttpPost) httpUriRequest).setEntity(builder.build());
        } else if (httpOptions.body != null) {
            assert httpUriRequest instanceof HttpPost;
            ((HttpPost) httpUriRequest).setEntity(new StringEntity(httpOptions.body, httpOptions.contentType));
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

    /**
     * http选项
     */
    @Data
    public static class HttpOptions {
        /**
         * 头信息
         */
        Map<String, String> headers = new HashMap<>();

        /**
         * get参数信息
         */
        Map<String, String> queryMap = new HashMap<>();

        /**
         * 表单信息
         */
        Map<String, String> formData = new HashMap<>();

        /**
         * 上传文件列表
         */
        Map<String, String> uploadFiles = new HashMap<>();

        /**
         * body填充
         */
        String body;

        /**
         * body内容类型
         */
        ContentType contentType;

        public HttpOptions() {
        }

        public HttpOptions(Map<String, String> queryMap) {
            this.queryMap = queryMap;
        }

        public HttpOptions(Map<String, String> queryMap, String body, ContentType contentType) {
            this.queryMap = queryMap;
            this.body = body;
            this.contentType = contentType;
        }

        public HttpOptions(String body, ContentType contentType) {
            this.body = body;
            this.contentType = contentType;
        }



        public HttpOptions(Map<String, String> queryMap, Map<String, String> formData, Map<String, String> uploadFiles) {
            this.queryMap = queryMap;
            this.formData = formData;
            this.uploadFiles = uploadFiles;
        }

        public HttpOptions(Map<String, String> formData, Map<String, String> uploadFiles) {
            this.formData = formData;
            this.uploadFiles = uploadFiles;
        }
    }
}
