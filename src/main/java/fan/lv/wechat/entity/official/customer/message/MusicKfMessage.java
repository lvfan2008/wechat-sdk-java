package fan.lv.wechat.entity.official.customer.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import fan.lv.wechat.entity.official.server.message.ReplyMusicMessage;
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
public class MusicKfMessage extends BaseKfMessage {
    /**
     * 发送类型
     */
    @JsonProperty("msgtype")
    String msgType = "music";

    /**
     * 图片
     */
    Music music;

    /**
     * 构造音乐消息
     *
     * @param title        音乐标题
     * @param description  音乐描述
     * @param musicUrl     音乐Url
     * @param hqMusicUrl   高质量音乐链接
     * @param thumbMediaId 缩略图的媒体id
     */
    public MusicKfMessage(String title, String description, String musicUrl, String hqMusicUrl, String thumbMediaId) {
        this.music = new Music(title, description, musicUrl, hqMusicUrl, thumbMediaId);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Music {
        /**
         * 音乐标题
         */
        String title;


        /**
         * 音乐描述
         */
        String description;

        /**
         * 音乐Url
         */
        @JsonProperty("musicurl")
        String musicUrl;

        /**
         * 高质量音乐链接，WIFI环境优先使用该链接播放音乐
         */
        @JsonProperty("hqmusicurl")
        String hqMusicUrl;

        /**
         * 缩略图的媒体id，通过素材管理中的接口上传多媒体文件，得到的id
         */
        @JsonProperty("thumb_media_id")
        String thumbMediaId;
    }
}
