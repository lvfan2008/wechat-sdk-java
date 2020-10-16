package fan.lv.wechat.api.payment.v2.service.impl;

import fan.lv.wechat.api.payment.v2.PayClient;
import fan.lv.wechat.api.payment.v2.service.RedPackService;
import fan.lv.wechat.entity.pay.config.WxPayConfig;
import fan.lv.wechat.entity.pay.redpack.WxGetRedPackResult;
import fan.lv.wechat.entity.pay.redpack.WxMpSendRedPackResult;
import fan.lv.wechat.entity.pay.redpack.WxSendRedPackResult;
import fan.lv.wechat.util.SimpleMap;
import fan.lv.wechat.util.pay.WxPayUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @author lv_fan2008
 */
@Slf4j
public class RedPackServiceImpl extends BaseService implements RedPackService {


    public RedPackServiceImpl(PayClient client, WxPayConfig payConfig) {
        super(client, payConfig);
    }

    /**
     * 默认初始化数据
     *
     * @return 初始化数据
     */
    protected SimpleMap<String, String> defData() {
        return SimpleMap.of("wxappid", payConfig.getAppId())
                .add("mch_id", payConfig.getMchId())
                .add("nonce_str", WxPayUtil.generateNonceStr())
                .add("sub_mch_id", payConfig.getSubMchId())
                .add("msgappid", payConfig.getSubAppId());
    }


    @Override
    public WxSendRedPackResult sendRedPack(String mchBillNo, String sendName, String reOpenId, Integer totalAmount,
                                           Integer totalNum, String wishing, String clientIp, String actName,
                                           String remark, Map<String, String> others) {
        SimpleMap<String, String> map = SimpleMap.of("mch_billno", mchBillNo)
                .add("send_name", sendName)
                .add("re_openid", reOpenId)
                .add("total_amount", totalAmount.toString())
                .add("total_num", totalNum.toString())
                .add("wishing", wishing)
                .add("client_ip", clientIp)
                .add("act_name", actName)
                .add("remark", remark)
                .addAll(others)
                .addAll(defData());
        return client.postXml("/mmpaymkttransfers/sendredpack", map, WxSendRedPackResult.class, defSslOpts());
    }

    @Override
    public WxSendRedPackResult sendGroupRedPack(String mchBillNo, String sendName, String reOpenId, Integer totalAmount,
                                                Integer totalNum, String wishing, String amtType, String clientIp,
                                                String actName, String remark, Map<String, String> others) {
        SimpleMap<String, String> map = SimpleMap.of("mch_billno", mchBillNo)
                .add("send_name", sendName)
                .add("re_openid", reOpenId)
                .add("total_amount", totalAmount.toString())
                .add("total_num", totalNum.toString())
                .add("wishing", wishing)
                .add("amt_type", amtType)
                .add("client_ip", clientIp)
                .add("act_name", actName)
                .add("remark", remark)
                .addAll(others)
                .addAll(defData());
        return client.postXml("/mmpaymkttransfers/sendgroupredpack", map, WxSendRedPackResult.class, defSslOpts());
    }

    @Override
    public WxGetRedPackResult getRedPack(String mchBillNo, String billType) {
        SimpleMap<String, String> map = SimpleMap.of("nonce_str", WxPayUtil.generateNonceStr())
                .add("mch_billno", mchBillNo)
                .add("mch_id", payConfig.getMchId())
                .add("appid", payConfig.getAppId())
                .add("bill_type", billType);
        return client.postXml("/mmpaymkttransfers/gethbinfo", map, WxGetRedPackResult.class, defSslOpts());
    }

    @Override
    public WxMpSendRedPackResult sendMpRedPack(String mchBillNo, String sendName, String reOpenId, Integer totalAmount,
                                               Integer totalNum, String wishing, String clientIp, String actName,
                                               String remark, String notifyWay, Map<String, String> others) {
        SimpleMap<String, String> map = SimpleMap.of("mch_billno", mchBillNo)
                .add("send_name", sendName)
                .add("re_openid", reOpenId)
                .add("total_amount", totalAmount.toString())
                .add("total_num", totalNum.toString())
                .add("wishing", wishing)
                .add("client_ip", clientIp)
                .add("act_name", actName)
                .add("notify_way", notifyWay)
                .add("remark", remark)
                .addAll(others)
                .addAll(defData());
        return client.postXml("/mmpaymkttransfers/sendminiprogramhb", map, WxMpSendRedPackResult.class, defSslOpts());
    }
}
