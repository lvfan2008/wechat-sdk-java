package fan.lv.wechat.entity.open.open.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 取消授权消息
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxUnAuthorizedMessage extends WxBaseMessage {

    /**
     * 通知类型，取消授权
     */
    @XStreamAlias("InfoType")
    String infoType = "unauthorized";

    /**
     * 公众号或小程序的 appid
     */
    @XStreamAlias("AuthorizerAppid")
    String authorizerAppId;
}
