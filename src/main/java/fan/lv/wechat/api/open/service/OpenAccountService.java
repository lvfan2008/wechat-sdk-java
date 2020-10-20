package fan.lv.wechat.api.open.service;

import fan.lv.wechat.entity.open.open.*;
import fan.lv.wechat.entity.result.WxResult;

/**
 * @author lv_fan2008
 */
public interface OpenAccountService {
    /**
     * 创建开放平台帐号并绑定公众号/小程序
     *
     * @return 开放平台帐号
     */
    WxOpenAccountResult createOpenAccount();

    /**
     * 将公众号/小程序绑定到开放平台帐号下
     *
     * @param openAppId 开放平台帐号 appid，由创建开发平台帐号接口返回
     * @return 绑定结果
     */
    WxResult bindOpenAccount(String openAppId);

    /**
     * 将公众号/小程序从开放平台帐号下解绑
     *
     * @param openAppId 开放平台帐号 appid，由创建开发平台帐号接口返回
     * @return 解绑结果
     */
    WxResult unbindOpenAccount(String openAppId);

    /**
     * 获取公众号/小程序所绑定的开放平台帐号
     *
     * @return 开放平台帐号
     */
    WxOpenAccountResult getOpenAccount();
}
