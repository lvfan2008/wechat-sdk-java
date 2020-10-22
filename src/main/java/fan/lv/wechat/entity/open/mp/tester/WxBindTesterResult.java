package fan.lv.wechat.entity.open.mp.tester;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 绑定微信用户为体验者结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxBindTesterResult extends WxResult {

    /**
     * 人员对应的唯一字符串
     */
    @JsonProperty("userstr")
    String userStr;
}
