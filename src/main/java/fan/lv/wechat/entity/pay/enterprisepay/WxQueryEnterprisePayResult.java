package fan.lv.wechat.entity.pay.enterprisepay;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import fan.lv.wechat.entity.pay.base.WxCommonPayResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 查询企业付款结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxQueryEnterprisePayResult extends WxCommonPayResult {

    /**
     * 商户使用查询API填写的单号的原路返回.
     */
    @XStreamAlias("partner_trade_no")
    String partnerTradeNo;

    /**
     * 商户号的appid
     */
    @XStreamAlias("appid")
    String appId;


    /**
     * 微信支付分配的商户号
     */
    @XStreamAlias("mch_id")
    String mchId;


    /**
     * 调用企业付款API时，微信系统内部产生的单号
     */
    @XStreamAlias("detail_id")
    String detailId;




    /**
     * 转账状态	 SUCCESS:转账成功 FAILED:转账失败 PROCESSING:处理中
     */
    @XStreamAlias("status")
    String status;


    /**
     * 失败原因
     */
    @XStreamAlias("reason")
    String reason;

    /**
     * 收款用户openid
     */
    @XStreamAlias("openid")
    String openId;

    /**
     * 收款用户姓名
     */
    @XStreamAlias("transfer_name")
    String transferName;

    /**
     * 付款金额单位为“分”
     */
    @XStreamAlias("payment_amount")
    Integer paymentAmount;

    /**
     * 发起转账的时间
     */
    @XStreamAlias("transfer_time")
    String transferTime;

    /**
     * 企业付款成功时间
     */
    @XStreamAlias("payment_time")
    String paymentTime;


    /**
     * 企业付款备注
     */
    @XStreamAlias("desc")
    String desc;
}
