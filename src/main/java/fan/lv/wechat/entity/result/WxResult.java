package fan.lv.wechat.entity.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.http.HttpEntity;

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
     * 原始流
     */
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

    /**
     * 转为json类型
     *
     * @return json字符串
     * @throws JsonProcessingException json处理异常
     */
    public String toJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }

    /**
     * 转换为子类型
     *
     * @param json       json字符串
     * @param resultType 子类型
     * @param <T>        结果类型模板
     * @return json结果
     */
    public static <T extends WxResult> T parseJson(String json, Class<T> resultType) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            return mapper.readValue(json, resultType);
        } catch (JsonProcessingException e) {
            T result = null;
            try {
                result = resultType.newInstance();
                result.setErrorCode(-2);
                result.setErrorMessage(e.getMessage());
                return result;
            } catch (Exception exception) {
                throw new RuntimeException(exception.getMessage());
            }
        }
    }

}
