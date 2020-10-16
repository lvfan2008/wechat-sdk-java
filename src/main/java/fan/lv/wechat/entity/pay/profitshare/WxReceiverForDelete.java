package fan.lv.wechat.entity.pay.profitshare;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lv_fan2008
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WxReceiverForDelete {
    /**
     * 分账接收方类型
     */
    String type;

    /**
     * 分账接收方帐号
     */
    String account;

    /**
     * 分账接收方全称
     */
    String name;
}
