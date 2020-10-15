package fan.lv.wechat.entity.pay.enterprisepay;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import fan.lv.wechat.entity.pay.base.WxCommonPayResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 企业付款结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxEnterprisePayResult extends WxCommonPayResult {

    /**
     * 申请商户号的appid或商户号绑定的appid（企业号corpid即为此appId）
     */
    @XStreamAlias("mch_appid")
    String mchAppId;


    /**
     * 微信支付分配的商户号
     */
    @XStreamAlias("mchid")
    String mchId;


    /**
     * 微信支付分配的终端设备号
     */
    @XStreamAlias("device_info")
    String deviceInfo;

    /**
     * 商户订单号，需保持历史全局唯一性(只能是字母或者数字，不能包含有其它字符)
     */
    @XStreamAlias("partner_trade_no")
    String partnerTradeNo;


    /**
     * 企业付款成功，返回的微信付款单号
     */
    @XStreamAlias("payment_no")
    String paymentNo;


    /**
     * 企业付款成功时间
     */
    @XStreamAlias("payment_time")
    String paymentTime;
}
