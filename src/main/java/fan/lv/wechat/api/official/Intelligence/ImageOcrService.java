package fan.lv.wechat.api.official.Intelligence;

import fan.lv.wechat.entity.official.intelligence.*;
import fan.lv.wechat.entity.result.WxResult;

/**
 * 智能接口
 *
 * @author lv_fan2008
 */
public interface ImageOcrService {
    /**
     * 身份证OCR识别接口，文件大小限制：小于2M
     *
     * @param imagePathOrUrl 图片文件或者url
     * @param isUrl          imagePathOrUrl是否为url
     * @return 身份识别结果
     * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/Intelligent_Interface/OCR.html" target="_blank">微信官方接口文档</a>
     */
    WxOcrIdCardResult ocrIdCard(String imagePathOrUrl, boolean isUrl);

    /**
     * 银行卡OCR识别接口，文件大小限制：小于2M
     *
     * @param imagePathOrUrl 图片文件或者url
     * @param isUrl          imagePathOrUrl是否为url
     * @return 银行卡别结果
     * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/Intelligent_Interface/OCR.html" target="_blank">微信官方接口文档</a>
     */
    WxOcrBankCardResult ocrBankCard(String imagePathOrUrl, boolean isUrl);

    /**
     * 行驶证OCR识别接口，文件大小限制：小于2M
     *
     * @param imagePathOrUrl 图片文件或者url
     * @param isUrl          imagePathOrUrl是否为url
     * @return 行驶证识别结果
     * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/Intelligent_Interface/OCR.html" target="_blank">微信官方接口文档</a>
     */
    WxOcrDrivingCardResult ocrDrivingCard(String imagePathOrUrl, boolean isUrl);

    /**
     * 驾驶证OCR识别接口，文件大小限制：小于2M
     *
     * @param imagePathOrUrl 图片文件或者url
     * @param isUrl          imagePathOrUrl是否为url
     * @return 驾驶证识别结果
     * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/Intelligent_Interface/OCR.html" target="_blank">微信官方接口文档</a>
     */
    WxOcrDrivingLicenseCardResult ocrDrivingLicenseCard(String imagePathOrUrl, boolean isUrl);

    /**
     * 营业执照OCR识别接口，文件大小限制：小于2M
     *
     * @param imagePathOrUrl 图片文件或者url
     * @param isUrl          imagePathOrUrl是否为url
     * @return 营业执照识别结果
     * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/Intelligent_Interface/OCR.html" target="_blank">微信官方接口文档</a>
     */
    WxOcrBizLicenseResult ocrBizLicense(String imagePathOrUrl, boolean isUrl);


    /**
     * 通用印刷体OCR识别接口，文件大小限制：小于2M
     *
     * @param imagePathOrUrl 图片文件或者url
     * @param isUrl          imagePathOrUrl是否为url
     * @return 通用印刷体识别结果
     * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/Intelligent_Interface/OCR.html" target="_blank">微信官方接口文档</a>
     */
    WxOcrCommonResult ocrCommon(String imagePathOrUrl, boolean isUrl);

    /**
     * 二维码/条码识别接口，文件大小限制：小于2M
     *
     * @param imagePathOrUrl 图片文件或者url
     * @param isUrl          imagePathOrUrl是否为url
     * @return 二维码/条码识别结果
     * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/Intelligent_Interface/Img_Proc.html" target="_blank">微信官方接口文档</a>
     */
    WxOcrQrCodeResult ocrQrCode(String imagePathOrUrl, boolean isUrl);

    /**
     * 图片高清化接口，文件大小限制：小于2M
     *
     * @param imagePathOrUrl 图片文件或者url
     * @param isUrl          imagePathOrUrl是否为url
     * @return 图片高清化结果
     * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/Intelligent_Interface/Img_Proc.html" target="_blank">微信官方接口文档</a>
     */
    WxImageSuperResolutionResult imageSuperResolution(String imagePathOrUrl, boolean isUrl);

    /**
     * 图片智能裁剪接口，文件大小限制：小于2M
     *
     * @param imagePathOrUrl 图片文件或者url
     * @param isUrl          imagePathOrUrl是否为url
     * @param ratios         ratios参数为可选，如果为null，则算法自动裁剪最佳宽高比；如果提供多个宽高比，请以英文逗号“,”分隔，最多支持5个宽高比
     * @return 图片高清化结果
     * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/Intelligent_Interface/Img_Proc.html" target="_blank">微信官方接口文档</a>
     */
    WxImageAiCropResult imageAiCrop(String imagePathOrUrl, boolean isUrl, String ratios);
}
