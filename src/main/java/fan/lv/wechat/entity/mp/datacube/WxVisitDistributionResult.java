package fan.lv.wechat.entity.mp.datacube;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 用户小程序访问分布数据
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxVisitDistributionResult extends WxResult {

    /**
     * 日期，格式为 yyyymmdd
     */
    @JsonProperty("ref_date")
    String refDate;

    /**
     * 分布数据列表
     */
    List<VisitDistribution> list;


    @Data
    public static class VisitDistribution {

        /**
         * 分布类型
         *
         * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/data-analysis/analysis.getVisitDistribution.html" target="_blank">参考页面</a>
         */
        String index;


        /**
         * 分布数据列表
         */
        @JsonProperty("item_list")
        List<Item> itemList;


    }

    @Data
    public static class Item {
        /**
         * 场景 id，定义在各个 index 下不同，具体参见下方表格
         *
         * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/data-analysis/analysis.getVisitDistribution.html" target="_blank">参考页面</a>
         */
        String key;

        /**
         * 该场景 id 访问 pv
         */
        Integer value;

        /**
         * 该场景 id 访问 uv
         */
        @JsonProperty("access_source_visit_uv")
        Integer accessSourceVisitUv;
    }
}
