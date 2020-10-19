package fan.lv.wechat.entity.open.open.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 验证票据
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxComponentVerifyTicketMessage extends WxBaseMessage {

    /**
     * 通知类型，验证票据
     */
    @XStreamAlias("InfoType")
    String infoType = "component_verify_ticket";

    /**
     * Ticket 内容
     */
    @XStreamAlias("ComponentVerifyTicket")
    String componentVerifyTicket;
}
