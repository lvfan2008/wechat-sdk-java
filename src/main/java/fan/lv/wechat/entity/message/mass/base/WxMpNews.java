package fan.lv.wechat.entity.message.mass.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用于设定即将发送的图文消息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WxMpNews {
    /**
     * 用于群发的消息的media_id,注意此处media_id需通过素材管理->新增素材来得到
     */
    @JsonProperty("media_id")
    String mediaId;
}
