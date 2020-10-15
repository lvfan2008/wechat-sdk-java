package fan.lv.wechat.api.payment.service.impl;

import fan.lv.wechat.api.payment.service.EnterprisePayService;
import fan.lv.wechat.entity.pay.config.WxPayConfig;
import fan.lv.wechat.entity.pay.enterprisepay.WxEnterprisePayResult;
import fan.lv.wechat.entity.pay.enterprisepay.WxQueryEnterprisePayResult;
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
}
