package fan.lv.wechat.api.open.service.ofiicial;

import fan.lv.wechat.entity.open.official.WxMpLinkResult;
import fan.lv.wechat.entity.result.WxResult;

/**
 * 公众号下，小程序管理权限集
 *
 * @author lv_fan2008
 */
public interface MpLinkService {

    /**
     * 获取公众号关联的小程序
     *
     * @return 公众号关联的小程序
     */
    WxMpLinkResult getMpLink();

    /**
     * 关联小程序
     *
     * @param appId       小程序 appid
     * @param notifyUsers 是否发送模板消息通知公众号粉丝 0否 1是
     * @param showProfile 是否展示公众号主页中 0否 1是
     * @return 返回结果
     */
    WxResult mpLink(String appId, Integer notifyUsers, Integer showProfile);

    /**
     * 解除已关联的小程序
     *
     * @param appId 小程序 appid
     * @return 返回结果
     */
    WxResult unMpLink(String appId);
}
