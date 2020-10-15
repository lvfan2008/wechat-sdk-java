package fan.lv.wechat.api.payment.service;

import fan.lv.wechat.entity.pay.enterprisepay.WxEnterprisePayResult;
import fan.lv.wechat.entity.pay.enterprisepay.WxEnterprisePayToBankCardResult;
import fan.lv.wechat.entity.pay.enterprisepay.WxQueryEnterprisePayResult;

import java.util.Map;

/**
 * 企业付款
 *
 * @author lv_fan2008
 */
public interface EnterprisePayService {
    /**
     * 企业付款
     *
     * @param partnerTradeNo 商户订单号，需保持唯一性 (只能是字母或者数字，不能包含有其它字符)
     * @param openId         商户appid下，某用户的openid
     * @param checkName      NO_CHECK：不校验真实姓名 FORCE_CHECK：强校验真实姓名
     * @param amount         企业付款金额，单位为分
     * @param desc           企业付款备注，必填。注意：备注中的敏感词会被转成字符*
     * @param others         其他参数
     * @return 企业付款结果
     */
    WxEnterprisePayResult enterprisePay(String partnerTradeNo, String openId, String checkName,
                                        Integer amount, String desc, Map<String, String> others);


    /**
     * 查询企业付款
     *
     * @param partnerTradeNo 商户调用企业付款API时使用的商户订单号
     * @return 查询企业付款结果
     */
    WxQueryEnterprisePayResult queryEnterprisePay(String partnerTradeNo);


    /**
     * 企业付款到银行卡
     * @param partnerTradeNo 商户订单号，需保持唯一（只允许数字[0~9]或字母[A~Z]和[a~z]，最短8位，最长32位）
     * @param encBankNo
     * @param encTrueName
     * @param bankCode
     * @param amount
     * @param desc
     * @return
     */
    WxEnterprisePayToBankCardResult EnterprisePayToBankCard(String partnerTradeNo, String encBankNo, String encTrueName,
                                                            String bankCode, Integer amount, String desc);
}
