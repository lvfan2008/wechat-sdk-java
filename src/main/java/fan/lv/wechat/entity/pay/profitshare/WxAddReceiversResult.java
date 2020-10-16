package fan.lv.wechat.entity.pay.profitshare;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import fan.lv.wechat.entity.pay.base.WxCommonPayResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 查询分账结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxAddReceiversResult extends WxCommonPayResult {

    /**
     * 分账接收方对象，json存储
     */
    @XStreamAlias("receiver")
    String receiver;

    /**
     * 解析后的分账接收方列表
     */
    @XStreamOmitField
    WxReceiverForAdd decodeReceiver;

}
