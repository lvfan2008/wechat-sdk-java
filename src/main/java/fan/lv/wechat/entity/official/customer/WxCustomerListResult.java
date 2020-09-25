package fan.lv.wechat.entity.official.customer;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 客服基本信息
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxCustomerListResult extends WxResult {

    /**
     * 客服列表
     */
    @JsonProperty("kf_list")
    List<CustomerInfo> kfList;


    @Data
    public static class CustomerInfo{
        /**
         * 完整客服帐号，格式为：帐号前缀@公众号微信号
         */
        @JsonProperty("kf_account")
        String kfAccount;

        /**
         * 客服头像
         */
        @JsonProperty("kf_headimgurl")
        String kfHeadImgUrl;

        /**
         * 客服编号
         */
        @JsonProperty("kf_id")
        String kfId;

        /**
         * 如果客服帐号已绑定了客服人员微信号， 则此处显示微信号
         */
        @JsonProperty("kf_wx")
        String kfWx;

        /**
         * 客服昵称
         */
        @JsonProperty("kf_nick")
        String kfNick;

        /**
         * 如果客服帐号尚未绑定微信号，但是已经发起了一个绑定邀请， 则此处显示绑定邀请的微信号
         */
        @JsonProperty("invite_wx")
        String inviteWx;

        /**
         * 如果客服帐号尚未绑定微信号，但是已经发起过一个绑定邀请， 邀请的过期时间，为unix 时间戳
         */
        @JsonProperty("invite_expire_time")
        String inviteExpireTime;

        /**
         * 邀请的状态，有等待确认“waiting”，被拒绝“rejected”， 过期“expired”
         */
        @JsonProperty("invite_status")
        String inviteStatus;
    }

}
