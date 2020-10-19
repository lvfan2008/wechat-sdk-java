package fan.lv.wechat.entity.open.open.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 更新授权消息
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxUpdateAuthorizedMessage extends WxBaseMessage {

    /**
     * 通知类型，更新授权
     */
    @XStreamAlias("InfoType")
    String infoType = "updateauthorized";

    /**
     * 公众号或小程序的 appid
     */
    @XStreamAlias("AuthorizerAppid")
    String authorizerAppId;

    /**
     * 授权码，可用于获取授权信息
     */
    @XStreamAlias("AuthorizationCode")
    Integer authorizationCode;

    /**
     * 授权码过期时间 单位秒
     */
    @XStreamAlias("AuthorizationCodeExpiredTime")
    Integer authorizationCodeExpiredTime;

    /**
     * 预授权码
     */
    @XStreamAlias("PreAuthCode")
    String preAuthCode;
}
