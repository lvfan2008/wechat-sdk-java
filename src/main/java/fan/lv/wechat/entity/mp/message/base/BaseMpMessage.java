package fan.lv.wechat.entity.mp.message.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author lv_fan2008
 */
@Data
public class BaseMpMessage {
    /**
     * 粉丝Id
     */
    @JsonProperty("touser")
    String toUser;

    /**
     * 发送类型：text image link miniprogrampage
     */
    @JsonProperty("msgtype")
    String msgType;
}
