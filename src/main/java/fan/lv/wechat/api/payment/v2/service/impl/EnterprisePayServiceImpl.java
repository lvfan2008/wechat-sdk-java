package fan.lv.wechat.api.payment.v2.service.impl;

import fan.lv.wechat.api.payment.v2.PayClient;
import fan.lv.wechat.api.payment.v2.service.EnterprisePayService;
import fan.lv.wechat.entity.pay.config.WxPayConfig;
import fan.lv.wechat.entity.pay.enterprisepay.*;
import fan.lv.wechat.util.SimpleMap;
import fan.lv.wechat.util.pay.WxPayUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @author lv_fan2008
 */
@Slf4j
public class EnterprisePayServiceImpl extends BaseService implements EnterprisePayService {


    public EnterprisePayServiceImpl(PayClient client, WxPayConfig payConfig) {
        super(client, payConfig);
    }

    /**
     * 默认初始化数据
     *
     * @return 初始化数据
     */
    protected SimpleMap<String, String> defData() {
        return SimpleMap.of("nonce_str", WxPayUtil.generateNonceStr());
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
                .addAll(others).addAll(defData());
        return client.postXml("/mmpaymkttransfers/promotion/transfers", map, WxEnterprisePayResult.class, defSslOpts());
    }

    @Override
    public WxQueryEnterprisePayResult queryEnterprisePay(String partnerTradeNo) {
        SimpleMap<String, String> map = SimpleMap.of("partner_trade_no", partnerTradeNo)
                .add("appid", payConfig.getAppId())
                .add("mch_id", payConfig.getMchId()).addAll(defData());
        return client.postXml("/mmpaymkttransfers/gettransferinfo", map, WxQueryEnterprisePayResult.class, defSslOpts());
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
                .add("desc", desc)
                .addAll(defData());
        return client.postXml("/mmpaysptrans/pay_bank", map, WxEnterprisePayToBankCardResult.class, defSslOpts());
    }

    @Override
    public WxQueryPayToBankCardResult queryEnterprisePayToBankCard(String partnerTradeNo) {
        SimpleMap<String, String> map = SimpleMap.of("partner_trade_no", partnerTradeNo)
                .add("mch_id", payConfig.getMchId()).addAll(defData());
        return client.postXml("/mmpaysptrans/query_bank", map, WxQueryPayToBankCardResult.class, defSslOpts());
    }

    @Override
    public WxGetPubKeyResult getPubKey() {
        SimpleMap<String, String> map = SimpleMap.of("mch_id", payConfig.getMchId()).addAll(defData());
        return client.postXml("https://fraud.mch.weixin.qq.com/risk/getpublickey", map, WxGetPubKeyResult.class, defSslOpts());
    }
}
