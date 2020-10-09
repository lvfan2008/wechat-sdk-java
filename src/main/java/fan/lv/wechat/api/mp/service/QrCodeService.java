package fan.lv.wechat.api.mp.service;

import fan.lv.wechat.entity.mp.qrcode.WxGetMpCodeParam;
import fan.lv.wechat.entity.mp.qrcode.WxGetUnlimitedMpCodeParam;
import fan.lv.wechat.entity.result.WxResult;

/**
 * 小程序码服务
 *
 * @author lv_fan2008
 */
public interface QrCodeService {
    /**
     * 获取小程序二维码，适用于需要的码数量较少的业务场景。通过该接口生成的小程序码，永久有效，有数量限制，
     *
     * @param path  扫码进入的小程序页面路径，最大长度 128 字节，不能为空；对于小游戏，可以只传入 query 部分，来实现传参效果，如：传入 "?foo=bar"，即可在 wx.getLaunchOptionsSync 接口中的 query 参数获取到 {foo:"bar"}。
     * @param width 二维码的宽度，单位 px。最小 280px，最大 1280px
     * @return 成功返回图片流到WxResult.content
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/qr-code/wxacode.createQRCode.html" target="_blank">微信官方文档</a>
     */
    WxResult createQrCode(String path, Integer width);

    /**
     * 获取小程序码，适用于需要的码数量较少的业务场景。通过该接口生成的小程序码，永久有效，有数量限制。
     *
     * @param param 获取小程序码参数
     * @return 成功返回图片流到WxResult.content
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/qr-code/wxacode.get.html" target="_blank">微信官方文档</a>
     */
    WxResult get(WxGetMpCodeParam param);


    /**
     * 获取小程序码，适用于需要的码数量极多的业务场景。通过该接口生成的小程序码，永久有效，数量暂无限制。
     *
     * @param param 获取无限制小程序码参数
     * @return 成功返回图片流到WxResult.content
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/qr-code/wxacode.getUnlimited.html" target="_blank">微信官方文档</a>
     */
    WxResult getUnlimited(WxGetUnlimitedMpCodeParam param);
}
