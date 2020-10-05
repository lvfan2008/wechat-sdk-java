package fan.lv.wechat.entity.mp.subscribe;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 添加模板结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxAddTemplateResult extends WxResult {

    /**
     * 添加至帐号下的模板id，发送小程序订阅消息时所需
     */
    String priTmplId;
}
