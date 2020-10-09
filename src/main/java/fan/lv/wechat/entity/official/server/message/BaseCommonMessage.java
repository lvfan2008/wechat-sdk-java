package fan.lv.wechat.entity.official.server.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigInteger;

/**
 * 普通消息基类
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BaseCommonMessage extends BaseReceiveMessage {
    /**
     * 消息类型
     */
    @XStreamAlias("MsgId")
    @JsonProperty("MsgId")
    BigInteger msgId;
}
