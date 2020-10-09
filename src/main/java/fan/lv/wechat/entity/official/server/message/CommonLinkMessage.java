package fan.lv.wechat.entity.official.server.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 链接消息
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@XStreamAlias("xml")
@Data
public class CommonLinkMessage extends BaseCommonMessage {

    /**
     * 消息类型
     */
    @XStreamAlias("MsgType")
    @JsonProperty("MsgType")
    String msgType = "link";

    /**
     * 消息标题
     */
    @XStreamAlias("Title")
    @JsonProperty("Title")
    String title;

    /**
     * 消息描述
     */
    @XStreamAlias("Description")
    @JsonProperty("Description")
    String description;

    /**
     * 消息链接
     */
    @XStreamAlias("Url")
    @JsonProperty("Url")
    String url;
}
