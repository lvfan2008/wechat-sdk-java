package fan.lv.wechat.api.open.service.ofiicial;

import fan.lv.wechat.entity.open.official.WxFastRegisterResult;
import fan.lv.wechat.entity.result.WxResult;

/**
 * 复用公众号主体快速注册小程序
 *
 * @author lv_fan2008
 */
public interface FastRegisterMpService {
    /**
     * 跳转到微信公众平台授权页面链接
     *
     * @param copyWxVerify 是否复用公众号的资质进行微信认证(1:申请复用资质进行微信 认证 0:不申请)
     * @param redirectUri  用户扫码授权后，MP 扫码页面将跳转到该地址
     *                     (注:1.链接需 urlencode 2.Host 需和第三方平台在微信开放平台上面填写的登 录授权的发起页域名一致)
     * @return 跳转到微信公众平台授权页面链接
     */
    String getFastRegisterAuthUrl(Integer copyWxVerify, String redirectUri);

    /**
     * 快速注册小程序
     *
     * @param tikcet 公众号扫码授权的凭证(公众平台扫码页面回跳到第三方平台时携带)
     * @return 注册小程序结果
     */
    WxFastRegisterResult fasterRegister(String tikcet);

    /**
     * 换绑小程序管理员链接
     *
     * @param redirectUri 新管理员信息填写完成点击提交后，将跳转到该地址
     *                    (注：1.链接需 urlencode 2.Host 需和第三方平台在微信开放平台上面填写的登录授权的发起页域名一致)
     * @return 换绑小程序管理员链接
     */
    String getRebindMpAdminUrl(String redirectUri);

    /**
     * 管理员换绑
     *
     * @param taskId 换绑管理员任务序列号(公众平台最终点击提交回跳到第三方平台时携带)
     * @return 返回结果
     */
    WxResult rebindMpAdmin(String taskId);


}

