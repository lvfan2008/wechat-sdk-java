package fan.lv.wechat.entity.mp.soter;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * SOTER 生物认证秘钥签名验证结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxVerifySignatureResult extends WxResult {

    /**
     * 媒体文件上传后，获取标识，3天内有效。
     */
    @JsonProperty("is_ok")
    String isOk;
}
