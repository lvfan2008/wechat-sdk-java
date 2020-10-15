package fan.lv.wechat.entity.pay.coupon;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import fan.lv.wechat.entity.pay.base.WxCommonPayResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 查询代金券批次结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxQueryCouponStockResult extends WxCommonPayResult {

    /**
     * 代金券批次id，创建代金券时生成的批次号，可在商户平台-代金券管理页面查看
     */
    @XStreamAlias("coupon_stock_id")
    String couponStockId;


    /**
     * 代金券名称
     */
    @XStreamAlias("coupon_name")
    String couponName;


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
     * 批次状态： 1-未激活；2-审批中；4-已激活；8-已作废；16-中止发放；
     */
    @XStreamAlias("coupon_stock_status")
    Integer couponStockStatus;


    /**
     * 代金券数量
     */
    @XStreamAlias("coupon_total")
    Integer couponTotal;


    /**
     * 代金券每个人最多能领取的数量, 如果为0，则表示没有限制
     */
    @XStreamAlias("max_quota")
    Integer maxQuota;

    /**
     * 代金券已经发送的数量
     */
    @XStreamAlias("is_send_num")
    Integer isSendNum;

    /**
     * 生效开始时间
     */
    @XStreamAlias("begin_time")
    Integer beginTime;


    /**
     * 生效结束时间
     */
    @XStreamAlias("end_time")
    Integer endTime;

    /**
     * 创建时间
     */
    @XStreamAlias("create_time")
    Integer createTime;

    /**
     * 代金券预算额度
     */
    @XStreamAlias("coupon_budget")
    Integer couponBudget;

    /**
     * 生效开始时间，格式为年月日时间制：20181126152401
     */
    @XStreamAlias("begin_time_t")
    String beginTimeT;

    /**
     * 生效结束时间，格式为年月日时间制：20181126152401
     */
    @XStreamAlias("end_time_t")
    String endTimeT;

    /**
     * 创建时间，格式为年月日时间制：20181126152401
     */
    @XStreamAlias("create_time_t")
    String createTimeT;
}
