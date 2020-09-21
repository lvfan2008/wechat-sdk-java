package fan.lv.wechat.entity.menu.param;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 *
 * @author lixinguo
 */
@Data
public class WxDeletePersonalizeMenuParam {
    /**
     * 菜单Id
     */
    @JsonProperty("menuid")
    String menuId;
}
