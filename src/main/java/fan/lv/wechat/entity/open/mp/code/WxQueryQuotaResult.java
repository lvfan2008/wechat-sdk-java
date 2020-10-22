package fan.lv.wechat.entity.open.mp.code;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 查询服务商的当月提审限额（quota）和加急次数结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxQueryQuotaResult extends WxResult {

    /**
     * quota剩余值
     */
    Integer rest;

    /**
     * 当月分配quota
     */
    Integer limit;

    /**
     * 剩余加急次数
     */
    @JsonProperty("speedup_rest")
    Integer speedupRest;

    /**
     * 当月分配加急次数
     */
    @JsonProperty("speedup_limit")
    Integer speedupLimit;
}
