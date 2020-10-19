package fan.lv.wechat.entity.open.open.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lv_fan2008
 */
@Data
public class WxBaseMessage {
    /**
     * 支付Xml转为的map
     */
    @XStreamOmitField
    Map<String, String> mapResult = new HashMap<>();

    /**
     * 请求应答map的key对应值，结果中没有的属性，可以通过此接口查询到
     *
     * @param key 结果key值
     * @return 结果value值
     */
    public String get(String key) {
        return mapResult.get(key);
    }


    /**
     * 第三方平台 appid
     */
    @XStreamAlias("AppId")
    String appId;

    /**
     * 时间戳
     */
    @XStreamAlias("CreateTime")
    Integer createTime;

    /**
     * 通知类型，详见InfoType 说明
     */
    @XStreamAlias("InfoType")
    String infoType;
}
