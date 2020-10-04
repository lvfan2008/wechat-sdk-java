package fan.lv.wechat.entity.mp.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 登陆会话凭证
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxSessionResult extends WxResult {
    /**
     * 用户唯一标识
     */
    @JsonProperty("openid")
    String openId;

    /**
     * 会话密钥
     */
    @JsonProperty("session_key")
    String sessionKey;

    /**
     * 用户在开放平台的唯一标识符，在满足 UnionID 下发条件的情况下会返回
     */
    @JsonProperty("unionid")
    String unionId;

}
