package fan.lv.wechat.entity.menu;

import fan.lv.wechat.entity.menu.WxMenuParam;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 测试个性化菜单匹配结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxTryMatchPersonalizeMenuResult extends WxResult {
    /**
     * 一级菜单数组，个数应为1~3个
     */
    List<WxMenuParam.Button> button;
}
