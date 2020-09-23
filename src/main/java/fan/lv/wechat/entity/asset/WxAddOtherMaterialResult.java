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
public class WxAddOtherMaterialResult extends WxResult {
    /**
     * 新增的永久素材的media_id
     */
    @JsonProperty("media_id")
    String mediaId;

    /**
     * 新增的图片素材的图片URL（仅新增图片素材时会返回该字段）
     */
    String url;
}
