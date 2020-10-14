package fan.lv.wechat.api.kernel;

import fan.lv.wechat.entity.result.WxResult;
import fan.lv.wechat.util.*;

import java.util.Map;

/**
 * APi请求客户端
 *
 * @author lv_fan2008
 */
public interface Client {
    /**
     * 得到基准Url
     *
     * @return 基准url
     */
    String getBaseUrl();


    /**
     * Get请求
     *
     * @param uri        uri地址，不包含主域名部分
     * @param resultType 返回类型
     * @param <T>        模板变量
     * @return 返回结果
     */
    default <T extends WxResult> T get(String uri, Class<T> resultType) {
        return get(uri, SimpleMap.of(), resultType);
    }

    /**
     * Post Json请求
     *
     * @param uri        uri地址
     * @param object     json参数对象
     * @param resultType 返回类型
     * @param <T>        模板变量
     * @return 返回结果
     */
    default <T extends WxResult> T postJson(String uri, Object object, Class<T> resultType) {
        return postJson(uri, SimpleMap.of(), object, resultType);
    }

    /**
     * Post表单
     *
     * @param uri        uri地址
     * @param formData   提交表单
     * @param resultType 返回类型
     * @param <T>        模板变量
     * @return 返回结果
     */
    default <T extends WxResult> T postForm(String uri, Map<String, String> formData, Class<T> resultType) {
        return postForm(uri, SimpleMap.of(), formData, resultType);
    }

    /**
     * 上传文件
     *
     * @param uri         uri地址
     * @param formData    form表单
     * @param filePathMap 上传文件map，key为上传名，value为上传文件路径
     * @param resultType  返回类型
     * @param <T>         模板类型
     * @return 返回结果
     */
    default <T extends WxResult> T uploadFile(String uri, Map<String, String> formData,
                                              Map<String, String> filePathMap, Class<T> resultType) {
        return uploadFile(uri, SimpleMap.of(), formData, filePathMap, resultType);
    }


    /**
     * Get请求
     *
     * @param uri        uri地址，不包含主域名部分
     * @param queryMap   get参数
     * @param resultType 返回类型
     * @param <T>        模板变量
     * @return 返回结果
     */
    default <T extends WxResult> T get(String uri, Map<String, String> queryMap, Class<T> resultType) {
        return get(uri, queryMap, resultType, null);
    }

    /**
     * Post请求
     *
     * @param uri        uri地址
     * @param queryMap   get参数
     * @param object     json参数对象
     * @param resultType 返回类型
     * @param <T>        模板变量
     * @return 返回结果
     */
    default <T extends WxResult> T postJson(String uri, Map<String, String> queryMap, Object object, Class<T> resultType) {
        return postJson(uri, queryMap, object, resultType, null);
    }

    /**
     * Post Xml请求
     *
     * @param uri        uri地址
     * @param queryMap   get参数
     * @param object     json参数对象
     * @param resultType 返回类型
     * @param <T>        模板变量
     * @return 返回结果
     */
    default <T extends WxResult> T postXml(String uri, Map<String, String> queryMap, Object object, Class<T> resultType) {
        return postXml(uri, queryMap, object, resultType, null);
    }

    /**
     * Post表单
     *
     * @param uri        uri地址
     * @param queryMap   get参数
     * @param formData   form表单
     * @param resultType 返回类型
     * @param <T>        模板变量
     * @return 返回结果
     */
    default <T extends WxResult> T postForm(String uri, Map<String, String> queryMap, Map<String, String> formData, Class<T> resultType) {
        return postForm(uri, queryMap, formData, resultType, null);
    }

    /**
     * 上传文件
     *
     * @param uri         uri地址
     * @param queryMap    get参数
     * @param formData    form表单
     * @param filePathMap 上传文件map，key为上传名，value为上传文件路径
     * @param resultType  返回类型
     * @param <T>         模板类型
     * @return 返回结果
     */
    default <T extends WxResult> T uploadFile(String uri, Map<String, String> queryMap, Map<String, String> formData,
                                              Map<String, String> filePathMap, Class<T> resultType) {
        return uploadFile(uri, queryMap, formData, filePathMap, resultType, null);
    }

    /**
     * Get请求
     *
     * @param uri        uri地址，不包含主域名部分
     * @param queryMap   get参数
     * @param resultType 返回类型
     * @param defOpts    默认选项
     * @param <T>        模板变量
     * @return 返回结果
     */
    default <T extends WxResult> T get(String uri, Map<String, String> queryMap, Class<T> resultType, RequestOptions defOpts) {
        return request(uri, RequestOptions.defOpts(defOpts).queryMap(queryMap), resultType);
    }

    /**
     * Post请求
     *
     * @param uri        uri地址
     * @param queryMap   get参数
     * @param object     json参数对象
     * @param resultType 返回类型
     * @param defOpts    默认选项
     * @param <T>        模板变量
     * @return 返回结果
     */
    default <T extends WxResult> T postJson(String uri, Map<String, String> queryMap, Object object,
                                            Class<T> resultType, RequestOptions defOpts) {
        return request(uri, RequestOptions.defOpts(defOpts).queryMap(queryMap).body(JsonUtil.toJson(object)), resultType);
    }

    /**
     * Post Xml请求
     *
     * @param uri        uri地址
     * @param queryMap   get参数
     * @param object     json参数对象
     * @param resultType 返回类型
     * @param defOpts    默认选项
     * @param <T>        模板变量
     * @return 返回结果
     */
    default <T extends WxResult> T postXml(String uri, Map<String, String> queryMap, Object object,
                                           Class<T> resultType, RequestOptions defOpts) {
        return request(uri, RequestOptions.defOpts(defOpts).queryMap(queryMap).body(XmlUtil.toXml(object))
                .mimeType("application/xml"), resultType);
    }

    /**
     * Post表单
     *
     * @param uri        uri地址
     * @param queryMap   get参数
     * @param formData   form表单
     * @param resultType 返回类型
     * @param defOpts    默认选项
     * @param <T>        模板变量
     * @return 返回结果
     */
    default <T extends WxResult> T postForm(String uri, Map<String, String> queryMap, Map<String, String> formData,
                                            Class<T> resultType, RequestOptions defOpts) {
        return request(uri, RequestOptions.defOpts(defOpts).queryMap(queryMap).formData(formData), resultType);
    }

    /**
     * 上传文件
     *
     * @param uri         uri地址
     * @param queryMap    get参数
     * @param formData    form表单
     * @param filePathMap 上传文件map，key为上传名，value为上传文件路径
     * @param resultType  返回类型
     * @param defOpts     默认选项
     * @param <T>         模板类型
     * @return 返回结果
     */
    default <T extends WxResult> T uploadFile(String uri, Map<String, String> queryMap, Map<String, String> formData,
                                              Map<String, String> filePathMap, Class<T> resultType, RequestOptions defOpts) {
        return request(uri, RequestOptions.defOpts(defOpts).queryMap(queryMap).uploadFiles(filePathMap).formData(formData),
                resultType);
    }

    /**
     * Http请求
     *
     * @param uri         uri地址
     * @param httpOptions http选项
     * @param resultType  返回类型
     * @param <T>         模板类型
     * @return 返回结果
     */
    <T extends WxResult> T request(String uri, RequestOptions httpOptions, Class<T> resultType);

}
