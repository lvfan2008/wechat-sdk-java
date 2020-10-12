package fan.lv.wechat.entity.result;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.InputStream;

/**
 * @author lv_fan2008
 */
@Data
public class WxBaseResult {

    /**
     * 是否为原始流
     */
    @JsonIgnore
    @XStreamOmitField
    Boolean isRawStream = false;

    /**
     * 原始流的内容类型：Content-Type
     */
    @JsonIgnore
    @XStreamOmitField
    String contentType;

    /**
     * 原始流的文件名：Content-disposition:attachment; filename=xxxx.jpg
     */
    @JsonIgnore
    @XStreamOmitField
    String filename;

    /**
     * 原始流
     */
    @JsonIgnore
    @XStreamOmitField
    InputStream content;

    /**
     * 原始流长度
     */
    @JsonIgnore
    @XStreamOmitField
    Long length;
}
