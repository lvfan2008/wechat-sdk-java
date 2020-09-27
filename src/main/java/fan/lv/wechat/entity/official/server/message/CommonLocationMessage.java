package fan.lv.wechat.entity.official.server.message;

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
    String msgType = "location";

    /**
     * 地理位置纬度
     */
    @XStreamAlias("Location_X")
    Double locationX;

    /**
     * 地理位置经度
     */
    @XStreamAlias("Location_Y")
    Double locationY;

    /**
     * 地图缩放大小
     */
    @XStreamAlias("Scale")
    Double scale;

    /**
     * 地理位置信息
     */
    @XStreamAlias("Label")
    String label;
}
