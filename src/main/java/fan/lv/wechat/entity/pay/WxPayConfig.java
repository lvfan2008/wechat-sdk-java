package fan.lv.wechat.entity.pay;

import lombok.Builder;
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
     * 证书内容，使用子商户时，填写服务商证书内容
     */
    byte[] certBytes;

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

    /**
     * 签名方式，支持 MD5 和 HMAC-SHA256两种签名
     */
    String signType = "MD5";


    /**
     * 连接超时时间，单位毫秒
     */
    Integer connectTimeoutMs = 6 * 1000;

    /**
     * 读数据超时时间，单位毫秒
     */
    Integer readTimeoutMs = 8 * 1000;
}
