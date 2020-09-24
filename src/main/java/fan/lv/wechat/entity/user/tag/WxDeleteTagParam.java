package fan.lv.wechat.entity.user.tag;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lv_fan2008
 */
@Data
public class WxDeleteTagParam {
    /**
     * 标签
     */
    DeleteTag tag;

    /**
     * @param id 标签id，由微信分配
     */
    public WxDeleteTagParam(Integer id) {
        tag = new DeleteTag(id);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DeleteTag {
        /**
         * 标签id，由微信分配
         */
        Integer id;
    }
}
