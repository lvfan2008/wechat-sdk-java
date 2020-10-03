package fan.lv.wechat.entity.official.jssdk;

import lombok.Data;

import java.util.List;

/**
 * @author lv_fan2008
 */
@Data
public class WxJsConfig {
    Boolean debug = false;
    String appId;
    String timestamp;
    String nonceStr;
    String signature;
    List<String> jsApiList;
}
