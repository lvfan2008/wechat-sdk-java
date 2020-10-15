package fan.lv.wechat.entity.pay.redpack;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import fan.lv.wechat.entity.pay.base.WxCommonPayResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 发放红包结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxSendRedPackResult extends WxCommonPayResult {

    /**
     * 商户订单号（每个订单号必须唯一） 组成：mch_id+yyyymmdd+10位一天内不能重复的数字
     */
    @XStreamAlias("mch_billno")
    String mchBillNo;


    /**
     * 微信支付分配的商户号
     */
    @XStreamAlias("mch_id")
    String mchId;


    /**
     * 商户appid，接口传入的所有appid应该为公众号的appid（在mp.weixin.qq.com申请的），不能为APP的appid（在open.weixin.qq.com申请的）。
     */
    @XStreamAlias("wxappid")
    String wxAppId;

    /**
     * 接受收红包的用户 用户在wxappid下的openid
     */
    @XStreamAlias("re_openid")
    String reOpenId;


    /**
     * 付款金额，单位分
     */
    @XStreamAlias("total_amount")
    Integer totalAmount;


    /**
     * 红包订单的微信单号
     */
    @XStreamAlias("send_listid")
    String sendListId;
}
