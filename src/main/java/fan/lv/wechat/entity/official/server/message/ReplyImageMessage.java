package fan.lv.wechat.entity.official.server.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.*;

/**
 * 回复图片消息
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@XStreamAlias("xml")
@Data
@NoArgsConstructor
public class ReplyImageMessage extends BaseReplyMessage {

    /**
     * 消息类型
     */
    @XStreamAlias("MsgType")
    @JsonProperty("MsgType")
    String msgType = "image";

    /**
     * 图片
     */
    @XStreamAlias("Image")
    @JsonProperty("Image")
    Image image;


    public ReplyImageMessage(String mediaId) {
        this.image = new Image(mediaId);
    }

    @XStreamAlias("Image")
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Image {
        /**
         * 图片消息媒体id，可以调用获取临时素材接口拉取数据。
         */
        @XStreamAlias("MediaId")
        @JsonProperty("MediaId")
        String mediaId;
    }
}
