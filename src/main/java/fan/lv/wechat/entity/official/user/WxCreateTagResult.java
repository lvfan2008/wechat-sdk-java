package fan.lv.wechat.entity.official.user;

import fan.lv.wechat.entity.result.WxResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxCreateTagResult extends WxResult {
    /**
     * 标签
     */
    ResultTag tag;

    /**
     * @author lv_fan2008
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ResultTag {
        /**
         * 标签id，由微信分配
         */
        Integer id;

        /**
         * 标签名
         */
        String name;
    }
}
