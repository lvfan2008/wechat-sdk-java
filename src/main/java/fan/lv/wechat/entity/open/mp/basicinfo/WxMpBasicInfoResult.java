package fan.lv.wechat.entity.open.mp.basicinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 小程序基础信息结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxMpBasicInfoResult extends WxResult {

    /**
     * 新创建小程序的 appid
     */
    @JsonProperty("appid")
    String appId;


    /**
     * 新创建小程序的授权码
     */
    @JsonProperty("account_type")
    Integer accountType;

    /**
     * 主体类型
     */
    @JsonProperty("principal_type")
    Integer principalType;

    /**
     * 主体名称
     */
    @JsonProperty("principal_name")
    String principalName;

    /**
     * 实名验证状态
     */
    @JsonProperty("realname_status")
    Integer realnameStatus;


    /**
     * 微信认证信息
     */
    @JsonProperty("wx_verify_info")
    WxVerifyInfo wxVerifyInfo;

    /**
     * 功能介绍信息
     */
    @JsonProperty("signature_info")
    SignatureInfo signatureInfo;

    /**
     * 头像信息
     */
    @JsonProperty("head_image_info")
    HeadImageInfo headImageInfo;

    @Data
    public static class WxVerifyInfo {
        /**
         * 是否资质认证，若是，拥有微信认证相关的权限
         */
        @JsonProperty("qualification_verify")
        Boolean qualificationVerify;

        /**
         * 是否名称认证
         */
        @JsonProperty("naming_verify")
        Boolean namingVerify;

        /**
         * 是否需要年审（qualification_verify == true 时才有该字段）
         */
        @JsonProperty("annual_review")
        Boolean annualReview;

        /**
         * 年审开始时间，时间戳（qualification_verify == true 时才有该字段）
         */
        @JsonProperty("annual_review_begin_time")
        Integer annualReviewBeginTime;

        /**
         * 年审截止时间，时间戳（qualification_verify == true 时才有该字段）
         */
        @JsonProperty("annual_review_end_time")
        Integer annualReviewEndTime;
    }



    @Data
    public static class SignatureInfo {
        /**
         * 功能介绍
         */
        String signature;

        /**
         * 功能介绍已使用修改次数（本月）
         */
        @JsonProperty("modify_used_count")
        Integer modifyUsedCount;

        /**
         * 功能介绍修改次数总额度（本月）
         */
        @JsonProperty("modify_quota")
        Integer modifyQuota;
    }

    @Data
    public static class HeadImageInfo {
        /**
         * 头像 url
         */
        @JsonProperty("head_image_url")
        String headImageUrl;

        /**
         * 头像已使用修改次数（本月）
         */
        @JsonProperty("modify_used_count")
        Integer modifyUsedCount;

        /**
         * 头像修改次数总额度（本月）
         */
        @JsonProperty("modify_quota")
        Integer modifyQuota;
    }
}
