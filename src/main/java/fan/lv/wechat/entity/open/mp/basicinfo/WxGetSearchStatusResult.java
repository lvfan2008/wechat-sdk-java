package fan.lv.wechat.entity.open.mp.basicinfo;

import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 查询隐私设置结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxGetSearchStatusResult extends WxResult {

    /**
     * 1 表示不可搜索，0 表示可搜索
     */
    Integer status;
}
