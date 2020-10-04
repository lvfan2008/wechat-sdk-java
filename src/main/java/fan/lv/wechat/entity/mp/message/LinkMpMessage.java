package fan.lv.wechat.entity.mp.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 发送图文链接
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class LinkMpMessage extends BaseMpMessage {
    /**
     * 发送类型
     */
    @JsonProperty("msgtype")
    String msgType = "link";

    /**
     * 发送图文链接
     */
    Link link;

    public LinkMpMessage(String title, String description, String url, String thumbUrl) {
        this.link = new Link(title, description, url, thumbUrl);
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Link {
        /**
         * 消息标题
         */
        String title;


        /**
         * 图文链接消息
         */
        String description;

        /**
         * 图文链接消息被点击后跳转的链接
         */
        String url;

        /**
         * 图文链接消息的图片链接，支持 JPG、PNG 格式，较好的效果为大图 640 X 320，小图 80 X 80
         */
        @JsonProperty("thumb_url")
        String thumbUrl;
    }
}
