package fan.lv.wechat.entity.official.message.mass.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 基础图文消息
 *
 * @author lv_fan2008
 */
@Data
public class WxNewsBase {
    /**
     * 图文消息缩略图的media_id，可以在素材管理-新增素材中获得
     */
    @JsonProperty("thumb_media_id")
    String thumbMediaId;

    /**
     * 图文消息的作者
     */
    String author;

    /**
     * 图文消息的标题
     */
    String title;

    /**
     * 在图文消息页面点击“阅读原文”后的页面，受安全限制，如需跳转Appstore，可以使用itun.es或appsto.re的短链服务，
     * 并在短链后增加 #wechat_redirect 后缀。
     */
    @JsonProperty("content_source_url")
    String contentSourceUrl;

    /**
     * 图文消息页面的内容，支持HTML标签。具备微信支付权限的公众号，可以使用a标签，其他公众号不能使用，如需插入小程序卡片，可参考下文。
     */
    String content;

    /**
     * 图文消息的描述，如本字段为空，则默认抓取正文前64个字
     */
    String digest;

    /**
     * 是否显示封面，1为显示，0为不显示
     */
    @JsonProperty("show_cover_pic")
    Integer showCoverPic = 0;
}
