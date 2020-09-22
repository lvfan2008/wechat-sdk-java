package fan.lv.wechat.entity.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 声音消息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Voice {
    /**
     * 声音媒体Id
     */
    @JsonProperty("media_id")
    String mediaId;
}
