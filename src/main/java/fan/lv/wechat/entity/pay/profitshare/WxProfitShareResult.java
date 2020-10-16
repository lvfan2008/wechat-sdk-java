package fan.lv.wechat.entity.pay.profitshare;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import fan.lv.wechat.entity.pay.base.WxCommonPayResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 单次分账结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxProfitShareResult extends WxCommonPayResult {

    /**
     * 微信支付订单号
     */
    @XStreamAlias("transaction_id")
    String transactionId;


    /**
     * 调用接口提供的商户系统内部的分账单号
     */
    @XStreamAlias("out_order_no")
    String outOrderNo;


    /**
     * 微信分账单号，微信系统返回的唯一标识
     */
    @XStreamAlias("order_id")
    String orderId;
}
