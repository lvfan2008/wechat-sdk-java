package fan.lv.wechat.entity.pay.profitshare;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import fan.lv.wechat.entity.pay.base.WxCommonPayResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 分账回退结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxReturnProfitShareResult extends WxCommonPayResult {

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


    /**
     * 商户回退单号
     */
    @XStreamAlias("out_return_no")
    String outReturnNo;


    /**
     * 微信回退单号
     */
    @XStreamAlias("return_no")
    String returnNo;

    /**
     * 回退方类型
     */
    @XStreamAlias("return_account_type")
    String returnAccountType;

    /**
     * 回退方账号
     */
    @XStreamAlias("return_account")
    String returnAccount;

    /**
     * 回退金额
     */
    @XStreamAlias("return_amount")
    Integer returnAmount;

    /**
     * 回退描述
     */
    @XStreamAlias("description")
    String description;

    /**
     * 回退结果
     */
    @XStreamAlias("result")
    String result;

    /**
     * 失败原因
     */
    @XStreamAlias("fail_reason")
    String failReason;

    /**
     * 完成时间
     */
    @XStreamAlias("finish_time")
    String finishTime;
}
