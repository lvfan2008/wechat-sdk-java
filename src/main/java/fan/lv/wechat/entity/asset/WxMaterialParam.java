package fan.lv.wechat.entity.asset;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lv_fan2008
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WxMaterialParam {
    /**
     * 永久素材的media_id
     */
    @JsonProperty("media_id")
    String mediaId;

}
