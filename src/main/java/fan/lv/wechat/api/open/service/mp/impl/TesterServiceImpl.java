package fan.lv.wechat.api.open.service.mp.impl;

import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.open.service.mp.TesterService;
import fan.lv.wechat.entity.open.mp.tester.WxBindTesterResult;
import fan.lv.wechat.entity.open.mp.tester.WxTesterListResult;
import fan.lv.wechat.entity.result.WxResult;
import fan.lv.wechat.util.SimpleMap;

/**
 * @author lv_fan2008
 */
public class TesterServiceImpl implements TesterService {
    /**
     * 请求客户端
     */
    protected Client client;

    /**
     * @param client 请求客户端
     */
    public TesterServiceImpl(Client client) {
        this.client = client;
    }

    @Override
    public WxBindTesterResult bindTester(String wechatId) {
        return client.postJson("/wxa/bind_tester", SimpleMap.of("wechatid", wechatId), WxBindTesterResult.class);
    }

    @Override
    public WxResult unbindTester(String wechatId, String userStr) {
        return client.postJson("/wxa/unbind_tester",
                SimpleMap.of("wechatid", wechatId, "userstr", userStr),
                WxResult.class);
    }

    @Override
    public WxTesterListResult getTesterList() {
        return client.postJson("/wxa/memberauth",
                SimpleMap.of("action", "get_experiencer"),
                WxTesterListResult.class);
    }
}
