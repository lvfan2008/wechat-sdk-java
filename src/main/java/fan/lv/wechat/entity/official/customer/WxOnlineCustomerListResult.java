package fan.lv.wechat.entity.official.customer;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 在线客服列表
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxOnlineCustomerListResult extends WxResult {

    /**
     * 在线客服列表
     */
    @JsonProperty("kf_online_list")
    List<OnlineCustomerInfo> kfOnlineList;


    @Data
    public static class OnlineCustomerInfo {
        /**
         * 完整客服帐号，格式为：帐号前缀@公众号微信号
         */
        @JsonProperty("kf_account")
        String kfAccount;

        /**
         * 客服在线状态，目前为：1、web 在线
         */
        @JsonProperty("status")
        Integer status;

        /**
         * 客服编号
         */
        @JsonProperty("kf_id")
        String kfId;

        /**
         * 客服当前正在接待的会话数
         */
        @JsonProperty("accepted_case")
        Integer acceptedCase;
    }

}
