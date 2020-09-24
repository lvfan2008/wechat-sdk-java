package fan.lv.wechat.entity.official.statics;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxUserSummaryResult extends WxResult {

    /**
     * 统计数据列表
     */
    List<UserStatic> list;

    @Data
    public static class UserStatic {
        /**
         * 数据的日期
         */
        @JsonProperty("ref_date")
        String refDate;

        /**
         * 用户的渠道，数值代表的含义如下： 0代表其他合计 1代表公众号搜索 17代表名片分享
         * 30代表扫描二维码 51代表支付后关注（在支付完成页） 57代表文章内账号名称 100微信广告 161他人转载 176 专辑页内账号名称
         */
        @JsonProperty("user_source")
        Integer userScore;

        /**
         * 新增的用户数量
         */
        @JsonProperty("new_user")
        Integer newUser;

        /**
         * 取消关注的用户数量，new_user减去cancel_user即为净增用户数量
         */
        @JsonProperty("cancel_user")
        Integer cancelUser;
    }

}
