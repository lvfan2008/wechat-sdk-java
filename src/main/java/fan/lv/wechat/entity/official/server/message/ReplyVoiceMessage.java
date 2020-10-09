package fan.lv.wechat.entity.official.server.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.*;

/**
 * 回复语音消息
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@XStreamAlias("xml")
@Data
@NoArgsConstructor
public class ReplyVoiceMessage extends BaseReplyMessage {
    /**
     * 消息类型
     */
    @XStreamAlias("MsgType")
    @JsonProperty("MsgType")
    String msgType = "voice";

    /**
     * 图片
     */
    @XStreamAlias("Voice")
    @JsonProperty("Voice")
    Voice voice;

    public ReplyVoiceMessage(String mediaId) {
        this.voice = new Voice(mediaId);
    }

    @XStreamAlias("Voice")
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Voice {
        /**
         * 通过素材管理中的接口上传多媒体文件，得到的id
         */
        @XStreamAlias("MediaId")
        @JsonProperty("MediaId")
        String mediaId;
    }
}
