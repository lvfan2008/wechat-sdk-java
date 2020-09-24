package fan.lv.wechat.entity.official.statics;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 获取图文群发总数据（getarticletotal）结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxArticleTotalResult extends WxResult {

    /**
     * 数据的日期，需在begin_date和end_date之间
     */
    @JsonProperty("ref_date")
    String refDate;

    /**
     * 这里的msgid实际上是由msgid（图文消息id，这也就是群发接口调用后返回的msg_data_id）和index（消息次序索引）组成，
     * 例如12003_3， 其中12003是msgid，即一次群发的消息的id； 3为index，假设该次群发的图文消息共5个文章（因为可能为多图文），3表示5个中的第3个
     */
    @JsonProperty("msgid")
    String msgId;

    /**
     * 图文消息的标题
     * 注：仅图文群发每日数据 和 图文群发总数据接口可用
     */
    String title;

    /**
     * 每日详情统计
     */
    List<Detail> details;

    @Data
    public static class Detail {

        /**
         * 统计的日期，在getarticletotal接口中，ref_date指的是文章群发出日期， 而stat_date是数据统计日期
         */
        @JsonProperty("stat_date")
        String statDate;

        /**
         * 送达人数，一般约等于总粉丝数（需排除黑名单或其他异常情况下无法收到消息的粉丝）
         */
        @JsonProperty("target_user")
        Integer targetUser;

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

        /**
         * 公众号会话阅读人数
         */
        @JsonProperty("int_page_from_session_read_user")
        Integer intPageFromSessionReadUser;

        /**
         * 公众号会话阅读次数
         */
        @JsonProperty("int_page_from_session_read_count")
        Integer intPageFromSessionReadCount;

        /**
         * 历史消息页阅读人数
         */
        @JsonProperty("int_page_from_hist_msg_read_user")
        Integer intPageFromHistMsgReadUser;

        /**
         * 历史消息页阅读次数
         */
        @JsonProperty("int_page_from_hist_msg_read_count")
        Integer intPageFromHistMsgReadCount;

        /**
         * 朋友圈阅读人数
         */
        @JsonProperty("int_page_from_feed_read_user")
        Integer intPageFromFeedReadUser;

        /**
         * 朋友圈阅读次数
         */
        @JsonProperty("int_page_from_feed_read_count")
        Integer intPageFromFeedReadCount;

        /**
         * 好友转发阅读人数
         */
        @JsonProperty("int_page_from_friends_read_user")
        Integer intPageFromFriendsReadUser;

        /**
         * 好友转发阅读次数
         */
        @JsonProperty("int_page_from_friends_read_count")
        Integer intPageFromFriendsReadCount;

        /**
         * 其他场景阅读人数
         */
        @JsonProperty("int_page_from_other_read_user")
        Integer intPageFromOtherReadUser;

        /**
         * 其他场景阅读次数
         */
        @JsonProperty("int_page_from_other_read_count")
        Integer intPageFromOtherReadCount;


        /**
         * 看一看来源阅读人数
         */
        @JsonProperty("int_page_from_kanyikan_read_user")
        Integer intPageFromKanyikanReadUser;

        /**
         * 看一看来源阅读次数
         */
        @JsonProperty("int_page_from_kanyikan_read_count")
        Integer intPageFromKanyikanReadCount;

        /**
         * 搜一搜来源阅读人数
         */
        @JsonProperty("int_page_from_souyisou_read_user")
        Integer intPageFromSouyisouReadUser;

        /**
         * 搜一搜来源阅读次数
         */
        @JsonProperty("int_page_from_souyisou_read_count")
        Integer intPageFromSouyisouReadCount;

        /**
         * 公众号会话转发朋友圈人数
         */
        @JsonProperty("feed_share_from_session_user")
        Integer feedShareFromSessionUser;

        /**
         * 公众号会话转发朋友圈次数
         */
        @JsonProperty("feed_share_from_session_cnt")
        Integer feedShareFromSessionCnt;


        /**
         * 朋友圈转发朋友圈人数
         */
        @JsonProperty("feed_share_from_feed_user")
        Integer feedShareFromFeedUser;

        /**
         * 朋友圈转发朋友圈次数
         */
        @JsonProperty("feed_share_from_feed_cnt")
        Integer feedShareFromFeedCnt;

        /**
         * 其他场景转发朋友圈人数
         */
        @JsonProperty("feed_share_from_other_user")
        Integer feedShareFromOtherUser;

        /**
         * 其他场景转发朋友圈次数
         */
        @JsonProperty("feed_share_from_other_cnt")
        Integer feedShareFromOtherCnt;
    }


}
