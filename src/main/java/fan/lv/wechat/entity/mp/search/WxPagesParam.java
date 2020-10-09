package fan.lv.wechat.entity.mp.search;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author lv_fan2008
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WxPagesParam {
    /**
     * 小程序页面信息列表
     */
    List<Pages> pages;


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Pages {
        /**
         * 页面路径
         */
        String path;

        /**
         * 页面参数
         */
        String query;
    }
}
