package fan.lv.wechat.api.open.service.mp;

import fan.lv.wechat.entity.open.mp.live.WxCreateLiveRoomResult;
import fan.lv.wechat.entity.open.mp.live.WxCreateLiveRootParam;
import fan.lv.wechat.entity.open.mp.live.WxGetLiveReplayInfoResult;
import fan.lv.wechat.entity.open.mp.live.WxGetLiveRoomListResult;
import fan.lv.wechat.entity.result.WxResult;

import java.util.List;

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

    /**
     * 获取直播间列表
     *
     * @param start 起始房间，0表示从第1个房间开始拉取
     * @param limit 每次拉取的房间数量，建议100以内
     * @return 直播间列表
     * @see <a href="https://developers.weixin.qq.com/doc/oplatform/Third-party_Platforms/Mini_Programs/live_player/studio-api.html" target="_blank">官方接口文档</a>
     */
    WxGetLiveRoomListResult getLiveRoomList(Integer start, Integer limit);

    /**
     * 获取直播间回放
     *
     * @param roomId 直播间ID
     * @param start  起始房间，0表示从第1个房间开始拉取
     * @param limit  每次拉取的房间数量，建议100以内
     * @return 直播间回放信息
     * @see <a href="https://developers.weixin.qq.com/doc/oplatform/Third-party_Platforms/Mini_Programs/live_player/studio-api.html" target="_blank">官方接口文档</a>
     */
    WxGetLiveReplayInfoResult getLiveReplayInfo(Integer roomId, Integer start, Integer limit);

    /**
     * 直播间导入商品
     *
     * @param ids    数组列表，可传入多个，里面填写 商品 ID
     * @param roomId 房间ID
     * @return 导入结果
     * @see <a href="https://developers.weixin.qq.com/doc/oplatform/Third-party_Platforms/Mini_Programs/live_player/studio-api.html" target="_blank">官方接口文档</a>
     */
    WxResult importGoods(List<Integer> ids, Integer roomId);

}
