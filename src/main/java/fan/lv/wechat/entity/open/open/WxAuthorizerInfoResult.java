package fan.lv.wechat.entity.open.open;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 授权方的帐号基本信息
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxAuthorizerInfoResult extends WxResult {

    /**
     * 授权方的帐号基本信息
     */
    @JsonProperty("authorizer_info")
    AuthorizerInfo authorizerInfo;

    /**
     * 授权信息
     */
    @JsonProperty("authorization_info")
    AuthorizationInfo authorizationInfo;

    @Data
    public static class AuthorizerInfo {
        /**
         * 昵称
         */
        @JsonProperty("nick_name")
        String nickName;

        /**
         * 头像
         */
        @JsonProperty("head_img")
        String headImg;

        /**
         * 公众号类型
         */
        @JsonProperty("service_type_info")
        ServiceTypeInfo serviceTypeInfo;

        /**
         * 公众号、小程序认证类型
         */
        @JsonProperty("verify_type_info")
        VerifyTypeInfo verifyTypeInfo;

        /**
         * 原始 ID
         */
        @JsonProperty("user_name")
        String userName;

        /**
         * 主体名称
         */
        @JsonProperty("principal_name")
        String principalName;

        /**
         * 用以了解功能的开通状况（0代表未开通，1代表已开通）
         */
        @JsonProperty("business_info")
        BusinessInfo businessInfo;


        /**
         * 别名
         */
        @JsonProperty("alias")
        String alias;

        /**
         * 二维码图片的 URL，开发者最好自行也进行保存
         */
        @JsonProperty("qrcode_url")
        String qrcodeUrl;

        /**
         *
         */
        Integer idc;

        /**
         *
         */
        String signature;

        /**
         * 小程序信息
         */
        MiniProgramInfo miniProgramInfo;
    }

    @Data
    public static class AuthorizationInfo {
        /**
         * 授权方 appid
         */
        @JsonProperty("authorizer_appid")
        String authorizerAppId;

        /**
         * 授权给开发者的权限集列表
         */
        @JsonProperty("func_info")
        List<FuncInfo> funcInfo;
    }


    @Data
    public static class FuncInfo {
        /**
         * 权限集
         */
        @JsonProperty("funcscope_category")
        FuncScopeCategory funcScopeCategory;
    }

    @Data
    public static class FuncScopeCategory {
        /**
         * 权限集Id
         */
        Integer id;
    }

    @Data
    public static class ServiceTypeInfo {
        /**
         * 公众号类型id： 0 订阅号 1 由历史老帐号升级后的订阅号 2 服务号
         */
        Integer id;
    }

    @Data
    public static class VerifyTypeInfo {
        /**
         * 公众号认证类型id：
         * -1 未认证
         * 0 微信认证
         * 1 新浪微博认证
         * 2 腾讯微博认证
         * 3 已资质认证通过但还未通过名称认证
         * 4 已资质认证通过、还未通过名称认证，但通过了新浪微博认证
         * 5 已资质认证通过、还未通过名称认证，但通过了腾讯微博认证
         */
        Integer id;
    }

    @Data
    public static class BusinessInfo {
        /**
         * 是否开通微信门店功能
         */
        @JsonProperty("open_store")
        Integer openStore;

        /**
         * 是否开通微信扫商品功能
         */
        @JsonProperty("open_scan")
        Integer openScan;


        /**
         * 是否开通微信支付功能
         */
        @JsonProperty("open_pay")
        Integer openPay;

        /**
         * 是否开通微信卡券功能
         */
        @JsonProperty("open_card")
        Integer openCard;

        /**
         * 是否开通微信摇一摇功能
         */
        @JsonProperty("open_shake")
        Integer openShake;
    }

    @Data
    public static class MiniProgramInfo {
        /**
         * 小程序配置的合法域名信息
         */
        MpNetwork network;

        /**
         * 小程序配置的类目信息
         */
        List<MpCategory> categories;

        /**
         * 访问状态，??未找到相关说明??
         */
        @JsonProperty("visit_status")
        Integer visitStatus;
    }

    @Data
    public static class MpNetwork {
        /**
         * Http合法请求域名列表
         */
        @JsonProperty("RequestDomain")
        List<String> requestDomain;

        /**
         * WebSocket合法请求域名列表
         */
        @JsonProperty("WsRequestDomain")
        List<String> wsRequestDomain;

        /**
         * 上传合法请求域名列表
         */
        @JsonProperty("UploadDomain")
        List<String> uploadDomain;

        /**
         * 下载合法请求域名列表
         */
        @JsonProperty("DownloadDomain")
        List<String> downloadDomain;

        /**
         * 业务合法请求域名列表
         */
        @JsonProperty("BizDomain")
        List<String> bizDomain;

        /**
         * udp合法请求域名列表
         */
        @JsonProperty("UDPDomain")
        List<String> udpDomain;

    }

    @Data
    public static class MpCategory {

        /**
         * 一级类目
         */
        String first;

        /**
         * 二级类目
         */
        String second;
    }


}
