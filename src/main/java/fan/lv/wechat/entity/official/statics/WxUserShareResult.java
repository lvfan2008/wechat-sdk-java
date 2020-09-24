package fan.lv.wechat.entity.official.statics;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 获取图文分享转发数据（getusershare）结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxUserShareResult extends WxResult {

    /**
     * 数据列表
     */
    List<UserShare> list;

    @Data
    public static class UserShare {
        /**
         * 数据的日期，需在begin_date和end_date之间
         */
        @JsonProperty("ref_date")
        String refDate;

        /**
         * 分享的场景 1代表好友转发 2代表朋友圈 3代表腾讯微博 255代表其他
         */
        @JsonProperty("share_scene")
        String shareScene;

        /**
         * 分享的人数
         */
        @JsonProperty("share_user")
        String shareUser;

        /**
         * 分享的次数
         */
        @JsonProperty("share_count")
        String shareCount;
    }


}
