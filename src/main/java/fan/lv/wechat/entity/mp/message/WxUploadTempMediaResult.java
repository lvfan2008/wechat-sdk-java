package fan.lv.wechat.entity.mp.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 上传临时文件结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxUploadTempMediaResult extends WxResult {

    /**
     * 文件类型
     */
    String type;


    /**
     * 媒体文件上传后，获取标识，3天内有效。
     */
    @JsonProperty("media_id")
    String mediaId;

    /**
     * 媒体文件上传时间戳
     */
    @JsonProperty("created_at")
    Integer createdAt;
}
