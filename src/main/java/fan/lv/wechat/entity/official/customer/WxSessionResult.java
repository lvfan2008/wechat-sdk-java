package fan.lv.wechat.entity.official.customer;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 客户会话状态
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxSessionResult extends WxResult {
    /**
     * 正在接待的客服，为空表示没有人在接待
     */
    @JsonProperty("kf_account")
    String kfAccount;

    /**
     * 会话接入的时间
     */
    @JsonProperty("createtime")
    String createTime;
}
