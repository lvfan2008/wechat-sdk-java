package fan.lv.wechat.entity.official.message.mass.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 图片消息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WxImages {
    /**
     * 图片媒体Id列表
     */
    @JsonProperty("media_ids")
    List<String> mediaIds;

    /**
     * 推荐语，不填则默认为“分享图片”
     */
    String recommend;

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
