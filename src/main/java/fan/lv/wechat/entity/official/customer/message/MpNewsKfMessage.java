package fan.lv.wechat.entity.official.customer.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 发送图文消息（点击跳转到图文消息页面） 图文消息条数限制在1条以内，注意，如果图文数超过1，则将会返回错误码45008。
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class MpNewsKfMessage extends BaseKfMessage {
    /**
     * 发送类型
     */
    @JsonProperty("msgtype")
    String msgType = "voice";

    /**
     * 图文消息
     */
    @JsonProperty("mpnews")
    MpNews mpNews;

    public MpNewsKfMessage(String mediaId) {
        this.mpNews = new MpNews(mediaId);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MpNews {
        /**
         * 媒体文件Id
         */
        @JsonProperty("media_id")
        String mediaId;
    }
}
