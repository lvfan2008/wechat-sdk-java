package fan.lv.wechat.entity.official.server.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 回复加密消息
 *
 * @author lv_fan2008
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@XStreamAlias("xml")
public class EncryptReplyMessage {
    /**
     * 密文
     */
    @XStreamAlias("Encrypt")
    @JsonProperty("Encrypt")
    String encrypt;

    /**
     * 签名
     */
    @XStreamAlias("MsgSignature")
    @JsonProperty("MsgSignature")
    String msgSignature;


    /**
     * 时间戳
     */
    @XStreamAlias("TimeStamp")
    @JsonProperty("TimeStamp")
    String timeStamp;

    /**
     * 随机串
     */
    @XStreamAlias("Nonce")
    @JsonProperty("Nonce")
    String nonce;
}
