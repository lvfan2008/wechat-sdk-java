package fan.lv.wechat.api.open.service.mp.impl;

import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.open.service.mp.LiveService;
import fan.lv.wechat.entity.open.mp.live.WxCreateLiveRoomResult;
import fan.lv.wechat.entity.open.mp.live.WxCreateLiveRootParam;
import fan.lv.wechat.entity.open.mp.live.WxGetLiveReplayInfoResult;
import fan.lv.wechat.entity.open.mp.live.WxGetLiveRoomListResult;
import fan.lv.wechat.entity.result.WxResult;
import fan.lv.wechat.util.SimpleMap;

import java.util.List;

/**
 * @author lv_fan2018
 */
public class LiveServiceImpl implements LiveService {
    /**
     * 请求客户端
     */
    protected Client client;

    /**
     * @param client 请求客户端
     */
    public LiveServiceImpl(Client client) {
        this.client = client;
    }

    @Override
    public WxCreateLiveRoomResult createLiveRoom(WxCreateLiveRootParam param) {
        return client.postJson("/wxaapi/broadcast/room/create", param, WxCreateLiveRoomResult.class);
    }

    @Override
    public WxGetLiveRoomListResult getLiveRoomList(Integer start, Integer limit) {
        return client.postJson("/wxa/business/getliveinfo",
                SimpleMap.of("start", start, "limit", limit),
                WxGetLiveRoomListResult.class);
    }

    @Override
    public WxGetLiveReplayInfoResult getLiveReplayInfo(Integer roomId, Integer start, Integer limit) {
        return client.postJson("/wxa/business/getliveinfo",
                SimpleMap.of("action", "get_replay", "room_id", roomId,
                        "start", start, " limit", limit),
                WxGetLiveReplayInfoResult.class);
    }

    @Override
    public WxResult importGoods(List<Integer> ids, Integer roomId) {
        return client.postJson("/wxaapi/broadcast/room/addgoods",
                SimpleMap.of("ids", ids, "room_id", roomId),
                WxResult.class);
    }
}
