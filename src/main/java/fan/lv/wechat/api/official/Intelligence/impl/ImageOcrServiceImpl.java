package fan.lv.wechat.api.official.Intelligence.impl;

import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.official.Intelligence.AiService;
import fan.lv.wechat.api.official.Intelligence.ImageOcrService;
import fan.lv.wechat.entity.official.intelligence.*;
import fan.lv.wechat.entity.result.WxResult;
import fan.lv.wechat.util.SimpleMap;

import java.util.Map;

/**
 * @author lv_fan2008
 */
public class ImageOcrServiceImpl implements ImageOcrService {

    /**
     * 请求客户端
     */
    protected Client client;

    /**
     * @param client 请求客户端
     */
    public ImageOcrServiceImpl(Client client) {
        this.client = client;
    }


    @Override
    public WxOcrIdCardResult ocrIdCard(String imagePathOrUrl, boolean isUrl) {
        return uploadImage("/cv/ocr/idcard", imagePathOrUrl, isUrl, WxOcrIdCardResult.class);
    }

    @Override
    public WxOcrBankCardResult ocrBankCard(String imagePathOrUrl, boolean isUrl) {
        return uploadImage("/cv/ocr/bankcard", imagePathOrUrl, isUrl, WxOcrBankCardResult.class);
    }

    @Override
    public WxOcrDrivingCardResult ocrDrivingCard(String imagePathOrUrl, boolean isUrl) {
        return uploadImage("/cv/ocr/driving", imagePathOrUrl, isUrl, WxOcrDrivingCardResult.class);
    }

    @Override
    public WxOcrDrivingLicenseCardResult ocrDrivingLicenseCard(String imagePathOrUrl, boolean isUrl) {
        return uploadImage("/cv/ocr/drivinglicense", imagePathOrUrl, isUrl, WxOcrDrivingLicenseCardResult.class);
    }

    @Override
    public WxOcrBizLicenseResult ocrBizLicense(String imagePathOrUrl, boolean isUrl) {
        return uploadImage("/cv/ocr/bizlicense", imagePathOrUrl, isUrl, WxOcrBizLicenseResult.class);
    }

    @Override
    public WxOcrCommonResult ocrCommon(String imagePathOrUrl, boolean isUrl) {
        return uploadImage("/cv/ocr/comm", imagePathOrUrl, isUrl, WxOcrCommonResult.class);
    }

    @Override
    public WxOcrQrCodeResult ocrQrCode(String imagePathOrUrl, boolean isUrl) {
        return uploadImage("/cv/img/qrcode", imagePathOrUrl, isUrl, WxOcrQrCodeResult.class);
    }

    @Override
    public WxImageSuperResolutionResult imageSuperResolution(String imagePathOrUrl, boolean isUrl) {
        return uploadImage("/cv/img/superresolution", imagePathOrUrl, isUrl, WxImageSuperResolutionResult.class);
    }

    @Override
    public WxImageAiCropResult imageAiCrop(String imagePathOrUrl, boolean isUrl, String ratios) {
        return uploadImage("/cv/img/aicrop", imagePathOrUrl, isUrl,
                ratios == null ? SimpleMap.of() : SimpleMap.of("ratios", ratios),
                WxImageAiCropResult.class);
    }


    /**
     * 公用上传图片
     *
     * @param uri            uri地址
     * @param imagePathOrUrl 图片文件或者url
     * @param isUrl          imagePathOrUrl是否为url
     * @param resultType     返回类型
     * @param <T>            类型模板
     * @return 识别结果
     */
    protected <T extends WxResult> T uploadImage(String uri, String imagePathOrUrl, boolean isUrl, Class<T> resultType) {
        return uploadImage(uri, imagePathOrUrl, isUrl, null, resultType);
    }

    /**
     * 公用上传图片
     *
     * @param uri            uri地址
     * @param imagePathOrUrl 图片文件或者url
     * @param isUrl          imagePathOrUrl是否为url
     * @param formData       forData
     * @param resultType     返回类型
     * @param <T>            类型模板
     * @return 识别结果
     */
    private <T extends WxResult> T uploadImage(String uri, String imagePathOrUrl, boolean isUrl, Map<String, String> formData, Class<T> resultType) {
        if (isUrl) {
            if (formData == null) {
                return client.get(uri, SimpleMap.of("img_url", imagePathOrUrl), resultType);
            } else {
                return client.postForm(uri, SimpleMap.of("img_url", imagePathOrUrl), formData, resultType);
            }
        } else {
            if (formData == null) {
                return client.uploadFile(uri, SimpleMap.<String, String>of(), SimpleMap.of("img", imagePathOrUrl), resultType);
            } else {
                return client.uploadFile(uri, formData, SimpleMap.of("img", imagePathOrUrl), resultType);
            }
        }
    }
}
