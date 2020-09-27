package fan.lv.wechat.entity.official.server.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.*;

/**
 * 回复视频消息
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@XStreamAlias("xml")
@Data
@NoArgsConstructor
public class ReplyVideoMessage extends BaseReplyMessage {

    /**
     * 消息类型
     */
    @XStreamAlias("MsgType")
    String msgType = "video";

    /**
     * 图片
     */
    @XStreamAlias("Video")
    Video video;

    public ReplyVideoMessage(String mediaId, String title, String description) {
        this.video = new Video(mediaId, title, description);
    }

    @XStreamAlias("Video")
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Video {
        /**
         * 通过素材管理中的接口上传多媒体文件，得到的id
         */
        @XStreamAlias("MediaId")
        String mediaId;

        /**
         * 视频消息的标题
         */
        @XStreamAlias("Title")
        String title;


        /**
         * 视频消息的描述
         */
        @XStreamAlias("Description")
        String description;
    }
}
