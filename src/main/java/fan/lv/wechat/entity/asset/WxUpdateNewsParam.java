package fan.lv.wechat.entity.asset;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.message.mass.base.WxNews;
import lombok.Data;

/**
 * @author lv_fan2008
 */
@Data
public class WxUpdateNewsParam {

    /**
     * 永久素材的media_id
     */
    @JsonProperty("media_id")
    String mediaId;

    /**
     * 要更新的文章在图文消息中的位置（多图文消息时，此字段才有意义），第一篇为0
     */
    Integer index;

    /**
     * 图文消息
     */
    WxNews articles;
}
