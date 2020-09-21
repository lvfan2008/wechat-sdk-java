package fan.lv.wechat.entity.message.customservice;

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
public class WxDeleteCustomerServiceAccountParam {
    /**
     * 客服账号
     */
    @JsonProperty("kf_account")
    String account;
}
