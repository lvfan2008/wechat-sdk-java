package fan.lv.wechat.entity.pay;

import lombok.Data;

import java.io.InputStream;

/**
 * @author lv_fan2008
 */
@Data
public class WxPayConfig {

    /**
     * 商户appId，使用子商户时，填写服务商AppId
     */
    String appId;

    /**
     * 商户号，使用子商户时，此处填写服务商商户号
     */
    String getMchId;

    /**
     * 商户密钥，使用子商户时，填写服务商商户密钥
     */
    String key;

    /**
     * 证书流，使用子商户时，填写服务商证书流
     */
    InputStream certStream;

    /**
     * 子商户appId，非子商户无需必填
     */
    String subAppId;

    /**
     * 子商户号，非子商户无需必填
     */
    String subMchId;

    /**
     * 支付后通知Url
     */
    String notifyUrl;
}
