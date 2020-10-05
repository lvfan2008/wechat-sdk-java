package fan.lv.wechat.entity.mp.subscribe;

import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 类目列表
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxCategoryResult extends WxResult {

    /**
     * 类目列表
     */
    List<MpCategory> data;

    @Data
    public static class MpCategory {
        /**
         * 类目id，查询公共库模版时需要
         */
        Integer id;

        /**
         * 类目的中文名
         */
        String name;
    }
}
