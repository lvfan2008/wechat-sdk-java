package fan.lv.wechat.entity.official.message.template;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxSendTemplateMessageResult extends WxResult {

    /**
     * 消息Id
     */
    @JsonProperty("msgid")
    String msgId;
}
