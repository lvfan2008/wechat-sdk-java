package fan.lv.wechat.entity.open.mp.code;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 查询指定发布审核单的审核状态结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxGetAuditStatusResult extends WxResult {

    /**
     * 审核状态
     * 0	审核成功
     * 1	审核被拒绝
     * 2	审核中
     * 3	已撤回
     * 4	审核延后
     */
    Integer status;

    /**
     * 当 status = 1 时，返回的拒绝原因; status = 4 时，返回的延后原因
     */
    String reason;

    /**
     * 当 status = 1 时，会返回审核失败的小程序截图示例。用 | 分隔的 media_id 的列表
     */
    @JsonProperty("screenshot")
    String screenShot;
}
