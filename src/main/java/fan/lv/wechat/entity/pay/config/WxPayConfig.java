package fan.lv.wechat.entity.pay.config;

import lombok.Builder;
import lombok.Data;

/**
 * @author lv_fan2008
 */
@Data
@Builder
public class WxPayConfig {

    /**
     * 商户appId，使用子商户时，填写服务商AppId
     */
    String appId;

    /**
     * 商户号，使用子商户时，此处填写服务商商户号
     */
    String mchId;

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
    @Builder.Default
    String signType = "MD5";


    /**
     * 连接超时时间，单位毫秒
     */
    @Builder.Default
    Integer connectTimeoutMs = 6 * 1000;

    /**
     * 读数据超时时间，单位毫秒
     */
    @Builder.Default
    Integer readTimeoutMs = 8 * 1000;

    /**
     * 是否为沙盒环境
     * 沙箱支持的API
     * <p>
     * <p>
     * 沙箱支持如下api，具体需按验收用例规范来调式，其他接口不支持在沙箱测试
     * <p>
     * 〖付款码下单：https://api.mch.weixin.qq.com/sandboxnew/pay/micropay 〗
     * <p>
     * 〖公众号/扫码/APP支付下单：https://api.mch.weixin.qq.com/sandboxnew/pay/unifiedorder〗
     * <p>
     * 〖订单查询：https://api.mch.weixin.qq.com/sandboxnew/pay/orderquery〗
     * <p>
     * 〖退款：https://api.mch.weixin.qq.com/sandboxnew/pay/refund〗
     * <p>
     * 〖退款查询：https://api.mch.weixin.qq.com/sandboxnew/pay/refundquery〗
     * <p>
     * 〖下载对账单：https://api.mch.weixin.qq.com/sandboxnew/pay/downloadbill〗
     * <p>
     * 〖撤单：https://api.mch.weixin.qq.com/sandboxnew/pay/reverse〗
     * <p>
     * 〖关闭订单：https://api.mch.weixin.qq.com/sandboxnew/pay/closeorder〗
     *
     * @see <a href="https://mp.weixin.qq.com/s/Ze-bN91oOT1gEoozLwyHdQ" target="_blank">参考沙盒常见问题</a>
     */
    @Builder.Default
    Boolean sandbox = false;

    /**
     * 沙盒密钥
     */
    String sandboxSignKey;
}
