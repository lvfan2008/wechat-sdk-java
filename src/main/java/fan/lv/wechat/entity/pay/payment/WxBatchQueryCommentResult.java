package fan.lv.wechat.entity.pay.payment;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import fan.lv.wechat.entity.pay.base.WxBasePayResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 拉取订单评价数据结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxBatchQueryCommentResult extends WxBasePayResult {

    /**
     * 详细参见第6节错误列表
     */
    @XStreamAlias("err_code")
    String payErrCode;


    /**
     * 错误返回的信息描述
     */
    @XStreamAlias("err_code_des")
    String payErrCodeDes;
}
