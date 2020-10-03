package fan.lv.wechat.entity.official.jssdk;

import lombok.Data;

import java.util.List;

/**
 * @author lv_fan2008
 */
@Data
public class WxJsConfig {
    /**
     * 是否开启调试模式
     */
    Boolean debug = false;

    /**
     * 公众号appId
     */
    String appId;

    /**
     * 生成签名所用时间戳
     */
    String timestamp;

    /**
     * 生成签名所用随机串
     */
    String nonceStr;

    /**
     * 签名
     */
    String signature;

    /**
     * 需要使用的JS接口列表
     */
    List<String> jsApiList;

    /**
     * 需要使用的开放标签列表，可选
     */
    List<String> openTagList;
}
