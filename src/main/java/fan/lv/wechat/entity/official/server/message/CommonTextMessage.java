package fan.lv.wechat.entity.official.server.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 文本消息
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@XStreamAlias("xml")
@Data
public class CommonTextMessage extends BaseCommonMessage {

    /**
     * 消息类型
     */
    @XStreamAlias("MsgType")
    String msgType = "text";

    /**
     * 文本消息内容
     */
    @XStreamAlias("Content")
    String content;

    /**
     * 点击的菜单ID，主要用于客服发送菜单消息时，点击菜单时的回复。
     */
    @XStreamAlias("bizmsgmenuid")
    String bizMsgMenuId;
}
