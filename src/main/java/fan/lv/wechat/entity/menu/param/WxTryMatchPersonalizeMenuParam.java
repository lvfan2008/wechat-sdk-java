package fan.lv.wechat.entity.menu.param;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author lixinguo
 */
@Data
public class WxTryMatchPersonalizeMenuParam {
    /**
     * user_id可以是粉丝的OpenID，也可以是粉丝的微信号。
     */
    @JsonProperty("user_id")
    String userId;
}
