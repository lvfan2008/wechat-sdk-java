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
public class WxAddMaterialResult extends WxResult {
    /**
     * 媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb），图文消息（news）
     */
    String type;

    /**
     * 媒体文件/图文消息上传后获取的唯一标识
     */
    @JsonProperty("media_id")
    String mediaId;

    /**
     * 媒体文件上传时间
     */
    @JsonProperty("created_at")
    Integer createAt;
}
