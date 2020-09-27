package fan.lv.wechat.entity.official.server.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 回复文本消息
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@XStreamAlias("xml")
@Data
@NoArgsConstructor
public class ReplyTextMessage extends BaseReplyMessage {

    /**
     * 消息类型
     */
    @XStreamAlias("MsgType")
    String msgType = "text";

    /**
     * 回复的消息内容（换行：在content中能够换行，微信客户端就支持换行显示）
     */
    @XStreamAlias("Content")
    String content;

    public ReplyTextMessage(String content) {
        this.content = content;
    }
}
