package fan.lv.wechat.entity.comment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lv_fan2008
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WxOpenCommentParam {
    /**
     * 群发返回的msg_data_id
     */
    @JsonProperty("msg_data_id")
    Integer msgDataId;

    /**
     * 多图文时，用来指定第几篇图文，从0开始，不带默认操作该msg_data_id的第一篇图文
     */
    Integer index;
}
