package fan.lv.wechat.entity.official.server.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 位置消息
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@XStreamAlias("xml")
@Data
public class CommonLocationMessage extends BaseCommonMessage {

    /**
     * 消息类型
     */
    @XStreamAlias("MsgType")
    @JsonProperty("MsgType")
    String msgType = "location";

    /**
     * 地理位置纬度
     */
    @XStreamAlias("Location_X")
    @JsonProperty("Location_X")
    Double locationX;

    /**
     * 地理位置经度
     */
    @XStreamAlias("Location_Y")
    @JsonProperty("Location_Y")
    Double locationY;

    /**
     * 地图缩放大小
     */
    @XStreamAlias("Scale")
    @JsonProperty("Scale")
    Double scale;

    /**
     * 地理位置信息
     */
    @XStreamAlias("Label")
    @JsonProperty("Label")
    String label;
}
