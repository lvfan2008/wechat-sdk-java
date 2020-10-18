package fan.lv.wechat.entity.result;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import fan.lv.wechat.util.SimpleHttpResp;
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
    Integer errorCode = 0;

    /**
     * 错误消息
     */
    @JsonProperty("errmsg")
    String errorMessage = "";

    /**
     * Http应答
     */
    @JsonIgnore
    SimpleHttpResp httpResp;

    /**
     * 结果是否成功
     *
     * @return 是否成功
     */
    public Boolean success() {
        return getErrorCode() == 0;
    }
}
