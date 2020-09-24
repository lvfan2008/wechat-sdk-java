package fan.lv.wechat.entity.official.user;

import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxGetTagsResult extends WxResult {
    /**
     * 标签列表
     */
    List<WxTagAndCount> tags;

    /**
     * @author lv_fan2008
     */
    @Data
    public static class WxTagAndCount {
        /**
         * 标签id，由微信分配
         */
        Integer id;

        /**
         * 标签名
         */
        String name;

        /**
         * 标签下粉丝数
         */
        Integer count;
    }

}
