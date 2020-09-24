package fan.lv.wechat.entity.official.menu;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 查询菜单结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxQueryMenuResult extends WxResult {

    /**
     * 菜单是否开启，0代表未开启，1代表开启
     */
    @JsonProperty("is_menu_open")
    Integer isMenuOpen;

    /**
     * 菜单信息
     */
    @JsonProperty("selfmenu_info")
    SelfMenuInfo selfMenuInfo;

    @Data
    public static class SelfMenuInfo {
        /**
         * 按钮菜单
         */
        List<Button> button;
    }


    @Data
    public static class Button {
        /**
         * 菜单的类型，公众平台官网上能够设置的菜单类型有view（跳转网页）、text（返回文本，下同）、
         * img、photo、video、voice。使用API设置的则有8种，详见《自定义菜单创建接口》
         */
        String type;

        /**
         * 菜单名称
         */
        String name;

        /**
         * 对于不同的菜单类型，value的值意义不同。官网上设置的自定义菜单： Text:保存文字到value；
         * Img、voice：保存mediaID到value； Video：保存视频下载链接到value；
         * News：保存图文消息到news_info，同时保存mediaID到value；
         * View：保存链接到url。
         * 使用API设置的自定义菜单： click、scancode_push、
         * scancode_waitmsg、pic_sysphoto、pic_photo_or_album、
         * pic_weixin、location_select：
         * 保存值到key；view：保存链接到url
         */
        String value;

        /**
         * 对于不同的菜单类型，value的值意义不同。官网上设置的自定义菜单： Text:保存文字到value；
         * Img、voice：保存mediaID到value； Video：保存视频下载链接到value；
         * News：保存图文消息到news_info，同时保存mediaID到value；
         * View：保存链接到url。
         * 使用API设置的自定义菜单： click、scancode_push、
         * scancode_waitmsg、pic_sysphoto、pic_photo_or_album、
         * pic_weixin、location_select：
         * 保存值到key；view：保存链接到url
         */
        String key;

        /**
         * API设置的自定义菜单,view：保存链接到url
         */
        String url;

        /**
         * 子菜单
         */
        @JsonProperty("sub_button")
        ButtonList subButton;

        /**
         * 图文消息的信息
         */
        @JsonProperty("news_info")
        NewsInfo newsInfo;
    }

    @Data
    public static class ButtonList {
        List<Button> list;
    }

    @Data
    public static class NewsInfo {
        List<News> list;
    }

    @Data
    public static class News {
        /**
         * 图文消息的标题
         */
        String title;

        /**
         * 作者
         */
        String author;

        /**
         * 摘要
         */
        String digest;

        /**
         * 是否显示封面，0为不显示，1为显示
         */
        @JsonProperty("show_cover")
        Integer showCover;

        /**
         * 封面图片的URL
         */
        @JsonProperty("cover_url")
        String coverUrl;

        /**
         * 正文的URL
         */
        @JsonProperty("content_url")
        String contentUrl;

        /**
         * 原文的URL，若置空则无查看原文入口
         */
        @JsonProperty("source_url")
        String sourceUrl;
    }
}
