package fan.lv.wechat.entity.open.mp.live;

import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 申请开通直播结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxApplyLiveInfoResult extends WxResult {

    /**
     * 申请动作，成功后，为 apply
     */
    String action;
}
