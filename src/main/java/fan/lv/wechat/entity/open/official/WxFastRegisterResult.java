package fan.lv.wechat.entity.open.official;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 快速注册小程序结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxFastRegisterResult extends WxResult {

    /**
     * 新创建小程序的 appid
     */
    @JsonProperty("appid")
    String appId;


    /**
     * 新创建小程序的授权码
     */
    @JsonProperty("authorization_code")
    String authorizationCode;

    /**
     * 复用公众号微信认证小程序是否成功
     */
    @JsonProperty("is_wx_verify_succ")
    String isWxVerifySucc;

    /**
     * 小程序是否和公众号关联成功
     */
    @JsonProperty("is_link_succ")
    String isLinkSucc;
}
