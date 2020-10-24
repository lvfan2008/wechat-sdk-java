package fan.lv.wechat.api.mp.service;

import fan.lv.wechat.entity.mp.user.WxPaidUnionIdResult;
import fan.lv.wechat.entity.mp.user.WxSessionResult;

/**
 * @author lv_fan2008
 */
public interface AuthService {
    /**
     * 登录凭证校验,通过 wx.login 接口获得临时登录凭证 code 后传到开发者服务器调用此接口完成登录流程
     *
     * @param code 登录时获取的 code
     * @return 登录会话凭证
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/login/auth.code2Session.html" target="_blank">微信官方文档</a>
     */
    WxSessionResult codeToSession(String code);
}
