package fan.lv.wechat.entity.pay.payment;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import fan.lv.wechat.entity.pay.base.WxCommonPayResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 统一下单结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxUnifiedOrderResult extends WxCommonPayResult {

    /**
     * 调用接口提交的终端设备号
     */
    @XStreamAlias("device_info")
    String deviceInfo;


    /**
     * JSAPI--JSAPI支付（或小程序支付）、NATIVE--Native支付、APP--app支付，MWEB--H5支付，不同trade_type决定了调起支付的方式
     */
    @XStreamAlias("trade_type")
    String tradeType;


    /**
     * 微信生成的预支付回话标识，用于后续接口调用中使用，该值有效期为2小时
     */
    @XStreamAlias("prepay_id")
    String prepayId;


    /**
     * trade_type=NATIVE时有返回，此url用于生成支付二维码，然后提供给用户进行扫码支付。
     */
    @XStreamAlias("code_url")
    String codeUrl;
}
