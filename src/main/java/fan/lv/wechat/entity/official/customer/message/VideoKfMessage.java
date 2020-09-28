package fan.lv.wechat.entity.official.customer.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thoughtworks.xstream.annotations.XStreamAlias;
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
public class VideoKfMessage extends BaseKfMessage {
    /**
     * 发送类型
     */
    @JsonProperty("msgtype")
    String msgType = "video";

    /**
     * 图片
     */
    Video video;

    /**
     * 构造视频消息
     *
     * @param mediaId      媒体文件Id
     * @param thumbMediaId 缩略图媒体文件Id
     * @param title        视频消息的标题
     * @param description  视频消息的描述
     */
    public VideoKfMessage(String mediaId, String thumbMediaId, String title, String description) {
        this.video = new Video(mediaId, thumbMediaId, title, description);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Video {
        /**
         * 媒体文件Id
         */
        @JsonProperty("media_id")
        String mediaId;

        /**
         * 缩略图媒体文件Id
         */
        @JsonProperty("thumb_media_id")
        String thumbMediaId;

        /**
         * 视频消息的标题
         */
        String title;


        /**
         * 视频消息的描述
         */
        String description;
    }
}
