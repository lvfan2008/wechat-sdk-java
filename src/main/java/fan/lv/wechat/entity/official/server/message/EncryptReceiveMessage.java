package fan.lv.wechat.entity.official.server.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * 接收到的加密消息
 *
 * @author lv_fan2008
 */
@Data
@XStreamAlias("xml")
public class EncryptReceiveMessage {
    /**
     * 开发者微信号
     */
    @XStreamAlias("ToUserName")
    @JsonProperty("ToUserName")
    String toUserName;

    /**
     * 发送方帐号（一个OpenID）
     */
    @XStreamAlias("Encrypt")
    @JsonProperty("Encrypt")
    String encrypt;
}
