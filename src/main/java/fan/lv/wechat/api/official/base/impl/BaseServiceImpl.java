package fan.lv.wechat.api.official.base.impl;

import fan.lv.wechat.api.official.base.BaseService;
import fan.lv.wechat.api.official.kernel.Client;
import fan.lv.wechat.entity.base.param.WxCheckParam;
import fan.lv.wechat.entity.base.result.WxApiIpResult;
import fan.lv.wechat.entity.base.result.WxCallbackIpResult;
import fan.lv.wechat.entity.base.result.WxCheckResult;

/**
 * @author lixinguo
 */
public class BaseServiceImpl implements BaseService {
    /**
     * 请求客户端
     */
    protected Client client;

    /**
     * @param client 请求客户端
     */
    public BaseServiceImpl(Client client) {
        this.client = client;
    }

    @Override
    public WxCallbackIpResult getCallbackIp() {
        return client.get("/cgi-bin/getcallbackip", WxCallbackIpResult.class);
    }

    @Override
    public WxApiIpResult getApiDomainIp() {
        return client.get("/cgi-bin/get_api_domain_ip", WxApiIpResult.class);
    }

    @Override
    public WxCheckResult checkNetwork(WxCheckParam checkParam) {
        return client.post("/cgi-bin/callback/check", checkParam, WxCheckResult.class);
    }
}
