package fan.lv.wechat.api.open.service;

import fan.lv.wechat.entity.open.open.WxPreAuthCodeResult;

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
}
