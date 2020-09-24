package fan.lv.wechat.entity.official.message.reply;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxAutoReplyRuleResult extends WxResult {

    /**
     * 关注后自动回复是否开启，0代表未开启，1代表开启
     */
    @JsonProperty("is_add_friend_reply_open")
    Integer isAddFriendReplyOpen;

    /**
     * 消息自动回复是否开启，0代表未开启，1代表开启
     */
    @JsonProperty("is_autoreply_open")
    Integer isAutoReplyOpen;

    /**
     * 关注后自动回复的信息
     */
    @JsonProperty("add_friend_autoreply_info")
    ReplyInfo addFriendAutoReplyInfo;


    /**
     * 消息自动回复的信息
     */
    @JsonProperty("message_default_autoreply_info")
    ReplyInfo messageDefaultAutoReplyInfo;

    /**
     * 关键词自动回复的信息
     */
    @JsonProperty("keyword_autoreply_info")
    KeywordAutoReplyInfo keywordAutoReplyInfo;

    @Data
    public static class KeywordAutoReplyInfo {
        /**
         * 回复规则列表
         */
        List<ReplyRule> list;
    }

    @Data
    public static class ReplyRule {
        /**
         * 规则名称
         */
        @JsonProperty("rule_name")
        String ruleName;

        /**
         * 创建时间
         */
        @JsonProperty("create_time")
        Integer createTime;

        /**
         * 回复模式，reply_all代表全部回复，random_one代表随机回复其中一条
         */
        @JsonProperty("reply_mode")
        String replyMode;

        /**
         * 匹配的关键词列表
         */
        @JsonProperty("keyword_list_info")
        List<MatchKeywordInfo> keywordListInfo;

        /**
         * 回复列表
         */
        @JsonProperty("reply_list_info")
        List<ReplyInfo> replyListInfo;
    }


    @Data
    public static class ReplyInfo {
        /**
         * 自动回复的类型。关注后自动回复和消息自动回复的类型仅支持文本（text）、图片（img）、语音（voice）、
         * 视频（video），关键词自动回复则还多了图文消息（news）
         */
        String type;

        /**
         * 对于文本类型，content是文本内容，对于图文、图片、语音、视频类型，content是mediaID
         */
        String content;

        /**
         * 图文消息
         */
        @JsonProperty("news_info")
        NewsList newsInfo;
    }

    /**
     * 匹配信息
     */
    @Data
    public static class MatchKeywordInfo {
        /**
         * 自动回复的类型。关注后自动回复和消息自动回复的类型仅支持文本（text）、图片（img）、语音（voice）、
         * 视频（video），关键词自动回复则还多了图文消息（news）
         */
        String type;

        /**
         * 对于文本类型，content是文本内容，对于图文、图片、语音、视频类型，content是mediaID
         */
        String content;

        /**
         * 匹配模式，contain代表消息中含有该关键词即可，equal表示消息内容必须和关键词严格相同
         */
        @JsonProperty("match_mode")
        String matchMode;
    }

    @Data
    public static class NewsList {
        List<News> list;
    }


    @Data
    public static class News {

        /**
         * 图文消息的标题
         */
        String title;

        /**
         * 图文消息的作者
         */
        String author;

        /**
         * 图文消息的描述，如本字段为空，则默认抓取正文前64个字
         */
        String digest;


        /**
         * 是否显示封面，1为显示，0为不显示
         */
        @JsonProperty("show_cover")
        Integer showCover = 0;


        /**
         * 封面图片的URL
         */
        @JsonProperty("cover_url")
        String coverUrl;


        /**
         * 正文的URL
         */
        @JsonProperty("content_url")
        String contentUrl;

        /**
         * 原文的URL，若置空则无查看原文入口
         */
        @JsonProperty("source_url")
        String sourceUrl;
    }
}
