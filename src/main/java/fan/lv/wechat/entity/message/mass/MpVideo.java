package fan.lv.wechat.entity.message.mass;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 视频消息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MpVideo {
    /**
     * 视频媒体Id
     */
    @JsonProperty("media_id")
    String mediaId;
}
