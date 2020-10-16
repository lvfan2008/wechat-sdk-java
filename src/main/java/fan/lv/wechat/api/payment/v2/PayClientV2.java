package fan.lv.wechat.api.payment.v2;

import fan.lv.wechat.entity.pay.base.WxBasePayResult;
import fan.lv.wechat.util.RequestOptions;

import java.util.Map;

/**
 * @author lv_fan2008
 */
public interface PayClientV2 {

    /**
     * Post Xml请求
     *
     * @param uri        uri地址
     * @param reqData    请求Map
     * @param resultType 返回类型
     * @param defOpts    默认选项
     * @param <T>        模板变量
     * @return 返回结果
     */
    <T extends WxBasePayResult> T postXml(String uri, Map<String, String> reqData, Class<T> resultType, RequestOptions defOpts);

}
