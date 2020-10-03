package fan.lv.wechat.util;

import fan.lv.wechat.util.crpto.SHA1;

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
     * @param str 签名串
     * @return 摘要作为签名
     */
    public static String sha1(String str) {
        try {
            return SHA1.getSha1(str);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
