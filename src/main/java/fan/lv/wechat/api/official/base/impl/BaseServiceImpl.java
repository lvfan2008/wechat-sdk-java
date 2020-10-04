package fan.lv.wechat.api.official.base.impl;

import fan.lv.wechat.api.official.base.BaseService;
import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.entity.official.base.*;
import fan.lv.wechat.entity.official.message.reply.WxAutoReplyRuleResult;
import fan.lv.wechat.entity.result.WxResult;

/**
 * @author lv_fan2008
 */
public class BaseServiceImpl implements BaseService {
    /**
     * 请求客户端
     */
    protected Client client;

    /**
     * appId
     */
    protected String appId;

    /**
     * @param client 请求客户端
     * @param appId  公众号appId
     */
    public BaseServiceImpl(Client client, String appId) {
        this.client = client;
        this.appId = appId;
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
        return client.postJson("/cgi-bin/callback/check", checkParam, WxCheckResult.class);
    }

    @Override
    public WxResult clearQuota() {
        return client.postJson("/cgi-bin/clear_quota", new WxClearQuotaParam(appId), WxResult.class);
    }

    @Override
    public WxAutoReplyRuleResult getAutoReplyRule() {
        return client.get("/cgi-bin/get_current_autoreply_info", WxAutoReplyRuleResult.class);
    }
}
