package fan.lv.wechat.entity.open.mp.code;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 提交审核结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxSubmitCodeResult extends WxResult {

    /**
     * 审核编号
     */
    @JsonProperty("auditid")
    String auditId;
}
