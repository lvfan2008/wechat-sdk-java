package fan.lv.wechat.entity.pay.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import fan.lv.wechat.entity.result.WxResult;
import fan.lv.wechat.util.SimpleHttpResp;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lv_fan2008
 */
@Data
public class WxBasePayResult {

    /**
     * 支付Xml转为的map
     */
    @XStreamOmitField
    Map<String, String> mapResult = new HashMap<>();

    /**
     * 请求应答map的key对应值，结果中没有的属性，可以通过此接口查询到
     *
     * @param key 结果key值
     * @return 结果value值
     */
    public String get(String key) {
        return mapResult.get(key);
    }

    /**
     * 返回状态码	，SUCCESS/FAIL
     */
    @XStreamAlias("return_code")
    String returnCode = "SUCCESS";

    /**
     * 返回信息，如非空，为错误原因
     * 签名失败
     * 参数格式校验错误
     */
    @XStreamAlias("return_msg")
    String returnMsg = "OK";

    /**
     * 业务状态码	，SUCCESS/FAIL
     */
    @XStreamAlias("result_code")
    String resultCode;


    /**
     * 验证签名是否有效
     */
    @XStreamOmitField
    Boolean validSignature = true;

    /**
     * Http应答
     */
    @XStreamOmitField
    SimpleHttpResp httpResp;


    /**
     * 结果是否成功
     *
     * @return 是否成功
     */
    public Boolean success() {
        return "SUCCESS".equals(getReturnCode());
    }

    /**
     * 业务是否成功
     *
     * @return 是否成功
     */
    public Boolean resultSuccess() {
        return "SUCCESS".equals(getResultCode());
    }
}
