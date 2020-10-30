package fan.lv.wechat.entity.open.mp.live;

import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 上重新提交审核结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxReAuditResult extends WxResult {

    /**
     * 审核单ID
     */
    Integer auditId;
}
