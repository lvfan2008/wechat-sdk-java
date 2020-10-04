package fan.lv.wechat.api.official.sns;

import fan.lv.wechat.entity.official.sns.WxSnsAccessTokenResult;
import fan.lv.wechat.entity.official.sns.WxSnsOpenIdResult;
import fan.lv.wechat.entity.official.sns.WxSnsUserInfoResult;

/**
 * 网页授权服务
 *
 * @author lv_fan2008
 * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/OA_Web_Apps/Wechat_webpage_authorization.html" target="_blank">微信官方接口文档</a>
 */
public interface SnsService {

    /**
     * 得到用户授权Url，用于获取code
     *
     * @param redirectUrl 授权后重定向的回调链接地址， 请使用 urlEncode 对链接进行处理
     * @param scope       应用授权作用域，snsapi_base （不弹出授权页面，直接跳转，只能获取用户openid），
     *                    snsapi_userinfo （弹出授权页面，可通过openid拿到昵称、性别、所在地。
     *                    并且， 即使在未关注的情况下，只要用户授权，也能获取其信息 ）
     * @param state       重定向后会带上state参数，开发者可以填写a-zA-Z0-9的参数值，最多128字节
     * @return 用户授权Url
     */
    String getOpenAuthUrl(String redirectUrl, String scope, String state);

    /**
     * 获取网页授权令牌对应的OpenId
     *
     * @param code 用于换取令牌的code
     * @return 获取OpenId
     */
    WxSnsOpenIdResult getAuthToken(String code);

    /**
     * 拉取用户信息(需scope为 snsapi_userinfo)
     *
     * @param openId 粉丝OpenId
     * @param lang   返回国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语
     * @return 用户信息
     */
    WxSnsUserInfoResult getUserInfo(String openId, String lang);
}
