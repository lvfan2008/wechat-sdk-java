package fan.lv.wechat.entity.mp.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 创建被分享动态消息或私密消息的 activity_id结果
 *
 * @author lv_fan2008
 * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/updatable-message/updatableMessage.createActivityId.html" target="_blank">微信官方文档</a>
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxCreateActivityIdResult extends WxResult {

    /**
     * 动态消息的 ID
     */
    @JsonProperty("activity_id")
    String activityId;

    /**
     * activity_id 的过期时间戳。默认24小时后过期。
     */
    @JsonProperty("expiration_time")
    Integer expirationTime;
}
