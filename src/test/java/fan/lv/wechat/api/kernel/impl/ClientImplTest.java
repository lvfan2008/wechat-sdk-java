package fan.lv.wechat.api.kernel.impl;

import fan.lv.wechat.api.official.Util;
import fan.lv.wechat.entity.base.WxCheckParam;
import fan.lv.wechat.entity.base.WxApiIpResult;
import fan.lv.wechat.entity.base.WxCheckResult;
import junit.framework.TestCase;


public class ClientImplTest extends TestCase {

    public void testGet() {
        WxApiIpResult apiIpResult = Util.getClient().get("/cgi-bin/get_api_domain_ip", WxApiIpResult.class);
        assertTrue(apiIpResult.success());
    }

    /**
     * todo:暂时不做测试
     */
    public void ttestPost() {
        WxCheckParam param = new WxCheckParam("all", "DEFAULT");
        WxCheckResult checkResult = Util.getClient().post("/cgi-bin/callback/check", param, WxCheckResult.class);
        assertTrue(checkResult.success());
    }

    public void testUploadFile() {

    }
}