package fan.lv.wechat.entity.official.message.mass;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.official.message.mass.base.WxMessage;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 根据OpenId进行群发参数
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxMassSendByOpenIdParam extends WxMessage {

    /**
     * 图文消息被判定为转载时，是否继续群发。 1为继续群发（转载），0为停止群发。 该参数默认为0。
     */
    @JsonProperty("send_ignore_reprint")
    Integer sendIgnoreReprint;

    /**
     * 开发者侧群发msgid，长度限制64字节，如不填，则后台默认以群发范围和群发内容的摘要值做为clientmsgid
     */
    @JsonProperty("clientmsgid")
    String clientMsgId;

    /**
     * 填写图文消息的接收者，一串OpenID列表，OpenID最少2个，最多10000个
     */
    @JsonProperty("touser")
    List<String> toUsers;

}
