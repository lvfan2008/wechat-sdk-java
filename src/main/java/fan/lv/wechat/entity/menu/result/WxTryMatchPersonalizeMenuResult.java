package fan.lv.wechat.entity.menu.result;

import fan.lv.wechat.entity.menu.param.WxMenuParam;
import fan.lv.wechat.entity.result.WxResult;

import java.util.List;

/**
 * 测试个性化菜单匹配结果
 *
 * @author lixinguo
 */
public class WxTryMatchPersonalizeMenuResult extends WxResult {
    /**
     * 一级菜单数组，个数应为1~3个
     */
    List<WxMenuParam.Button> button;
}
