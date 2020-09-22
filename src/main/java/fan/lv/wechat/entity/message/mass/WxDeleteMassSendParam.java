package fan.lv.wechat.entity.message.mass;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author lv_fan2008
 */
@Data
public class WxDeleteMassSendParam {
    /**
     * 发送出去的消息ID
     */
    @JsonProperty("msg_id")
    Integer msgId;

    /**
     * 要删除的文章在图文消息中的位置，第一篇编号为1，该字段不填或填0会删除全部文章
     */
    @JsonProperty("article_idx")
    Integer articleIdx = 0;
}
