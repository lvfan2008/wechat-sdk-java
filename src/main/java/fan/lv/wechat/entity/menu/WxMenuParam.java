package fan.lv.wechat.entity.menu;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author lv_fan2008
 */
@Data
public class WxMenuParam {
    /**
     * 一级菜单数组，个数应为1~3个
     */
    List<Button> button;

    @Data
    public static class Button {
        /**
         * 菜单的响应动作类型，view表示网页类型，click表示点击类型，miniprogram表示小程序类型
         */
        String type;

        /**
         * 菜单标题，不超过16个字节，子菜单不超过60个字节
         */
        String name;

        /**
         * click等点击类型必须, 菜单KEY值，用于消息接口推送，不超过128字节
         */
        String key;

        /**
         * view、miniprogram类型必须, 网页 链接，用户点击菜单可打开链接，不超过1024字节。 type为miniprogram时，
         * 不支持小程序的老版本客户端将打开本url。
         */
        String url;

        /**
         * media_id类型和view_limited类型必须, 调用新增永久素材接口返回的合法media_id
         */
        @JsonProperty("media_id")
        String mediaId;

        /**
         * miniprogram类型必须, 小程序的appid（仅认证公众号可配置）
         */
        @JsonProperty("appid")
        String appId;

        /**
         * miniprogram类型必须, 小程序的页面路径
         */
        @JsonProperty("pagepath")
        String pagePath;

        /**
         * 二级菜单数组，个数应为1~5个
         */
        @JsonProperty("sub_button")
        List<Button> subButton;
    }
}
