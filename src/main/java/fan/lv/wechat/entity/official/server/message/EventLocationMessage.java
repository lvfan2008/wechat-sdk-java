package fan.lv.wechat.entity.official.server.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 上报地理位置事件
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@XStreamAlias("xml")
@Data
public class EventLocationMessage extends BaseEventMessage {
    /**
     * 事件类型
     */
    @XStreamAlias("Event")
    String event = "LOCATION";

    /**
     * 地理位置纬度
     */
    @XStreamAlias("Latitude")
    String latitude;


    /**
     * 地理位置经度
     */
    @XStreamAlias("Longitude")
    String longitude;

    /**
     * 地理位置精度
     */
    @XStreamAlias("Precision")
    String precision;
}
