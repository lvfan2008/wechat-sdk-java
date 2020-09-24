package fan.lv.wechat.entity.official.menu;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author lv_fan2008
 */
@Data
public class WxTryMatchPersonalizeMenuParam {
    /**
     * user_id可以是粉丝的OpenID，也可以是粉丝的微信号。
     */
    @JsonProperty("user_id")
    String userId;
}
