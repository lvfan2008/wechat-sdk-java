package fan.lv.wechat.api.official.base.impl;

import fan.lv.wechat.api.official.Util;
import fan.lv.wechat.api.official.base.BaseService;
import fan.lv.wechat.entity.base.WxCheckParam;
import fan.lv.wechat.entity.base.WxApiIpResult;
import fan.lv.wechat.entity.base.WxCallbackIpResult;
import fan.lv.wechat.entity.base.WxCheckResult;
import junit.framework.TestCase;

public class BaseServiceImplTest extends TestCase {

    public void testGetCallbackIp() {
        BaseService baseService = new BaseServiceImpl(Util.getClient());
        WxCallbackIpResult callbackIpResult = baseService.getCallbackIp();
        assertTrue(callbackIpResult.success());
    }

    public void testGetApiDomainIp() {
        BaseService baseService = new BaseServiceImpl(Util.getClient());
        WxApiIpResult apiIpResult = baseService.getApiDomainIp();
        assertTrue(apiIpResult.success());
    }

    /**
     * todo:暂时不做测试
     */
    public void ttestCheckNetwork() {
        BaseService baseService = new BaseServiceImpl(Util.getClient());
        WxCheckParam param = new WxCheckParam("all", "DEFAULT");
        WxCheckResult checkResult = baseService.checkNetwork(param);
        assertTrue(checkResult.success());
    }
}