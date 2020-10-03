package fan.lv.wechat.entity.official.jssdk;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author lv_fan2008
 */
@Data
public class WxCardExt {
    /**
     * 随机字符串，由开发者设置传入， 加强安全性（若不填写可能被重放请求） 。随机字符串，不长于32位。
     */
    @JsonProperty("nonce_str")
    String nonceStr;

    /**
     * 时间戳，商户生成从1970年1月1日00:00:00至今的秒数,即当前的时间,且最终需要转换为字符串形式;
     */
    String timestamp;

    /**
     * 指定的卡券code码，只能被领一次。自定义code模式的卡券必须填写，非自定义code和预存code模式的卡券不必填写。
     */
    String code;


    /**
     * 指定领取者的openid，只有该用户能领取。bind_openid字段为true的卡券必须填写，bind_openid字段为false不必填写。
     */
    @JsonProperty("openid")
    String openId = "";


    /**
     * 卡券在第三方系统的实际领取时间，为东八区时间戳（UTC+8,精确到秒）。当卡券的有效期类型为 DAT E_TYPE_FIX_TERM时专用，
     * 标识卡券的实际生效时间，用于解决商户系统内起始时间和领取时间不同步的问题。
     */
    @JsonProperty("fixed_begintimestamp")
    String fixedBeginTimestamp;

    /**
     * 领取渠道参数，用于标识本次领取的渠道值。
     */
    @JsonProperty("outer_str")
    String outerStr;

    /**
     * 签名
     */
    String signature;
}
