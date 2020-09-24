package fan.lv.wechat.entity.user.tag;

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
public class WxUserRemarkParam {

    /**
     * 用户标识
     */
    @JsonProperty("openid")
    String openId;

    /**
     * 新的备注名，长度必须小于30字符
     */
    String remark;
}
