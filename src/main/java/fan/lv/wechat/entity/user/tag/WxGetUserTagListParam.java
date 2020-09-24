package fan.lv.wechat.entity.user.tag;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lv_fan2008
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WxGetUserTagListParam {
    /**
     * OpenId
     */
    @JsonProperty("openid")
    String openId;
}
