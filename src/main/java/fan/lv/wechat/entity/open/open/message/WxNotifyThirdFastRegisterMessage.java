package fan.lv.wechat.entity.open.open.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 小程序注册审核事件
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxNotifyThirdFastRegisterMessage extends WxBaseMessage {

    /**
     * 通知类型，小程序注册审核事件推送
     */
    @XStreamAlias("InfoType")
    String infoType = "notify_third_fasteregister";

    /**
     * 小程序AppId
     */
    @XStreamAlias("appid")
    String appId;

    /**
     * 创建状态
     */
    @XStreamAlias("status")
    Integer status;

    /**
     * 第三方授权码
     */
    @XStreamAlias("auth_code")
    String authCode;

    /**
     * 第三方授权码
     */
    @XStreamAlias("msg")
    String msg;

    @XStreamAlias("info")
    CompanyInfo info;

    @XStreamAlias("info")
    @Data
    public static class CompanyInfo {
        /**
         * 企业名称
         */
        @XStreamAlias("name")
        String name;


        /**
         * 企业代码
         */
        @XStreamAlias("code")
        String code;

        /**
         * 企业代码类型 1：统一社会信用代码（18 位） 2：组织机构代码（9 位 xxxxxxxx-x） 3：营业执照注册号(15 位)
         */
        @XStreamAlias("code_type")
        Integer codeType;

        /**
         * 第三方授权码
         */
        @XStreamAlias("auth_code")
        String authCode;

        /**
         * 法人微信号
         */
        @XStreamAlias("legal_persona_wechat")
        String legalPersonaWechat;

        /**
         * 法人姓名
         */
        @XStreamAlias("legal_persona_name")
        String legalPersonaName;
    }


}
