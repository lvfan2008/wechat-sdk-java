package fan.lv.wechat.api.official.kernel;

import fan.lv.wechat.entity.result.WxResult;

/**
 * api请求接口
 *
 * @author lixinguo
 */
public interface Client {

    /**
     * Get请求
     *
     * @param uri        uri地址，不包含主域名部分
     * @param resultType 返回类型
     * @return 返回结果
     */
    public <T extends WxResult> T get(String uri, Class<T> resultType);

    /**
     * Post请求
     *
     * @param uri        uri地址
     * @param object     json参数对象
     * @param resultType 返回类型
     * @return 返回结果
     */
    public <T extends WxResult> T post(String uri, Object object, Class<T> resultType);
}
