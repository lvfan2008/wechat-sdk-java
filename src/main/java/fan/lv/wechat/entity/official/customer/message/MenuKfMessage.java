package fan.lv.wechat.entity.official.customer.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class MenuKfMessage extends BaseKfMessage {
    /**
     * 发送类型
     */
    @JsonProperty("msgtype")
    String msgType = "msgmenu";

    /**
     * 发送的图文消息
     */
    MsgMenu msgMenu;

    /**
     * 构造菜单消息
     *
     * @param headContent 菜单头部信息
     * @param tailContent 菜单尾部信息
     * @param list        菜单列表
     */
    public MenuKfMessage(String headContent, String tailContent, List<Menu> list) {
        this.msgMenu = new MsgMenu(headContent, tailContent, list);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MsgMenu {
        /**
         * 菜单头部信息
         */
        @JsonProperty("head_content")
        String headContent;

        /**
         * 菜单尾部信息
         */
        @JsonProperty("head_content")
        String tailContent;

        /**
         * 菜单列表
         */
        List<Menu> list;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Menu {
        /**
         * 菜单Id
         */
        String id;


        /**
         * 菜单内容
         */
        String content;
    }
}
