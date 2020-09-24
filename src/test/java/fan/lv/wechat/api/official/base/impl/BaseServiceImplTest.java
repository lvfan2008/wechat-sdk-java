package fan.lv.wechat.api.official.base.impl;

import fan.lv.wechat.api.official.Util;
import fan.lv.wechat.api.official.base.BaseService;
import fan.lv.wechat.entity.official.base.WxApiIpResult;
import fan.lv.wechat.entity.official.base.WxCallbackIpResult;
import fan.lv.wechat.entity.official.base.WxCheckParam;
import fan.lv.wechat.entity.official.base.WxCheckResult;
import fan.lv.wechat.entity.official.message.reply.WxAutoReplyRuleResult;
import fan.lv.wechat.entity.result.WxResult;
import junit.framework.TestCase;

public class BaseServiceImplTest extends TestCase {

    BaseService baseService;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        baseService = new BaseServiceImpl(Util.getClient());
    }

    public void testGetCallbackIp() {
        WxCallbackIpResult callbackIpResult = baseService.getCallbackIp();
        assertTrue(callbackIpResult.success());
    }

    public void testGetApiDomainIp() {
        WxApiIpResult apiIpResult = baseService.getApiDomainIp();
        assertTrue(apiIpResult.success());
    }

    /**
     * todo:暂时不做测试
     */
    public void testCheckNetwork() {
        WxCheckParam param = new WxCheckParam("all", "DEFAULT");
        WxCheckResult checkResult = baseService.checkNetwork(param);
        assertTrue(checkResult.getErrorCode() > 0);
    }

    public void testClearQuota() {
        WxResult result = baseService.clearQuota(Util.getProperty("app_id"));
        assertTrue(result.success());
    }

    public void testGetAutoReplyRule() {
        WxAutoReplyRuleResult result = baseService.getAutoReplyRule();
        assertTrue(result.success());
    }
}