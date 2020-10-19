package fan.lv.wechat.entity.open.open;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 授权信息
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxAuthorizationInfoResult extends WxResult {

    /**
     * 授权信息
     */
    @JsonProperty("authorization_info")
    AuthorizationInfo authorizationInfo;

    @Data
    public static class AuthorizationInfo {
        /**
         * 授权方 appid
         */
        @JsonProperty("authorizer_appid")
        String authorizerAppId;

        /**
         * 接口调用令牌（在授权的公众号/小程序具备 API 权限时，才有此返回值）
         */
        @JsonProperty("authorizer_access_token")
        String authorizerAccessToken;

        /**
         * authorizer_access_token 的有效期（在授权的公众号/小程序具备API权限时，才有此返回值），单位：秒
         */
        @JsonProperty("expires_in")
        Integer expiresIn;

        /**
         * 刷新令牌（在授权的公众号具备API权限时，才有此返回值），刷新令牌主要用于第三方平台获取和刷新已授权用户的
         * authorizer_access_token。一旦丢失，只能让用户重新授权，才能再次拿到新的刷新令牌。用户重新授权后，之前的刷新令牌会失效
         */
        @JsonProperty("authorizer_refresh_token")
        String authorizerRefreshToken;

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
}
