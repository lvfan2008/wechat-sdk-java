package fan.lv.wechat.api.open.service.mp;

import fan.lv.wechat.entity.open.mp.scansubscribe.WxGetCanShowOfficialListResult;
import fan.lv.wechat.entity.open.mp.scansubscribe.WxGetShowOfficialResult;
import fan.lv.wechat.entity.result.WxResult;

/**
 * 扫码关注组件相关服务
 * 用户扫码使用小程序时，即可展示当前公众号，用户可直接关注公众号。
 *
 * @author lv_fan2008
 */
public interface ScanSubscribeService {

    /**
     * 获取展示的公众号信息
     *
     * @return 展示的公众号信息j
     */
    WxGetShowOfficialResult getShowOfficialInfo();

    /**
     * 获取可以用来设置的公众号列表，通过本接口可以获取扫码关注组件允许展示的公众号列表
     *
     * @param page 页码，从 0 开始
     * @param num  每页记录数，最大为 20
     * @return 可以用来设置的公众号列表
     */
    WxGetCanShowOfficialListResult getCanShowOfficialList(Integer page, Integer num);

    /**
     * 设置展示的公众号信息
     * 使用本接口可以设置扫码关注组件所展示的公众号信息
     *
     * @param wxaSubscribeBizFlag 是否打开扫码关注组件，0 关闭，1 开启
     * @param appId               如果开启，需要传新的公众号 appid
     * @return 返回设置结果
     */
    WxResult setShowOfficialInfo(Integer wxaSubscribeBizFlag, String appId);
}
