package fan.lv.wechat.api.payment.service.impl;

import fan.lv.wechat.api.payment.service.EnterprisePayService;
import fan.lv.wechat.entity.pay.config.WxPayConfig;
import fan.lv.wechat.entity.pay.enterprisepay.*;
import fan.lv.wechat.util.SimpleMap;
import fan.lv.wechat.util.pay.WxPayConstants;
import fan.lv.wechat.util.pay.WxPayUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @author lv_fan2008
 */
@Slf4j
public class EnterprisePayServiceImpl extends PayClientImpl implements EnterprisePayService {

    public EnterprisePayServiceImpl(WxPayConfig payConfig) {
        super(payConfig);
    }

    /**
     * 添加请求必要信息
     *
     * @param reqData 请求数据
     * @return 请求数据
     * @throws Exception 异常
     */
    @Override
    protected Map<String, String> fullRequest(Map<String, String> reqData) throws Exception {
        reqData.put("nonce_str", WxPayUtil.generateNonceStr());
        return reqData;
    }

    @Override
    public WxEnterprisePayResult enterprisePay(String partnerTradeNo, String openId, String checkName, Integer amount,
                                               String desc, Map<String, String> others) {
        SimpleMap<String, String> map = SimpleMap.of("partner_trade_no", partnerTradeNo)
                .add("openid", openId)
                .add("check_name", checkName)
                .add("amount", amount.toString())
                .add("desc", desc.toString())
                .add("mch_appid", payConfig.getAppId())
                .add("mchid", payConfig.getMchId())
                .addAll(others);
        return postXml("/mmpaymkttransfers/promotion/transfers", map, WxEnterprisePayResult.class, defSslOpts());
    }

    @Override
    public WxQueryEnterprisePayResult queryEnterprisePay(String partnerTradeNo) {
        SimpleMap<String, String> map = SimpleMap.of("partner_trade_no", partnerTradeNo)
                .add("appid", payConfig.getAppId())
                .add("mch_id", payConfig.getMchId());
        return postXml("/mmpaymkttransfers/promotion/transfers", map, WxQueryEnterprisePayResult.class, defSslOpts());
    }

    @Override
    public WxEnterprisePayToBankCardResult enterprisePayToBankCard(String partnerTradeNo, String encBankNo, String encTrueName,
                                                                   String bankCode, Integer amount, String desc) {
        SimpleMap<String, String> map = SimpleMap.of("partner_trade_no", partnerTradeNo)
                .add("mch_id", payConfig.getMchId())
                .add("enc_bank_no", encBankNo)
                .add("enc_true_name", encTrueName)
                .add("bank_code", bankCode)
                .add("amount", amount.toString())
                .add("desc", desc);
        return postXml("/mmpaysptrans/pay_bank", map, WxEnterprisePayToBankCardResult.class, defSslOpts());
    }

    @Override
    public WxQueryPayToBankCardResult queryEnterprisePayToBankCard(String partnerTradeNo) {
        SimpleMap<String, String> map = SimpleMap.of("partner_trade_no", partnerTradeNo)
                .add("mch_id", payConfig.getMchId());
        return postXml("/mmpaysptrans/query_bank", map, WxQueryPayToBankCardResult.class, defSslOpts());
    }

    @Override
    public WxGetPubKeyResult getPubKey() {
        SimpleMap<String, String> map = SimpleMap.of("mch_id", payConfig.getMchId());
        return postXml("/risk/getpublickey", map, WxGetPubKeyResult.class, defSslOpts());
    }
}
