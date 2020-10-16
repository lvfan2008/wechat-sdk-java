package fan.lv.wechat.entity.pay.profitshare;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author lv_fan2008
 */
@Data
public class WxReceiverForQuery {
    /**
     * 分账接收方类型
     * MERCHANT_ID：商户ID
     * PERSONAL_OPENID：个人openid（由父商户APPID转换得到）PERSONAL_SUB_OPENID: 个人sub_openid（由子商户APPID转换得到）
     */
    String type;

    /**
     * 分账接收方帐号:
     * 类型是MERCHANT_ID时，是商户ID
     * 类型是PERSONAL_OPENID时，是个人openid
     * 类型是PERSONAL_SUB_OPENID时，是个人sub_openid
     */
    String account;

    /**
     * 分账金额，单位为分，只能为整数，不能超过原订单支付金额及最大分账比例金额
     */
    Integer amount;

    /**
     * 分账的原因描述，分账账单中需要体现
     */
    String description;

    /**
     * 分账结果
     * PENDING:待分账
     * SUCCESS:分账成功
     * ADJUST:分账失败待调账
     * RETURNED:已转回分账方
     * CLOSED: 已关闭
     */
    String result;

    /**
     * 分账完成时间
     */
    @JsonProperty("finish_time")
    String finishTime;

    /**
     * 分账失败原因
     */
    @JsonProperty("fail_reason")
    Integer failReason;
}
