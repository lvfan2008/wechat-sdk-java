package fan.lv.wechat.entity.official.base;

import fan.lv.wechat.entity.result.WxResult;
import fan.lv.wechat.util.JsonUtil;
import fan.lv.wechat.util.SimpleHttpResp;

import java.nio.charset.StandardCharsets;

/**
 * 支付结果类工具
 *
 * @author lv_fan2008
 */
public class WxResultUtil {

    /**
     * 转化xml到结果类
     *
     * @param resp       http应答
     * @param resultType 转化类型
     * @param <T>        模版变量
     * @return 结果类
     */
    public static <T extends WxResult> T convertResult(SimpleHttpResp resp, Class<T> resultType) {

        try {
            T result;
            if (resp.isJson()) {
                result = JsonUtil.parseJson(resp.content(), resultType);
            } else {
                result = resultType.getDeclaredConstructor().newInstance();
            }
            result.setHttpResp(resp);
            return result;
        } catch (Exception e) {
            return errorResult(e.getMessage(), resultType);
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
    public static <T extends WxResult> T errorResult(String errorMessage, Class<T> resultType) {
        T result;
        try {
            result = resultType.getDeclaredConstructor().newInstance();
            result.setErrorCode(-2);
            result.setErrorMessage(errorMessage);
            result.setHttpResp(new SimpleHttpResp(true, null, "UTF-8", JsonUtil.toJson(result).getBytes(StandardCharsets.UTF_8)));
            return result;
        } catch (Exception exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }

}
