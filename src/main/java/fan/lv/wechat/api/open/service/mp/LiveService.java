package fan.lv.wechat.api.open.service.mp;

import fan.lv.wechat.entity.open.mp.live.WxCreateLiveRoomResult;
import fan.lv.wechat.entity.open.mp.live.WxCreateLiveRootParam;

/**
 * 直播服务
 *
 * @author lv_fan2018
 */
public interface LiveService {

    /**
     * 创建直播间
     *
     * @param param 创建直播间参数
     * @return 创建结果
     * @see <a href="https://developers.weixin.qq.com/doc/oplatform/Third-party_Platforms/Mini_Programs/live_player/studio-api.html" target="_blank">官方接口文档</a>
     */
    WxCreateLiveRoomResult createLiveRoom(WxCreateLiveRootParam param);


}
