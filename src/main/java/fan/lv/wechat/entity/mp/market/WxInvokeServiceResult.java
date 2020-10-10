package fan.lv.wechat.entity.mp.market;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 调用服务平台提供的服务结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxInvokeServiceResult extends WxResult {

    /**
     * 回包信息,JSON存储
     */
    String data;
}
