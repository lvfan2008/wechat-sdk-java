package fan.lv.wechat.entity.user;

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
    DeleteTag deleteTag;

    /**
     * @param id 标签id，由微信分配
     */
    public WxDeleteTagParam(Integer id) {
        deleteTag = new DeleteTag(id);
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
