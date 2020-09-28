package fan.lv.wechat.entity.official.server.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 回复文本消息
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BaseReplyMessage extends BaseMessage {
    /**
     * 消息创建时间 （整型）
     */
    @XStreamAlias("CreateTime")
    Integer createTime = (int) (System.currentTimeMillis() / 1000);
}
