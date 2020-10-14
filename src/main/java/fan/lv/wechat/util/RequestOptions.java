package fan.lv.wechat.util;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.apache.http.entity.ContentType;

import java.util.HashMap;
import java.util.Map;

/**
 * http请求选项
 *
 * @author lv_fan2008
 */
@Data
public class RequestOptions {
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
     * 证书
     */
    SslCert sslCert;

    /**
     * body内容类型
     */
    String mimeType = "application/json";

    /**
     * 字符集
     */
    String charset = "UTF-8";

    /**
     * 连接超时时间，单位毫秒
     */
    Integer connectTimeoutMs;

    /**
     * 读数据超时时间，单位毫秒
     */
    Integer readTimeoutMs;

    public RequestOptions headers(Map<String, String> headers) {
        this.headers = headers;
        return this;
    }

    public RequestOptions queryMap(Map<String, String> queryMap) {
        this.queryMap = queryMap;
        return this;
    }

    public RequestOptions formData(Map<String, String> formData) {
        this.formData = formData;
        return this;
    }

    public RequestOptions uploadFiles(Map<String, String> uploadFiles) {
        this.uploadFiles = uploadFiles;
        return this;
    }

    public RequestOptions body(String body) {
        this.body = body;
        return this;
    }

    public RequestOptions sslCert(SslCert sslCert) {
        this.sslCert = sslCert;
        return this;
    }

    public RequestOptions mimeType(String mimeType) {
        this.mimeType = mimeType;
        return this;
    }

    public RequestOptions charset(String charset) {
        this.charset = charset;
        return this;
    }

    public RequestOptions connectTimeoutMs(Integer connectTimeoutMs) {
        this.connectTimeoutMs = connectTimeoutMs;
        return this;
    }

    public RequestOptions readTimeoutMs(Integer readTimeoutMs) {
        this.readTimeoutMs = readTimeoutMs;
        return this;
    }

    public static RequestOptions defOpts(RequestOptions defOpts) {
        return defOpts == null ? new RequestOptions() : defOpts;
    }
}
