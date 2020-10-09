package fan.lv.wechat.api.mp.impl;

import fan.lv.wechat.api.mp.service.PluginService;
import fan.lv.wechat.api.mp.service.impl.PluginServiceImpl;
import fan.lv.wechat.api.official.Util;
import fan.lv.wechat.entity.mp.plugin.WxPluginDevApplyListResult;
import fan.lv.wechat.entity.mp.plugin.WxPluginListResult;
import fan.lv.wechat.entity.result.WxResult;
import junit.framework.TestCase;

/**
 * @author lv_fan2008
 */
public class PluginServiceImplTest extends TestCase {

    PluginService pluginService;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        pluginService = new PluginServiceImpl(Util.getMpClient());
    }

    public void testApplyPlugin() {
        WxResult result = pluginService.applyPlugin("wx4418e3e031e551be", null);
        assertTrue(result.success());
    }

    public void testGetPluginDevApplyList() {
        WxPluginDevApplyListResult result = pluginService.getPluginDevApplyList(0, 10);
        assertTrue(result.success() || result.getErrorCode() == 89239);

    }

    public void testGetPluginList() {
        WxPluginListResult result = pluginService.getPluginList();
        assertTrue(result.success());
    }

    public void testSetDevPluginApplyStatus() {
        WxResult result = pluginService.setDevPluginApplyStatus("dev_agree", "wx4418e3e031e551be", null);
        assertEquals(89239, (int) result.getErrorCode());
    }

    public void testUnbindPlugin() {
        WxResult result2 = pluginService.unbindPlugin("wx4418e3e031e551be");
        assertTrue(result2.success() || 89244 == result2.getErrorCode() );
    }
}