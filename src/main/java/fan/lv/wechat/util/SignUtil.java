package fan.lv.wechat.util;

import fan.lv.wechat.util.crpto.AesException;
import fan.lv.wechat.util.crpto.SHA1;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author lv_fan2008
 */
public class SignUtil {
    /**
     * 生成随机串
     *
     * @return 随机串
     */
    public static String nonceStr() {
        return UUID.randomUUID().toString();
    }

    /**
     * 获取当前时间戳
     *
     * @return 时间戳
     */
    public static String timestamp() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }

    /**
     * SHA-1签名
     *
     * @param values 签名串
     * @return 摘要作为签名
     */
    public static String sha1(String... values) {
        try {
            return SHA1.getSha1(values);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 过滤空数据
     *
     * @param reqData 请求数据
     * @return 过滤的书籍
     */
    public static Map<String, String> filterBlank(Map<String, String> reqData) {
        List<String> removeKeys = new ArrayList<>();
        for (Map.Entry<String, String> entry : reqData.entrySet()) {
            if (StringUtils.isBlank(entry.getKey()) || StringUtils.isBlank(entry.getValue())) {
                removeKeys.add(entry.getKey());
            }
        }
        removeKeys.forEach(reqData::remove);
        return reqData;
    }
}
