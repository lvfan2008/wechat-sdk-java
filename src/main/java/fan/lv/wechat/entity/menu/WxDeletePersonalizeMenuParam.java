package fan.lv.wechat.entity.menu;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 *
 * @author lv_fan2008
 */
@Data
public class WxDeletePersonalizeMenuParam {
    /**
     * 菜单Id
     */
    @JsonProperty("menuid")
    String menuId;
}
