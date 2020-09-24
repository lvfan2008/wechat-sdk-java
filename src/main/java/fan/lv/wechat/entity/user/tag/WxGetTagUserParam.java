package fan.lv.wechat.entity.user.tag;

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
public class WxGetTagUserParam {
    /**
     * 标签Id
     */
    @JsonProperty("tagid")
    Integer tagId;

    /**
     * 第一个拉取的OPENID，不填默认从头开始拉取 }
     */
    @JsonProperty("next_openid")
    String nextOpenId;
}
