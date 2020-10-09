package fan.lv.wechat.entity.official.server.message;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("Event")
    String event = "LOCATION";

    /**
     * 地理位置纬度
     */
    @XStreamAlias("Latitude")
    @JsonProperty("Latitude")
    String latitude;


    /**
     * 地理位置经度
     */
    @XStreamAlias("Longitude")
    @JsonProperty("Longitude")
    String longitude;

    /**
     * 地理位置精度
     */
    @XStreamAlias("Precision")
    @JsonProperty("Precision")
    String precision;
}
