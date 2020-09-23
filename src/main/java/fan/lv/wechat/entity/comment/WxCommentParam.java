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

    public WxCommentParam(Integer msgDataId, Integer index, Integer userCommentId) {
        super(msgDataId, index);
        this.userCommentId = userCommentId;
    }
}

