package fan.lv.wechat.entity.official.comment;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxListCommentParam extends WxOpenCommentParam {
    /**
     * 起始位置
     */
    Integer begin;

    /**
     * 获取数目（>=50会被拒绝）
     */
    Integer count;

    /**
     * type=0 普通评论&精选评论 type=1 普通评论 type=2 精选评论
     */
    Integer type;

    /**
     * @param msgDataId 群发返回的msg_data_id
     * @param index     多图文时，用来指定第几篇图文，从0开始，不带默认操作该msg_data_id的第一篇图文
     * @param begin     起始位置
     * @param count     获取数目（>=50会被拒绝）
     * @param type      type=0 普通评论&精选评论 type=1 普通评论 type=2 精选评论
     */
    public WxListCommentParam(Integer msgDataId, Integer index, Integer begin, Integer count, Integer type) {
        super(msgDataId, index);
        this.begin = begin;
        this.count = count;
        this.type = type;
    }

    public WxListCommentParam() {
    }
}
