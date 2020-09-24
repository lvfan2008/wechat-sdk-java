package fan.lv.wechat.entity.official.statics;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 获取图文群发每日数据（getarticlesummary）
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxArticlesSummaryResult extends WxResult {
    /**
     * 统计数据列表
     */
    List<ArticlesSummary> list;

    @Data
    public static class ArticlesSummary {
        /**
         * 数据的日期，需在begin_date和end_date之间
         */
        @JsonProperty("ref_date")
        String refDate;

        /**
         * 这里的msgid实际上是由msgid（图文消息id，这也就是群发接口调用后返回的msg_data_id）和index（消息次序索引）组成，
         * 例如12003_3， 其中12003是msgid，即一次群发的消息的id； 3为index，假设该次群发的图文消息共5个文章（因为可能为多图文），3表示5个中的第3个
         * 注：仅图文群发每日数据 和 图文群发总数据接口可用
         */
        @JsonProperty("msgid")
        String msgId;

        /**
         * 图文消息的标题
         * 注：仅图文群发每日数据 和 图文群发总数据接口可用
         */
        String title;

        /**
         * 图文页（点击群发图文卡片进入的页面）的阅读人数
         */
        @JsonProperty("int_page_read_user")
        Integer intPageReadUser;

        /**
         * 图文页的阅读次数
         */
        @JsonProperty("int_page_read_count")
        Integer intPageReadCount;

        /**
         * 原文页（点击图文页“阅读原文”进入的页面）的阅读人数，无原文页时此处数据为0
         */
        @JsonProperty("ori_page_read_user")
        Integer oriPageReadUser;

        /**
         * 原文页的阅读次数
         */
        @JsonProperty("ori_page_read_count")
        Integer oriPageReadCount;

        /**
         * 分享的人数
         */
        @JsonProperty("share_user")
        Integer shareUser;

        /**
         * 分享的次数
         */
        @JsonProperty("share_count")
        Integer shareCount;

        /**
         * 收藏的人数
         */
        @JsonProperty("add_to_fav_user")
        Integer addToFavUser;

        /**
         * 收藏的次数
         */
        @JsonProperty("add_to_fav_count")
        Integer addToFavCount;
    }


}
