package fan.lv.wechat.entity.base;

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
public class WxClearQuotaParam {
    /**
     * 公众号的APPID
     */
    @JsonProperty("appid")
    String appId;
}
