package fan.lv.wechat.entity.official.server.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 图片消息
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@XStreamAlias("xml")
@Data
public class CommonImageMessage extends BaseCommonMessage {
    /**
     * 消息类型
     */
    @XStreamAlias("MsgType")
    String msgType = "image";

    /**
     * 图片链接（由系统生成）
     */
    @XStreamAlias("PicUrl")
    String picUrl;

    /**
     * 图片消息媒体id，可以调用获取临时素材接口拉取数据。
     */
    @XStreamAlias("MediaId")
    String mediaId;
}
