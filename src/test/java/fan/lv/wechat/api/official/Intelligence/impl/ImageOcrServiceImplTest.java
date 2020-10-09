package fan.lv.wechat.api.official.Intelligence.impl;

import fan.lv.wechat.api.official.Intelligence.AiService;
import fan.lv.wechat.api.official.Intelligence.ImageOcrService;
import fan.lv.wechat.api.official.Util;
import fan.lv.wechat.entity.official.intelligence.*;
import fan.lv.wechat.entity.result.WxResult;
import fan.lv.wechat.util.JsonUtil;
import junit.framework.TestCase;

/**
 * @author lv_fan2008
 */
public class ImageOcrServiceImplTest extends TestCase {

    ImageOcrService imageOcrService;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        imageOcrService = new ImageOcrServiceImpl(Util.getClient());
    }

    public void testOcrIdCard() {
        WxOcrIdCardResult result = imageOcrService.ocrIdCard(Util.getProperty("ocr.idCardFront"), false);
        assertTrue(result.success() || result.getErrorCode() == 48001);

        result = imageOcrService.ocrIdCard(Util.getProperty("ocr.idCardBack"), false);
        assertTrue(result.success() || result.getErrorCode() == 48001);
    }

    public void testOcrBankCard() {
        WxOcrBankCardResult result = imageOcrService.ocrBankCard(Util.getProperty("ocr.bankCard"), false);
        assertTrue(result.success() || result.getErrorCode() == 48001);
    }

    public void testOcrDrivingCard() {
        WxOcrDrivingCardResult result = imageOcrService.ocrDrivingCard(Util.getProperty("ocr.drivingCard"), false);
        assertTrue(result.success() || result.getErrorCode() == 48001);
    }

    public void testOcrDrivingLicenseCard() {
        WxOcrDrivingLicenseCardResult result = imageOcrService.ocrDrivingLicenseCard(Util.getProperty("ocr.drivingLicenseCard"), false);
        assertTrue(result.success() || result.getErrorCode() == 48001);
    }

    public void testOcrBizLicense() {
        WxOcrBizLicenseResult result = imageOcrService.ocrBizLicense(Util.getProperty("ocr.drivingLicenseCard"), false);
        assertTrue(result.success() || result.getErrorCode() == 48001);
    }

    public void testOcrCommon() {
        WxOcrCommonResult result = imageOcrService.ocrCommon(Util.getProperty("ocr.common"), false);
        assertTrue(result.success() || result.getErrorCode() == 48001);
    }

    public void testOcrQrCode() {
        WxOcrQrCodeResult result = imageOcrService.ocrQrCode(Util.getProperty("ocr.qrcode"), false);
        assertTrue(result.success() || result.getErrorCode() == 48001);
    }

    public void testImageSuperResolution() {
        WxImageSuperResolutionResult result = imageOcrService.imageSuperResolution(Util.getProperty("ocr.qrcode"), false);
        assertTrue(result.success() || result.getErrorCode() == 48001);
    }

    public void testImageAiCrop() {
        WxImageAiCropResult result = imageOcrService.imageAiCrop(Util.getProperty("ocr.qrcode"), false, "1,1.25");
        assertTrue(result.success() || result.getErrorCode() == 48001);
    }
}