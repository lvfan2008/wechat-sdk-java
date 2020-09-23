package fan.lv.wechat.entity.comment;

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

    public WxReplyCommentParam(Integer msgDataId, Integer index, Integer userCommentId, String content) {
        super(msgDataId, index, userCommentId);
        this.content = content;
    }
}
