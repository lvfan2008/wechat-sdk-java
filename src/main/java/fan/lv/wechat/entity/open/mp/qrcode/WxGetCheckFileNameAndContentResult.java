package fan.lv.wechat.entity.open.mp.qrcode;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 获取校验文件名称及内容结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxGetCheckFileNameAndContentResult extends WxResult {

    /**
     * 文件名称
     */
    @JsonProperty("file_name")
    String fileName;

    /**
     * 文件内容
     */
    @JsonProperty("file_content")
    String fileContent;
}
