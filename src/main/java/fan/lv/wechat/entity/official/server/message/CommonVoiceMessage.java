package fan.lv.wechat.entity.official.server.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 语音消息
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@XStreamAlias("xml")
@Data
public class CommonVoiceMessage extends BaseCommonMessage {

    /**
     * 消息类型
     */
    @XStreamAlias("MsgType")
    String msgType = "voice";

    /**
     * 语音格式，如amr，speex等
     */
    @XStreamAlias("Format")
    String format;

    /**
     * 语音消息媒体id，可以调用获取临时素材接口拉取数据。
     */
    @XStreamAlias("MediaId")
    String mediaId;

    /**
     * 语音识别结果，UTF8编码，开启语音识别后会有此字段
     */
    @XStreamAlias("Recognition")
    String recognition;
}
