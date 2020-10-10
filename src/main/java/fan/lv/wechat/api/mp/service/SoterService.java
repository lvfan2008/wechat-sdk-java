package fan.lv.wechat.api.mp.service;

import fan.lv.wechat.entity.mp.soter.WxVerifySignatureResult;

/**
 * @author lv_fan2008
 */
public interface SoterService {

    /**
     * SOTER 生物认证秘钥签名验证
     *
     * @param openId          用户 openid
     * @param resultJson      通过 wx.startSoterAuthentication 成功回调获得的 resultJSON 字段
     * @param resultSignature 通过 wx.startSoterAuthentication 成功回调获得的 resultJSONSignature 字段
     * @return 签名验证结果
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/soter/soter.verifySignature.html" target="_blank">微信官方文档</a>
     */
    WxVerifySignatureResult verifySignature(String openId, String resultJson, String resultSignature);
}
