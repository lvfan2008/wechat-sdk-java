package fan.lv.wechat.util.pay;

/**
 * 常量
 */
public class WxPayConstants {

    public enum SignType {
        /**
         * md5
         */
        MD5,
        /**
         * hmacsha256
         */
        HMACSHA256
    }

    public static final String FAIL = "FAIL";
    public static final String SUCCESS = "SUCCESS";
    public static final String HMACSHA256 = "HMAC-SHA256";
    public static final String MD5 = "MD5";

    public static final String FIELD_SIGN = "sign";
    public static final String FIELD_SIGN_TYPE = "sign_type";

}

