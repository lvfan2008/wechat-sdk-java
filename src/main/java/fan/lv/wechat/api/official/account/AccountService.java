package fan.lv.wechat.api.official.account;

import fan.lv.wechat.entity.official.account.WxCreateQrCodeResult;
import fan.lv.wechat.entity.official.account.WxGetShortUrlResult;

/**
 * 账号管理
 *
 * @author lv_fan2008
 */
public interface AccountService {

    /**
     * 创建二维码
     *
     * @param expireSeconds 临时二维码可用，该二维码有效时间，以秒为单位。 最大不超过2592000（即30天），此字段如果不填，则默认有效期为30秒
     * @param actionName    二维码类型，
     *                      <p>
     *                      QR_SCENE为临时的整型参数值，
     *                      <p>
     *                      QR_STR_SCENE为临时的字符串参数值，
     *                      <p>
     *                      QR_LIMIT_SCENE为永久的整型参数值，
     *                      <p>
     *                      QR_LIMIT_STR_SCENE为永久的字符串参数值
     * @param sceneId       场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000）
     * @param sceneStr      场景值ID（字符串形式的ID），字符串类型，长度限制为1到64
     * @return 二维码ticket和url
     * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/Account_Management/Generating_a_Parametric_QR_Code.html" target="_blank">微信官方接口文档</a>
     */
    WxCreateQrCodeResult createQrCode(Integer expireSeconds, String actionName, Integer sceneId, String sceneStr);

    /**
     * 将一条长链接转成短链接。
     *
     * @param longUrl 长链接
     * @return 短链接。
     * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/Account_Management/URL_Shortener.html" target="_blank">微信官方接口文档</a>
     */
    WxGetShortUrlResult getShortUrl(String longUrl);
}
