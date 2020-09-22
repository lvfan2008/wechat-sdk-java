package fan.lv.wechat.util;

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
     * body内容类型
     */
    ContentType contentType;

    public RequestOptions() {
    }

    public RequestOptions(Map<String, String> queryMap) {
        this.queryMap = queryMap;
    }

    public RequestOptions(Map<String, String> queryMap, String body, ContentType contentType) {
        this.queryMap = queryMap;
        this.body = body;
        this.contentType = contentType;
    }

    public RequestOptions(String body, ContentType contentType) {
        this.body = body;
        this.contentType = contentType;
    }


    public RequestOptions(Map<String, String> queryMap, Map<String, String> formData, Map<String, String> uploadFiles) {
        this.queryMap = queryMap;
        this.formData = formData;
        this.uploadFiles = uploadFiles;
    }

    public RequestOptions(Map<String, String> formData, Map<String, String> uploadFiles) {
        this.formData = formData;
        this.uploadFiles = uploadFiles;
    }
}
