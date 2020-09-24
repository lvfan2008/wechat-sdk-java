package fan.lv.wechat.entity.user.tag;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author lv_fan2008
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WxBatchTagParam {
    /**
     * OpenId列表
     */
    @JsonProperty("openid_list")
    List<String> openIdList;

    /**
     * 标签Id
     */
    @JsonProperty("tagid")
    Integer tagId;
}
