package fan.lv.wechat.entity.official.customer.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author lv_fan2008
 */
@Data
public class BaseKfMessage {
    /**
     * 粉丝Id
     */
    @JsonProperty("touser")
    String toUser;

    /**
     * 发送类型：text image voice video news mpnews msgmenu wxcard miniprogrampage text-customservice
     */
    @JsonProperty("msgtype")
    String msgType;
}
