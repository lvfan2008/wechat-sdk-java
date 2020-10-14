package fan.lv.wechat.entity.pay.payment;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import fan.lv.wechat.entity.pay.base.WxCommonPayResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 撤销订单结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxPayReverseResult extends WxCommonPayResult {

    /**
     * 是否需要继续调用撤销，Y-需要，N-不需要
     */
    @XStreamAlias("recall")
    String recall;
}
