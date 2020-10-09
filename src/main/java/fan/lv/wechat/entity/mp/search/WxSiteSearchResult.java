package fan.lv.wechat.entity.mp.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 针对页面的查询结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxSiteSearchResult extends WxResult {

    /**
     * 搜索结果列表
     */
    List<Item> items;

    /**
     * 是否有下一页
     */
    @JsonProperty("has_next_page")
    Boolean hasNextPage;

    /**
     * 请求下一页的参数，开发者无需理解，如需查询下一页结果，把该参数填充到下页请求参数中的next_page_info即可
     */
    @JsonProperty("next_page_info")
    String nextPageInfo;

    /**
     * 估算索引文档数
     */
    @JsonProperty("hit_count")
    Integer hitCount;

    @Data
    public static class Item {
        /**
         * 小程序商品页面标题
         */
        String title;

        /**
         * 小程序页面摘要
         */
        String description;

        /**
         * 小程序页面代表图
         */
        String image;

        /**
         * 小程序商品页面地址
         */
        String path;
    }
}
