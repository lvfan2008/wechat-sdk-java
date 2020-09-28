package fan.lv.wechat.entity.official.server.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * @author lv_fan2008
 */
@Data
public class BaseMessage {
    /**
     * 开发者微信号
     */
    @XStreamAlias("ToUserName")
    String toUserName;

    /**
     * 发送方帐号（一个OpenID）
     */
    @XStreamAlias("FromUserName")
    String fromUserName;

    /**
     * 消息创建时间 （整型）
     */
    @XStreamAlias("CreateTime")
    Integer createTime;

    /**
     * 消息类型
     */
    @XStreamAlias("MsgType")
    String msgType;
}
