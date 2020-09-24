package fan.lv.wechat.entity.result;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.InputStream;

/**
 * @author lv_fan2008
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WxResult {

    /**
     * 错误码
     */
    @JsonProperty("errcode")
    Integer errorCode = 0;

    /**
     * 错误消息
     */
    @JsonProperty("errmsg")
    String errorMessage = "";

    /**
     * 是否为原始流
     */
    Boolean isRawStream = false;

    /**
     * 是否为原始流
     *
     * @return 是否为原始流
     */
    Boolean getIsRawStream() {
        return isRawStream != null || isRawStream;
    }

    /**
     * 原始流的内容类型：Content-Type
     */
    String contentType;

    /**
     * 原始流的文件名：Content-disposition:attachment; filename=xxxx.jpg
     */
    String filename;

    /**
     * 原始流
     */
    @JsonIgnore
    InputStream content;

    /**
     * 原始流长度
     */
    Long length;

    /**
     * 结果是否成功
     *
     * @return 是否成功
     */
    public Boolean success() {
        return errorCode == 0;
    }

}
