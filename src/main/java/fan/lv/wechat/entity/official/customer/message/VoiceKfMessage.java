package fan.lv.wechat.entity.official.customer.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class VoiceKfMessage extends BaseKfMessage {
    /**
     * 发送类型
     */
    @JsonProperty("msgtype")
    String msgType = "voice";

    /**
     * 图片
     */
    Voice voice;

    public VoiceKfMessage(String mediaId) {
        this.voice = new Voice(mediaId);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Voice {
        /**
         * 媒体文件Id
         */
        @JsonProperty("media_id")
        String mediaId;
    }
}
