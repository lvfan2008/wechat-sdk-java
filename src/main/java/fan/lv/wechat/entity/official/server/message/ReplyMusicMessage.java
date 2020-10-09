package fan.lv.wechat.entity.official.server.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.*;

/**
 * 回复音乐消息
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@XStreamAlias("xml")
@Data
@NoArgsConstructor
public class ReplyMusicMessage extends BaseReplyMessage {

    /**
     * 消息类型
     */
    @XStreamAlias("MsgType")
    @JsonProperty("MsgType")
    String msgType = "music";

    /**
     * 图片
     */
    @XStreamAlias("Music")
    @JsonProperty("Music")
    Music music;

    public ReplyMusicMessage(String title, String description, String musicUrl, String hqMusicUrl, String thumbMediaId) {
        this.music = new Music(title, description, musicUrl, hqMusicUrl, thumbMediaId);
    }

    @XStreamAlias("Music")
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Music {
        /**
         * 音乐标题
         */
        @XStreamAlias("Title")
        @JsonProperty("Title")
        String title;


        /**
         * 音乐描述
         */
        @XStreamAlias("Description")
        @JsonProperty("Description")
        String description;

        /**
         * 音乐Url
         */
        @XStreamAlias("MusicURL")
        @JsonProperty("MusicURL")
        String musicUrl;

        /**
         * 高质量音乐链接，WIFI环境优先使用该链接播放音乐
         */
        @XStreamAlias("HQMusicUrl")
        @JsonProperty("HQMusicUrl")
        String hqMusicUrl;

        /**
         * 缩略图的媒体id，通过素材管理中的接口上传多媒体文件，得到的id
         */
        @XStreamAlias("ThumbMediaId")
        @JsonProperty("ThumbMediaId")
        String thumbMediaId;
    }
}
