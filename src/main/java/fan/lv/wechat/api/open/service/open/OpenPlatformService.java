package fan.lv.wechat.api.open.service.open;

import fan.lv.wechat.api.official.server.ServerService;
import fan.lv.wechat.api.open.OpenMpApp;
import fan.lv.wechat.api.open.OpenOfficialApp;
import fan.lv.wechat.entity.official.sns.WxSnsAccessTokenResult;
import fan.lv.wechat.entity.open.open.*;
import fan.lv.wechat.entity.result.WxResult;

/**
 * @author lv_fan2008
 */
public interface OpenPlatformService {
    /**
     * 获取预授权码
     *
     * @return 预授权码
     */
    WxPreAuthCodeResult getPreAuthCode();

    /**
     * 使用授权码获取授权信息
     *
     * @param authorizationCode 授权码, 会在授权成功时返回给第三方平台
     * @return 授权信息
     */
    WxAuthorizationInfoResult getAuthorizationInfo(String authorizationCode);

    /**
     * 获取授权注册页面扫码授权链接
     *
     * @param preAuthCode 预授权码
     * @param redirectUrl 回调 URI
     * @param authType    要授权的帐号类型， 1 则商户扫码后，手机端仅展示公众号、2 表示仅展示小程序，3 表示公众号和小程序都展示。
     *                    如果为未指定，则默认(null)小程序和公众号都展示。第三方平台开发者可以使用本字段来控制授权的帐号类型。
     * @param bizAppId    指定授权唯一的小程序或公众号,可为null。与authType字段互斥。
     * @return 授权链接
     */
    String getAuthorityPageUrl(String preAuthCode, String redirectUrl, String authType, String bizAppId);

    /**
     * 获取移动端快速授权链接
     *
     * @param preAuthCode 预授权码
     * @param redirectUrl 回调 URI
     * @param authType    要授权的帐号类型， 1 则商户扫码后，手机端仅展示公众号、2 表示仅展示小程序，3 表示公众号和小程序都展示。
     *                    如果为未指定，则默认(null)小程序和公众号都展示。第三方平台开发者可以使用本字段来控制授权的帐号类型。
     * @param bizAppId    指定授权唯一的小程序或公众号,可为null。与authType字段互斥。
     * @return 授权链接
     */
    String getMobileAuthorityPageUrl(String preAuthCode, String redirectUrl, String authType, String bizAppId);

    /**
     * 获取/刷新接口调用令牌
     *
     * @param authorizerAppId 授权方 appid
     * @return 调用令牌
     */
    WxRefreshAuthorizerAccessTokenResult refreshAuthorizerToken(String authorizerAppId);

    /**
     * 获取授权方的帐号基本信息
     *
     * @param authorizerAppId 授权方 appid
     * @return 授权方的帐号基本信息
     */
    WxAuthorizerInfoResult getAuthorizerInfo(String authorizerAppId);

    /**
     * 获取授权方选项信息
     *
     * @param authorizerAppId 授权公众号或小程序的 appid
     * @param optionName      选项名称
     * @return 授权方选项信息
     */
    WxAuthorizerOptionResult getAuthorizerOption(String authorizerAppId, String optionName);

    /**
     * 设置授权方选项信息
     *
     * @param authorizerAppId 授权公众号或小程序的 appid
     * @param optionName      选项名称
     * @param optionValue     设置的选项值
     * @return 设置结果
     */
    WxResult setAuthorizerOption(String authorizerAppId, String optionName, String optionValue);

    /**
     * 拉取所有已授权的帐号信息
     *
     * @param offset 偏移位置/起始位置
     * @param count  拉取数量，最大为 500
     * @return 已授权的帐号信息
     */
    WxAuthorizerListResult getAuthorizerList(Integer offset, Integer count);

    /**
     * 第三方平台对其所有 API 调用次数清零,（只与第三方平台相关）
     *
     * @return 返回结果
     */
    WxResult clearQuota();

    /**
     * 得到小程序appId的服务
     *
     * @param appId 小程序appId
     * @return 小程序appId的服务
     */
    OpenMpApp getMpApp(String appId);

    /**
     * 得到公众号appId的服务
     *
     * @param appId 公众号appId
     * @return 公众号appId的服务
     */
    OpenOfficialApp getOfficialApp(String appId);
}
