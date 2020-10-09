package fan.lv.wechat.entity.official.server.message;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 事件消息基类
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BaseReceiveMessage extends BaseMessage {
    /**
     * 原始串
     */
    @JsonIgnore
    @XStreamOmitField
    String originMessage;

    /**
     * 消息类型
     */
    @XStreamAlias("MsgType")
    @JsonProperty("MsgType")
    String msgType;

    /**
     * 事件类型，默认为null，多加这个字段是为了兼容处理
     */
    @XStreamAlias("Event")
    @JsonProperty("Event")
    String event;
}
