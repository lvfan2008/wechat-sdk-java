package fan.lv.wechat.entity.mp.message.base;

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
public class ImageMpMessage extends BaseMpMessage {
    /**
     * 发送类型
     */
    @JsonProperty("msgtype")
    String msgType = "image";

    /**
     * 图片
     */
    Image image;

    public ImageMpMessage(String mediaId) {
        this.image = new Image(mediaId);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Image {
        /**
         * 媒体文件Id
         */
        @JsonProperty("media_id")
        String mediaId;
    }
}
