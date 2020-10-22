package fan.lv.wechat.entity.open.mp.basicinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 查询改名审核状态结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxQueryNicknameAuditResult extends WxResult {

    /**
     * 审核昵称
     */
    @JsonProperty("nickname")
    String nickname;

    /**
     * 审核状态，1：审核中，2：审核失败，3：审核成功
     */
    @JsonProperty("audit_stat")
    Integer auditStat;

    /**
     * 失败原因
     */
    @JsonProperty("fail_reason")
    String failReason;

    /**
     * 审核提交时间
     */
    @JsonProperty("create_time")
    Integer createTime;

    /**
     * 审核完成时间
     */
    @JsonProperty("audit_time")
    Integer auditTime;
}
