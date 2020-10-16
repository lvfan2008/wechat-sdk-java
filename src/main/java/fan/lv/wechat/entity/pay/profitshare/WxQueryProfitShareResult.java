package fan.lv.wechat.entity.pay.profitshare;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import fan.lv.wechat.entity.pay.base.WxCommonPayResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 查询分账结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxQueryProfitShareResult extends WxCommonPayResult {

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


    /**
     * 分账单状态：
     * ACCEPTED—受理成功
     * PROCESSING—处理中
     * FINISHED—处理完成
     * CLOSED—处理失败，已关单
     */
    @XStreamAlias("status")
    String status;


    /**
     * 关单原因，NO_AUTH:分账授权已解除
     */
    @XStreamAlias("close_reason")
    String closeReason;


    /**
     * 分账接收方列表，json存储
     */
    @XStreamAlias("receivers")
    String receivers;

    /**
     * 解析后的分账接收方列表
     */
    @XStreamOmitField
    List<WxReceiverForQuery> decodeReceivers;

    /**
     * 分账完结的分账金额，单位为分， 仅当查询分账完结的执行结果时，存在本字段
     */
    @XStreamAlias("amount")
    Integer amount;


    /**
     * 分账完结的原因描述，仅当查询分账完结的执行结果时，存在本字段
     */
    @XStreamAlias("description")
    String description;
}
