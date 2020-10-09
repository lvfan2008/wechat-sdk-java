package fan.lv.wechat.entity.official.server.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 小视频消息
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@XStreamAlias("xml")
@Data
public class CommonShortVideoMessage extends BaseCommonMessage {

    /**
     * 消息类型
     */
    @XStreamAlias("MsgType")
    @JsonProperty("MsgType")
    String msgType = "shortvideo";

    /**
     * 视频消息媒体id，可以调用获取临时素材接口拉取数据。
     */
    @XStreamAlias("MediaId")
    @JsonProperty("MediaId")
    String mediaId;

    /**
     * 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
     */
    @XStreamAlias("ThumbMediaId")
    @JsonProperty("ThumbMediaId")
    String thumbMediaId;
}
