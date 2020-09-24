package fan.lv.wechat.entity.official.message.mass;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.official.message.mass.base.WxMessage;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 群发预览参数
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxMassSendPreviewParam extends WxMessage {

    /**
     * 开发者侧群发msgid，长度限制64字节，如不填，则后台默认以群发范围和群发内容的摘要值做为clientmsgid
     */
    @JsonProperty("clientmsgid")
    String clientMsgId;

    /**
     * 接收消息用户对应该公众号的openid，该字段也可以改为towxname，以实现对微信号的预览
     */
    @JsonProperty("touser")
    String toUsers;

}
