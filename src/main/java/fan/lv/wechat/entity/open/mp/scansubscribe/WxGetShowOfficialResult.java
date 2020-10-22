package fan.lv.wechat.entity.open.mp.scansubscribe;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 获取展示的公众号信息结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxGetShowOfficialResult extends WxResult {

    /**
     * 是否可以设置 1 可以，0，不可以
     */
    @JsonProperty("can_open")
    Integer canOpen;

    /**
     * 是否已经设置，1 已设置，0，未设置
     */
    @JsonProperty("is_open")
    Integer isOpen;

    /**
     * 展示的公众号 appid
     */
    @JsonProperty("appid")
    String appId;

    /**
     * 展示的公众号 nickname
     */
    String nickname;

    /**
     * 展示的公众号头像
     */
    @JsonProperty("headimg")
    String headImg;
}
