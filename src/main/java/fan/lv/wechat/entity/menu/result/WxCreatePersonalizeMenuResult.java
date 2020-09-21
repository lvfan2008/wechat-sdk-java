package fan.lv.wechat.entity.menu.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.menu.param.WxMenuParam;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 创建个性化菜单结果
 *
 * @author lixinguo
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxCreatePersonalizeMenuResult extends WxResult {
    /**
     * 菜单Id
     */
    @JsonProperty("menuid")
    String menuId;
}
