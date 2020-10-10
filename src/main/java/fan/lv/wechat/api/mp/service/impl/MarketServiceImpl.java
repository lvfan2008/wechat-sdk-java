package fan.lv.wechat.api.mp.service.impl;

import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.mp.service.MarketService;
import fan.lv.wechat.entity.mp.market.WxInvokeServiceParam;
import fan.lv.wechat.entity.mp.market.WxInvokeServiceResult;

/**
 * @author lv_fan2008
 */
public class MarketServiceImpl implements MarketService {
    /**
     * 请求客户端
     */
    protected Client client;


    /**
     * @param client 请求客户端
     */
    public MarketServiceImpl(Client client) {
        this.client = client;
    }

    @Override
    public WxInvokeServiceResult invokeService(WxInvokeServiceParam param) {
        return client.postJson("/wxa/servicemarket", param, WxInvokeServiceResult.class);
    }
}
