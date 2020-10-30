package fan.lv.wechat.api.open.service.mp.impl;

import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.open.service.mp.LiveService;
import fan.lv.wechat.entity.open.mp.live.*;
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
    public WxCreateLiveRoomResult createLiveRoom(WxCreateLiveRoomParam param) {
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

    @Override
    public WxAddLiveGoodsResult addLiveGoods(WxLiveGoodsParam param) {
        return client.postJson("/wxaapi/broadcast/goods/add",param,WxAddLiveGoodsResult.class);
    }

    @Override
    public WxResult resetAudit(Integer goodsId, Integer auditId) {
        return client.postJson("/wxaapi/broadcast/goods/resetaudit",
                SimpleMap.of("goodsId", goodsId, "auditId", auditId),
                WxResult.class);
    }

    @Override
    public WxReAuditResult reAudit(Integer goodsId) {
        return client.postJson("/wxaapi/broadcast/goods/audit",
                SimpleMap.of("goodsId", goodsId),
                WxReAuditResult.class);
    }

    @Override
    public WxResult deleteGoods(Integer goodsId) {
        return client.postJson("/wxaapi/broadcast/goods/delete",
                SimpleMap.of("goodsId", goodsId),
                WxResult.class);
    }

    @Override
    public WxResult updateGoods(WxLiveGoodsParam param) {
        return client.postJson("/wxaapi/broadcast/goods/update",
                param,
                WxResult.class);
    }

    @Override
    public WxGoodsAuditInfoResult getGoodsAuditInfo(List<Integer> goodsIds) {
        return client.postJson("/wxa/business/getgoodswarehouse",
                SimpleMap.of("goods_ids", goodsIds),
                WxGoodsAuditInfoResult.class);
    }

    @Override
    public WxGoodsAuditInfoResult getGoodsList(Integer offset, Integer limit, Integer status) {
        return client.postJson("/wxaapi/broadcast/goods/getapproved",
                SimpleMap.of("offset", offset,"limit", limit,"status", status),
                WxGoodsAuditInfoResult.class);
    }
}
