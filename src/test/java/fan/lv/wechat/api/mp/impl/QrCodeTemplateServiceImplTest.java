package fan.lv.wechat.api.mp.impl;

import fan.lv.wechat.api.mp.service.QrCodeService;
import fan.lv.wechat.api.mp.service.impl.QrCodeServiceImpl;
import fan.lv.wechat.api.official.Util;
import fan.lv.wechat.entity.mp.qrcode.WxGetMpCodeParam;
import fan.lv.wechat.entity.mp.qrcode.WxGetUnlimitedMpCodeParam;
import fan.lv.wechat.entity.result.WxResult;
import junit.framework.TestCase;

/**
 * @author lv_fan2008
 */
public class QrCodeTemplateServiceImplTest extends TestCase {

    QrCodeService qrCodeService;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        qrCodeService = new QrCodeServiceImpl(Util.getMpClient());
    }
    public void testCreateQrCode() {
        WxResult result = qrCodeService.createQrCode("/pages/index/index",null);
        assertTrue(result.success());
    }

    public void testGet() {
        WxResult result = qrCodeService.get(new WxGetMpCodeParam("/pages/index/index"));
        assertTrue(result.success());
    }

    public void testGetUnlimited() {
        WxResult result = qrCodeService.getUnlimited(new WxGetUnlimitedMpCodeParam("test_secc"));
        assertTrue(result.success());
    }
}