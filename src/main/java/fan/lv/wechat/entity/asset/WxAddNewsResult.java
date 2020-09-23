package fan.lv.wechat.entity.asset;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxAddNewsResult extends WxResult {
    /**
     * 媒体文件/图文消息上传后获取的唯一标识
     */
    @JsonProperty("media_id")
    String mediaId;
}
