package fan.lv.wechat.api.kernel;

import fan.lv.wechat.entity.result.WxResult;
import fan.lv.wechat.util.RequestOptions;

import java.util.Map;

/**
 * APi请求客户端
 *
 * @author lv_fan2008
 */
public interface Client {

    /**
     * Get请求
     *
     * @param uri        uri地址，不包含主域名部分
     * @param resultType 返回类型
     * @param <T>        模板变量
     * @return 返回结果
     */
    <T extends WxResult> T get(String uri, Class<T> resultType);

    /**
     * Post Json请求
     *
     * @param uri        uri地址
     * @param object     json参数对象
     * @param resultType 返回类型
     * @param <T>        模板变量
     * @return 返回结果
     */
    <T extends WxResult> T postJson(String uri, Object object, Class<T> resultType);

    /**
     * Post表单
     *
     * @param uri        uri地址
     * @param formData   提交表单
     * @param resultType 返回类型
     * @param <T>        模板变量
     * @return 返回结果
     */
    <T extends WxResult> T postForm(String uri, Map<String, String> formData, Class<T> resultType);

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
    <T extends WxResult> T uploadFile(String uri, Map<String, String> formData,
                                      Map<String, String> filePathMap, Class<T> resultType);


    /**
     * Get请求
     *
     * @param uri        uri地址，不包含主域名部分
     * @param queryMap   get参数
     * @param resultType 返回类型
     * @param <T>        模板变量
     * @return 返回结果
     */
    <T extends WxResult> T get(String uri, Map<String, String> queryMap, Class<T> resultType);

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
    <T extends WxResult> T postJson(String uri, Map<String, String> queryMap, Object object, Class<T> resultType);

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
    <T extends WxResult> T postForm(String uri, Map<String, String> queryMap, Map<String, String> formData, Class<T> resultType);

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
    <T extends WxResult> T uploadFile(String uri, Map<String, String> queryMap, Map<String, String> formData,
                                      Map<String, String> filePathMap, Class<T> resultType);

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


    /**
     * 获取凭证Token
     *
     * @return 凭证结果，必须为WxResult子类的实例
     */
    default WxResult getAccessToken() {
        return getAccessToken(true);
    }

    /**
     * 获取凭证Token,如果缓存过期或者不从缓存取，需要缓存已得到的Token
     *
     * @param tryCache 是否尝试从cache里获取凭证
     * @return 凭证结果，必须为WxResult子类的实例
     */
    WxResult getAccessToken(boolean tryCache);
}
