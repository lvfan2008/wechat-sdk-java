package fan.lv.wechat.entity.asset;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.message.mass.base.WxNewsBase;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 获取永久素材，如果为图文素材或者视频，返回json信息，否则返回原始流
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxGetMaterialResult extends WxResult {

    /**
     * 图文素材
     */
    @JsonProperty("news_item")
    List<News> newsItem;

    /**
     * 视频标题
     */
    String title;

    /**
     * 视频描述
     */
    String description;

    /**
     * 视频下载Url
     */
    String downUrl;

    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class News extends WxNewsBase {
        /**
         * 图文页的URL
         */
        String url;
    }
}
