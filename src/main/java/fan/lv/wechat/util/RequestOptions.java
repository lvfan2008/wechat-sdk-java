package fan.lv.wechat.util;

import lombok.Builder;
import lombok.Data;
import org.apache.http.entity.ContentType;

import java.util.HashMap;
import java.util.Map;

/**
 * http请求选项
 *
 * @author lv_fan2008
 */
@Data
@Builder
public class RequestOptions {
    /**
     * 头信息
     */
    @Builder.Default
    Map<String, String> headers = new HashMap<>();

    /**
     * get参数信息
     */
    @Builder.Default
    Map<String, String> queryMap = new HashMap<>();

    /**
     * 表单信息
     */
    @Builder.Default
    Map<String, String> formData = new HashMap<>();

    /**
     * 上传文件列表
     */
    @Builder.Default
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
    @Builder.Default
    String mimeType = "application/json";

    /**
     * 字符集
     */
    @Builder.Default
    String charset = "UTF-8";
}
