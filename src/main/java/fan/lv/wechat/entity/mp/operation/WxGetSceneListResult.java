package fan.lv.wechat.entity.mp.operation;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 访问来源列表
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxGetSceneListResult extends WxResult {

    /**
     * 访问来源列表
     */
    List<Scene> scene;

    @Data
    public static class Scene {
        /**
         * 来源中文名
         */
        String name;

        /**
         * 访问来源数量
         */
        String value;
    }
}
