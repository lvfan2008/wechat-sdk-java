package fan.lv.wechat.entity.mp.security;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 异步校验图片/音频是否含有违法违规内容
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxMediaCheckAsyncResult extends WxResult {

    /**
     * 任务id，用于匹配异步推送结果
     */
    @JsonProperty("trace_id")
    String traceId;
}
