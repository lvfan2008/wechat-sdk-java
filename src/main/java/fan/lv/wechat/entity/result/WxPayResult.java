package fan.lv.wechat.entity.result;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * @author lv_fan2008
 */
@Data
public class WxPayResult {
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
    String resultCode = "SUCCESS";
}
