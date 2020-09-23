package fan.lv.wechat.entity.comment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxCommentParam extends WxOpenCommentParam {
    /**
     * 用户评论id
     */
    @JsonProperty("user_comment_id")
    Integer userCommentId;

    /**
     * @param msgDataId     群发返回的msg_data_id
     * @param index         多图文时，用来指定第几篇图文，从0开始，不带默认操作该msg_data_id的第一篇图文
     * @param userCommentId 用户评论id
     */
    public WxCommentParam(Integer msgDataId, Integer index, Integer userCommentId) {
        super(msgDataId, index);
        this.userCommentId = userCommentId;
    }

    public WxCommentParam() {
    }
}

