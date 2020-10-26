package fan.lv.wechat.entity.open.mp.live;

import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 创建直播间结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxCreateLiveRoomResult extends WxResult {

    /**
     * 房间ID
     */
    Integer roomId;
}
