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
public class MiniProgramPageMpMessage extends BaseMpMessage {
    /**
     * 发送类型
     */
    @JsonProperty("msgtype")
    String msgType = "miniprogrampage";

    /**
     * 图片
     */
    MiniProgramPage miniProgramPage;

    /**
     * 构建小程序跳转页消息
     *
     * @param title        小程序标题
     * @param pagePath     小程序的页面路径，跟app.json对齐，支持参数，比如pages/index/index?foo=bar
     * @param thumbMediaId 缩略图的媒体id，通过素材管理中的接口上传多媒体文件，得到的id
     */
    public MiniProgramPageMpMessage(String title, String pagePath, String thumbMediaId) {
        this.miniProgramPage = new MiniProgramPage(title, pagePath, thumbMediaId);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MiniProgramPage {
        /**
         * 小程序标题
         */
        String title;

        /**
         * 小程序的页面路径，跟app.json对齐，支持参数，比如pages/index/index?foo=bar
         */
        @JsonProperty("appid")
        String pagePath;


        /**
         * 缩略图的媒体id，通过素材管理中的接口上传多媒体文件，得到的id
         */
        @JsonProperty("thumb_media_id")
        String thumbMediaId;
    }
}
