package fan.lv.wechat.api.open.service.mp.impl;

import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.open.service.mp.ScanSubscribeService;
import fan.lv.wechat.entity.open.mp.scansubscribe.WxGetCanShowOfficialListResult;
import fan.lv.wechat.entity.open.mp.scansubscribe.WxGetShowOfficialResult;
import fan.lv.wechat.entity.result.WxResult;
import fan.lv.wechat.util.SimpleMap;

/**
 * @author lv_fan2008
 */
public class ScanSubscribeServiceImpl implements ScanSubscribeService {

    /**
     * 请求客户端
     */
    protected Client client;

    /**
     * @param client 请求客户端
     */
    public ScanSubscribeServiceImpl(Client client) {
        this.client = client;
    }

    @Override
    public WxGetShowOfficialResult getShowOfficialInfo() {
        return client.get("/wxa/getshowwxaitem", WxGetShowOfficialResult.class);
    }

    @Override
    public WxGetCanShowOfficialListResult getCanShowOfficialList(Integer page, Integer num) {
        return client.get("/wxa/getwxamplinkforshow",
                SimpleMap.of("page", page.toString(), "num", num.toString()),
                WxGetCanShowOfficialListResult.class);
    }

    @Override
    public WxResult setShowOfficialInfo(Integer wxaSubscribeBizFlag, String appId) {
        return client.get("/wxa/updateshowwxaitem",
                SimpleMap.of("wxa_subscribe_biz_flag", wxaSubscribeBizFlag.toString(), "appid", appId),
                WxResult.class);
    }
}
