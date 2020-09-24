package fan.lv.wechat.entity.official.comment;

import lombok.Getter;
import lombok.Setter;

/**
 * @author lv_fan2008
 */
@Getter
@Setter
public class WxReplyCommentParam extends WxCommentParam {
    /**
     * 回复内容
     */
    String content;

    /**
     * @param msgDataId     群发返回的msg_data_id
     * @param index         多图文时，用来指定第几篇图文，从0开始，不带默认操作该msg_data_id的第一篇图文
     * @param userCommentId 用户评论id
     * @param content       回复内容
     */
    public WxReplyCommentParam(Integer msgDataId, Integer index, Integer userCommentId, String content) {
        super(msgDataId, index, userCommentId);
        this.content = content;
    }

    public WxReplyCommentParam() {
    }
}
