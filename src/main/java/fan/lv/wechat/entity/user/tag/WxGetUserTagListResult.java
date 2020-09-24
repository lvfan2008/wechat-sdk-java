package fan.lv.wechat.entity.user.tag;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxGetUserTagListResult extends WxResult {

    /**
     * 标签列表
     */
    @JsonProperty("tagid_list")
    List<Integer> tagIdList;
}
