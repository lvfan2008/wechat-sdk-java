package fan.lv.wechat.entity.menu;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 创建个性化菜单结果
 *
 * @author lv_fan2008
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
