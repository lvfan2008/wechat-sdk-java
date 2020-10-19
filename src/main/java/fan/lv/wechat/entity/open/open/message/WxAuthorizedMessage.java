package fan.lv.wechat.entity.open.open.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 授权成功消息
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxAuthorizedMessage extends WxBaseMessage {

    /**
     * 通知类型，授权成功
     */
    @XStreamAlias("InfoType")
    String infoType = "authorized";

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
