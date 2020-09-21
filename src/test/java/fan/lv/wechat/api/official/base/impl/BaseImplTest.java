package fan.lv.wechat.api.official.base.impl;

import fan.lv.wechat.api.official.Util;
import fan.lv.wechat.api.official.base.Base;
import fan.lv.wechat.entity.base.param.WxCheckParam;
import fan.lv.wechat.entity.base.result.WxApiIpResult;
import fan.lv.wechat.entity.base.result.WxCallbackIpResult;
import fan.lv.wechat.entity.base.result.WxCheckResult;
import junit.framework.TestCase;

public class BaseImplTest extends TestCase {

    public void testGetCallbackIp() {
        Base base = new BaseImpl(Util.getClient());
        WxCallbackIpResult callbackIpResult = base.getCallbackIp();
        assertTrue(callbackIpResult.success());
    }

    public void testGetApiDomainIp() {
        Base base = new BaseImpl(Util.getClient());
        WxApiIpResult apiIpResult = base.getApiDomainIp();
        assertTrue(apiIpResult.success());
    }

    /**
     * todo:暂时不做测试
     */
    public void ttestCheckNetwork() {
        Base base = new BaseImpl(Util.getClient());
        WxCheckParam param = new WxCheckParam("all", "DEFAULT");
        WxCheckResult checkResult = base.checkNetwork(param);
        assertTrue(checkResult.success());
    }
}