package fan.lv.wechat.entity.message.mass;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 群发消息后返回的消息id
 *
 * @author lv_fan2008
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WxQueryMassSendParam {

    /**
     * 消息发送任务的ID
     */
    @JsonProperty("msg_id")
    Integer msgId;
}
