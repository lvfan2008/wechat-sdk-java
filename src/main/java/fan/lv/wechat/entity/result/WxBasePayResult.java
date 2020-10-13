package fan.lv.wechat.entity.result;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxBasePayResult extends WxResult {

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
     * 错误码
     */
    @XStreamOmitField
    Integer errorCode = 0;

    /**
     * 错误消息
     */
    @XStreamOmitField
    String errorMessage = "";

    /**
     * 是否为原始流
     */
    @XStreamOmitField
    Boolean isRawStream = false;


    /**
     * 原始流的内容类型：Content-Type
     */
    @XStreamOmitField
    String contentType;

    /**
     * 原始流的文件名：Content-disposition:attachment; filename=xxxx.jpg
     */
    @XStreamOmitField
    String filename;

    /**
     * 原始流
     */
    @XStreamOmitField
    InputStream content;

    /**
     * 原始流长度
     */
    @XStreamOmitField
    Long length;

    /**
     * 结果是否成功
     *
     * @return 是否成功
     */
    @Override
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
