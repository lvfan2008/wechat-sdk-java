package fan.lv.wechat.entity.result;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

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
    @XStreamOmitField
    Integer errorCode = 0;

    /**
     * 错误消息
     */
    @JsonProperty("errmsg")
    @XStreamOmitField
    String errorMessage = "";

    /**
     * 是否为原始流
     */
    @XStreamOmitField
    Boolean isRawStream = false;

    /**
     * 原始流的文件名：Content-disposition:attachment; filename=xxxx.jpg
     */
    @XStreamOmitField
    String filename;

    /**
     * 字符集
     */
    @XStreamOmitField
    String charset;

    /**
     * 原始流，最大长度Integer.MAX_VALUE
     */
    @JsonIgnore
    @XStreamOmitField
    byte[] content;

    /**
     * 结果是否成功
     *
     * @return 是否成功
     */
    public Boolean success() {
        return getErrorCode() == 0;
    }

    /**
     * 文本时，可以取对应的内容
     *
     * @return 内容
     */
    public String content() {
        Charset cs = charset == null ? Charset.defaultCharset() : Charset.forName(charset);
        return new String(content, cs);
    }
}
