package fan.lv.wechat.entity.official.server.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 普通消息基类
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@XStreamAlias("xml")
@Data
public class BaseCommonMessage extends BaseReceiveMessage {
    /**
     * 消息类型
     */
    @XStreamAlias("MsgId")
    Integer msgId;
}
