package fan.lv.wechat.entity.pay.base;

import fan.lv.wechat.util.SimpleHttpResp;
import fan.lv.wechat.util.XmlUtil;

import java.nio.charset.StandardCharsets;

/**
 * 支付结果类工具
 *
 * @author lv_fan2008
 */
public class WxPayResultUtil {

    /**
     * 转化xml到结果类
     *
     * @param xml        xml字符串
     * @param resultType 转化类型
     * @param <T>        模版变量
     * @return 结果类
     */
    public static <T extends WxBasePayResult> T convertResult(String xml, Class<T> resultType) {

        try {
            T payResult = XmlUtil.parseXml(xml, resultType);
            payResult.setMapResult(XmlUtil.xmlToMap(xml));
            payResult.setHttpResp(new SimpleHttpResp(true, null, "UTF-8", xml.getBytes(StandardCharsets.UTF_8)));
            return payResult;
        } catch (Exception e) {
            return errorResult(e.getMessage(), resultType);
        }
    }

    /**
     * 转化http应答到结果类
     *
     * @param simpleHttpResp 应答
     * @param resultType     结果类型
     * @param <T>            模版变量
     * @return 转化结果
     * @throws Exception 异常
     */
    public static <T extends WxBasePayResult> T convertResult(SimpleHttpResp simpleHttpResp, Class<T> resultType) throws Exception {
        if (simpleHttpResp.isXml()) {
            T payResult = XmlUtil.parseXml(simpleHttpResp.content(), resultType);
            payResult.setMapResult(XmlUtil.xmlToMap(simpleHttpResp.content()));
            payResult.setHttpResp(simpleHttpResp);
            return payResult;
        } else {
            T payResult = resultType.getDeclaredConstructor().newInstance();
            payResult.setHttpResp(simpleHttpResp);
            return payResult;
        }
    }


    /**
     * 生成错误结果
     *
     * @param errorMessage 错误信息
     * @param resultType   转化类型
     * @param <T>          模版变量
     * @return 错误结果
     */
    public static <T extends WxBasePayResult> T errorResult(String errorMessage, Class<T> resultType) {
        T result;
        try {
            result = resultType.getDeclaredConstructor().newInstance();
            result.setReturnCode("FAIL");
            result.setReturnMsg(errorMessage);
            String xml = XmlUtil.toXml(result);
            result.setHttpResp(new SimpleHttpResp(true, null, "UTF-8", xml.getBytes(StandardCharsets.UTF_8)));
            return result;
        } catch (Exception exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }

}
