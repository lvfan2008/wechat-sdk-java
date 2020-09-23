package fan.lv.wechat.entity.comment;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 评论列表
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxListCommentResult extends WxResult {
    /**
     * 总数，非comment的size around
     */
    Integer total;

    /**
     * 评论
     */
    List<Comment> comment;

    @Data
    public static class Comment {
        /**
         * 用户评论id
         */
        @JsonProperty("user_comment_id")
        Integer userCommentId;

        /**
         * openid
         */
        @JsonProperty("openid")
        String openId;

        /**
         * 评论时间
         */
        @JsonProperty("create_time")
        Integer createTime;

        /**
         * 评论内容
         */
        String content;

        /**
         * 是否精选评论，0为即非精选，1为true，即精选
         */
        @JsonProperty("comment_type")
        Integer commentType;

        /**
         * 回复内容
         */
        Reply reply;
    }

    @Data
    public static class Reply {
        /**
         * 作者回复内容
         */
        String content;

        /**
         * 作者回复时间
         */
        @JsonProperty("create_time")
        Integer createTime;
    }
}
