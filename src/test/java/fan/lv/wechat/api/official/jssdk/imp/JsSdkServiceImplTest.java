package fan.lv.wechat.api.official.jssdk.imp;

import fan.lv.wechat.api.kernel.impl.DefaultCacheImpl;
import fan.lv.wechat.api.official.Util;
import fan.lv.wechat.api.official.jssdk.JsSdkService;
import fan.lv.wechat.entity.official.jssdk.WxJsSdkTicketResult;
import junit.framework.TestCase;

/**
 * @author lv_fan2008
 */
public class JsSdkServiceImplTest extends TestCase {

    JsSdkService jsSdkService;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        jsSdkService = new JsSdkServiceImpl(Util.getProperty("app_id"),
                Util.getClient(),
                new DefaultCacheImpl()
        );
    }

    public void testGetTicket() {
        WxJsSdkTicketResult result = jsSdkService.getJsSdkTicket();
        assertTrue(result.success());
    }

    public void testSignature() {
        WxJsSdkTicketResult result = jsSdkService.getJsSdkTicket();
        assertTrue(result.success());
        String sign = jsSdkService.signatureJsSdk("322332","1349232332","http://www.yunyicheng.cn/callback",result.getTicket());
        assertNotNull(sign);
    }
}