package fan.lv.wechat.entity.menu.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.menu.param.WxMenuParam;
import fan.lv.wechat.entity.menu.param.WxPersonalizeMenuParam;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 测试个性化菜单匹配结果
 *
 * @author lixinguo
 */
@Data
public class WxGetMenuResult extends WxResult {

    /**
     * 普通菜单
     */
    Menu menu;

    /**
     * 个性化菜单
     */
    @JsonProperty("conditionalmenu")
    List<ConditionalMenu> conditionalMenus;

    @Data
    public static class Menu {
        /**
         * 一级菜单数组，个数应为1~3个
         */
        List<WxMenuParam.Button> button;

        /**
         * 个性化菜单id
         */
        @JsonProperty("menuid")
        String menuId;
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class MatchRule extends WxPersonalizeMenuParam.MatchRule {
        /**
         * 用户分组Id
         */
        @JsonProperty("group_id")
        String groupId;
    }

    /**
     * 个性化菜单
     */
    @Data
    public static class ConditionalMenu {
        /**
         * 一级菜单数组，个数应为1~3个
         */
        List<WxMenuParam.Button> button;

        /**
         * 匹配规则
         */
        @JsonProperty("matchrule")
        MatchRule matchRule;

        /**
         * 个性化菜单id
         */
        @JsonProperty("menuid")
        String menuId;
    }
}
