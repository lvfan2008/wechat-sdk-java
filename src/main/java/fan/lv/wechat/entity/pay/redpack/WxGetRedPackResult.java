package fan.lv.wechat.entity.pay.redpack;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import fan.lv.wechat.entity.pay.base.WxCommonPayResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 查询红包记录结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxGetRedPackResult extends WxCommonPayResult {

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
     * 红包单号	，使用API发放现金红包时返回的红包单号
     */
    @XStreamAlias("detail_id")
    String detailId;

    /**
     * 红包状态
     * SENDING:发放中
     * SENT:已发放待领取
     * FAILED：发放失败
     * RECEIVED:已领取
     * RFUND_ING:退款中
     * REFUND:已退款
     */
    @XStreamAlias("status")
    String status;


    /**
     * 发放类型
     * API:通过API接口发放
     * UPLOAD:通过上传文件方式发放
     * ACTIVITY:通过活动方式发放
     */
    @XStreamAlias("send_type")
    Integer sendType;


    /**
     * 红包类型
     * GROUP:裂变红包
     * NORMAL:普通红包
     */
    @XStreamAlias("hb_type")
    String hbType;

    /**
     * 红包个数
     */
    @XStreamAlias("total_num")
    Integer totalNum;

    /**
     * 红包总金额（单位分）
     */
    @XStreamAlias("total_amount")
    Integer totalAmount;


    /**
     * 发送失败原因
     */
    @XStreamAlias("reason")
    String reason;

    /**
     * 红包发送时间
     */
    @XStreamAlias("send_time")
    String sendTime;

    /**
     * 红包的退款时间（如果其未领取的退款）
     */
    @XStreamAlias("refund_time")
    String refundTime;

    /**
     * 红包退款金额
     */
    @XStreamAlias("refund_amount")
    Integer refundAmount;

    /**
     * 祝福语
     */
    @XStreamAlias("wishing")
    String wishing;

    /**
     * 活动描述
     */
    @XStreamAlias("remark")
    String remark;

    /**
     * 活动名称
     */
    @XStreamAlias("act_name")
    String actName;
    /**
     * 裂变红包领取列表
     */
    @XStreamAlias("hblist")
    String hbList;

    /**
     * 领取红包的Openid
     */
    @XStreamAlias("openid")
    String openId;

    /**
     * 领取金额
     */
    @XStreamAlias("amount")
    Integer amount;

    /**
     * 接收时间
     */
    @XStreamAlias("rcv_time")
    String rcvTime;

}
