package fan.lv.wechat.entity.message.mass.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 图文消息
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxNews extends WxNewsBase {

    /**
     * Uint32 是否打开评论，0不打开，1打开
     */
    @JsonProperty("need_open_comment")
    Integer needOpenComment = 0;

    /**
     * Uint32 是否粉丝才可评论，0所有人可评论，1粉丝才可评论
     */
    @JsonProperty("only_fans_can_comment")
    Integer onlyFansCanComment = 0;
}
