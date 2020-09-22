package fan.lv.wechat.entity.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxQueryMassSendResult extends WxResult {
    /**
     * 群发消息后返回的消息id
     */
    @JsonProperty("msg_id")
    Integer msgId;

    /**
     * 消息发送后的状态，SEND_SUCCESS表示发送成功，SENDING表示发送中，SEND_FAIL表示发送失败，DELETE表示已删除
     */
    @JsonProperty("msg_status")
    String msgStatus;

}
