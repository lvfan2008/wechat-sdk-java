package fan.lv.wechat.api.mp.impl;

import com.google.common.collect.ImmutableMap;
import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.mp.NearByPoiService;
import fan.lv.wechat.entity.mp.nearbypoi.WxAddNearByPoiParam;
import fan.lv.wechat.entity.mp.nearbypoi.WxAddNearByPoiResult;
import fan.lv.wechat.entity.mp.nearbypoi.WxNearByPoiListResult;
import fan.lv.wechat.entity.result.WxResult;

/**
 * @author lv_fan2008
 */
public class NearByPoiServiceImpl implements NearByPoiService {
    /**
     * 请求客户端
     */
    protected Client client;


    /**
     * @param client 请求客户端
     */
    public NearByPoiServiceImpl(Client client) {
        this.client = client;
    }

    @Override
    public WxAddNearByPoiResult addNearByPoi(WxAddNearByPoiParam poiParam) {
        return client.postJson("/wxa/addnearbypoi", poiParam, WxAddNearByPoiResult.class);
    }

    @Override
    public WxResult delete(String poiId) {
        return client.postJson("/wxa/delnearbypoi", ImmutableMap.of("poi_id", poiId), WxResult.class);
    }

    @Override
    public WxNearByPoiListResult getList(Integer page, Integer pageRows) {
        return client.get("/wxa/getnearbypoilist",
                ImmutableMap.of("page", String.valueOf(page), "page_rows", String.valueOf(pageRows)),
                WxNearByPoiListResult.class);
    }

    @Override
    public WxResult setShowStatus(String poiId, Integer status) {
        return client.postJson("/wxa/setnearbypoishowstatus",
                ImmutableMap.of("poi_id", poiId, "status", status),
                WxNearByPoiListResult.class);
    }
}
