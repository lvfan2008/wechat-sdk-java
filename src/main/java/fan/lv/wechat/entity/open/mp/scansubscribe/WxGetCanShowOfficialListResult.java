package fan.lv.wechat.entity.open.mp.scansubscribe;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 获取可以用来设置的公众号列表结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxGetCanShowOfficialListResult extends WxResult {

    /**
     * 总记录数
     */
    @JsonProperty("total_num")
    Integer totalNum;

    /**
     * 公众号信息列表
     */
    @JsonProperty("biz_info_list")
    List<BizInfo> bizInfoList;

    @Data
    public static class BizInfo {
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
}
