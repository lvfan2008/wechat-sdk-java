package fan.lv.wechat.entity.open.mp.code;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 获取已上传的代码的页面列表结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxGetPageListResult extends WxResult {

    /**
     * page_list 页面配置列表
     */
    @JsonProperty("page_list")
    List<String> pageList;
}
