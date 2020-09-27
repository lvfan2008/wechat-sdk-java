package fan.lv.wechat.entity.official.server.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户已关注时的事件
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@XStreamAlias("xml")
@Data
public class EventScanMessage extends EventSubscribeMessage {
    /**
     * 事件类型
     */
    @XStreamAlias("Event")
    String event = "SCAN";
}
