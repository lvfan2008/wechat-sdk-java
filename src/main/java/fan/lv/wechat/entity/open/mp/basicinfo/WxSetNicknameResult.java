package fan.lv.wechat.entity.open.mp.basicinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 设置名称结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxSetNicknameResult extends WxResult {

    /**
     * 材料说明
     */
    @JsonProperty("wording")
    String wording;


    /**
     * 审核单 id
     */
    @JsonProperty("audit_id")
    String auditId;
}
