package fan.lv.wechat.api.mp.service;

import fan.lv.wechat.entity.mp.user.WxPaidUnionIdResult;
import fan.lv.wechat.entity.mp.user.WxSessionResult;

/**
 * @author lv_fan2008
 */
public interface PaidUnionIdService {

    /**
     * 支付后，通过微信支付单号获取UnionId
     *
     * @param openId        支付用户唯一标识
     * @param transactionId 微信支付订单号
     * @return 返回结果
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/user-info/auth.getPaidUnionId.html" target="_blank">微信官方文档</a>
     */
    default WxPaidUnionIdResult getPaidUnionId(String openId, String transactionId) {
        return getPaidUnionId(openId, transactionId, null, null);
    }

    /**
     * 支付后，通过商户号和商户订单号获取UnionId
     *
     * @param openId     支付用户唯一标识
     * @param mchId      微信支付分配的商户号，和商户订单号配合使用
     * @param outTradeNo 微信支付商户订单号，和商户号配合使用
     * @return 返回结果
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/user-info/auth.getPaidUnionId.html" target="_blank">微信官方文档</a>
     */
    default WxPaidUnionIdResult getPaidUnionId(String openId, String mchId, String outTradeNo) {
        return getPaidUnionId(openId, null, mchId, outTradeNo);
    }

    /**
     * 支付后，获取UnionId，transactionId 和 mchId、outTradeNo二选一
     *
     * @param openId        支付用户唯一标识
     * @param transactionId 微信支付订单号
     * @param mchId         微信支付分配的商户号，和商户订单号配合使用
     * @param outTradeNo    微信支付商户订单号，和商户号配合使用
     * @return 返回结果
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/user-info/auth.getPaidUnionId.html" target="_blank">微信官方文档</a>
     */
    WxPaidUnionIdResult getPaidUnionId(String openId, String transactionId, String mchId, String outTradeNo);
}
