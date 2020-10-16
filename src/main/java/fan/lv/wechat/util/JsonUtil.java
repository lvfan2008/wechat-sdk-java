package fan.lv.wechat.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * Json工具
 *
 * @author lv_fan2008
 */
public class JsonUtil {

    /**
     * 转换为json字符串
     *
     * @param object 对象
     * @return json字符串
     */
    public static String toJson(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            // 不序列号空值
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Json转换为对象
     *
     * @param json       json字符串
     * @param resultType 转为类型
     * @param <T>        类型模板
     * @return Json对象
     */
    public static <T> T parseJson(String json, Class<T> resultType) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            return mapper.readValue(json, resultType);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Json转换为对象
     *
     * @param json          json字符串
     * @param typeReference 转为类型，可以使用泛型，例：new TypeReference<List<String>>(){}
     * @param <T>           类型模板
     * @return Json对象
     */
    public static <T> T parseJson(String json, TypeReference<T> typeReference) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            return mapper.readValue(json, typeReference);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
