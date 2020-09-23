package fan.lv.wechat.entity.asset;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.message.mass.base.WxNewsBase;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxBatchGetMaterialResult extends WxResult {

    /**
     * 该类型的素材的总数
     */
    @JsonProperty("total_count")
    Integer totalCount;

    /**
     * 本次调用获取的素材的数量
     */
    @JsonProperty("item_count")
    Integer itemCount;

    @Data
    public static class Item {
        /**
         * 媒体文件Id
         */
        @JsonProperty("media_id")
        String mediaId;

        /**
         * 文件名称
         */
        String name;

        /**
         * 图文页的URL，或者，当获取的列表是图片素材列表时，该字段是图片的URL
         */
        String url;

        /**
         * 这篇图文消息素材的最后更新时间
         */
        @JsonProperty("update_time")
        Integer updateTime;

        /**
         * 图文内容
         */
        Content content;

    }

    @Data
    public static class Content {
        /**
         * 图文消息
         */
        @JsonProperty("news_item")
        List<News> newsItem;

    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class News extends WxNewsBase {
        /**
         * 图文页的URL
         */
        String url;
    }
}
