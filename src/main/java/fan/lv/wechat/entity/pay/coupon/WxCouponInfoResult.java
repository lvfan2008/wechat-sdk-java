package fan.lv.wechat.entity.pay.coupon;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import fan.lv.wechat.entity.pay.base.WxCommonPayResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 代金券信息结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxCouponInfoResult extends WxCommonPayResult {

    /**
     * 微信支付分配的终端设备号，
     */
    @XStreamAlias("device_info")
    String deviceInfo;

    /**
     * 代金券批次id，创建代金券时生成的批次号，可在商户平台-代金券管理页面查看
     */
    @XStreamAlias("coupon_stock_id")
    String couponStockId;


    /**
     * 代金券id
     */
    @XStreamAlias("coupon_id")
    String couponId;


    /**
     * 代金券面值,单位是分
     */
    @XStreamAlias("coupon_value")
    Integer couponValue;

    /**
     * 代金券使用最低限额,单位是分
     */
    @XStreamAlias("coupon_mininumn")
    Integer couponMiniNum;

    /**
     * 代金券名称
     */
    @XStreamAlias("coupon_name")
    String couponName;


    /**
     * 代金券状态：SENDED-可用，USED-已实扣，EXPIRED-已过期
     */
    @XStreamAlias("coupon_state")
    String couponState;


    /**
     * 代金券描述
     */
    @XStreamAlias("coupon_desc")
    String couponDesc;

    /**
     * 实际优惠金额
     */
    @XStreamAlias("coupon_use_value")
    Integer couponUseValue;

    /**
     * 代金券剩余金额：部分使用情况下，可能会存在券剩余金额
     */
    @XStreamAlias("coupon_remain_value")
    Integer couponRemainValue;


    /**
     * 代金券发放来源：FULL_SEND-满送 NORMAL-普通发放场景
     */
    @XStreamAlias("send_source")
    String sendSource;

    /**
     * 该代金券是否允许部分使用标识：1-表示支持部分使用
     */
    @XStreamAlias("is_partial_use")
    String isPartialUse;
}
