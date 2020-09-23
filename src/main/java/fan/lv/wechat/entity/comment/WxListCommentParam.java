package fan.lv.wechat.entity.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
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


}
