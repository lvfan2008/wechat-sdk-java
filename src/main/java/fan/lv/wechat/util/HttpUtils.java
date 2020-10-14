package fan.lv.wechat.util;

import org.apache.commons.codec.CharEncoding;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.DefaultHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author lv_fan2008
 */
public class HttpUtils {
    /**
     * http请求类
     *
     * @param url url地址
     * @return HttpResponse
     * @throws Exception 例外
     */
    public static HttpResponse httpRequest(String url, RequestOptions httpOptions) throws Exception {
        CloseableHttpClient httpClient = getHttpClient(httpOptions.getSslCert());
        url = HttpUtils.buildUrlQuery(url, httpOptions.getQueryMap());
        HttpRequestBase httpUriRequest;
        MultipartEntityBuilder builder;
        if (httpOptions.uploadFiles.size() > 0 || httpOptions.body != null) {
            httpUriRequest = new HttpPost(url);
        } else {
            httpUriRequest = new HttpGet(url);
        }
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(httpOptions.getReadTimeoutMs())
                .setConnectTimeout(httpOptions.getConnectTimeoutMs()).build();
        httpUriRequest.setConfig(requestConfig);

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
            ((HttpPost) httpUriRequest).setEntity(new StringEntity(httpOptions.getBody(),
                    ContentType.create(httpOptions.getMimeType(), httpOptions.getCharset())));
        }
        return httpClient.execute(httpUriRequest);
    }

    /**
     * 得到httpClient
     *
     * @param sslCert 证书
     * @return httpClient
     * @throws Exception 异常
     */
    private static CloseableHttpClient getHttpClient(SslCert sslCert) throws Exception {
        BasicHttpClientConnectionManager connManager;
        if (sslCert != null) {
            // 证书
            char[] password = sslCert.getPassword().toCharArray();
            KeyStore ks = KeyStore.getInstance("PKCS12");
            ks.load(new ByteArrayInputStream(sslCert.getCertBytes()), password);

            // 实例化密钥库 & 初始化密钥工厂
            KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            kmf.init(ks, password);

            // 创建 SSLContext
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(kmf.getKeyManagers(), null, new SecureRandom());

            SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(
                    sslContext, new String[]{"TLSv1"}, null, new DefaultHostnameVerifier());

            connManager = new BasicHttpClientConnectionManager(
                    RegistryBuilder.<ConnectionSocketFactory>create()
                            .register("http", PlainConnectionSocketFactory.getSocketFactory())
                            .register("https", sslConnectionSocketFactory)
                            .build(), null, null, null
            );
        } else {
            connManager = new BasicHttpClientConnectionManager(
                    RegistryBuilder.<ConnectionSocketFactory>create()
                            .register("http", PlainConnectionSocketFactory.getSocketFactory())
                            .register("https", SSLConnectionSocketFactory.getSocketFactory())
                            .build(), null, null, null
            );
        }

        return HttpClientBuilder.create().setConnectionManager(connManager).build();
    }


    /**
     * 创建Url编码参数,包含Url
     *
     * @param url    url地址
     * @param params 参数对
     * @return url
     */
    public static String buildUrlQuery(String url, Map<String, String> params) {
        String query = buildQuery(params);
        return query.isEmpty() ? url : (url + (url.contains("?") ? "&" : "?") + query);
    }

    /**
     * 创建Url编码参数
     *
     * @param params 参数对
     * @return url参数串
     */
    public static String buildQuery(Map<String, String> params) {
        if (params == null || params.size() == 0) {
            return "";
        }
        List<String> elements = new ArrayList<>();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (StringUtils.isEmpty(entry.getValue())) {
                continue;
            }
            try {
                elements.add(String.format("%s=%s", entry.getKey(), URLEncoder.encode(entry.getValue(), CharEncoding.UTF_8)));
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }
        return StringUtils.joinWith("&", elements.toArray());
    }
}
