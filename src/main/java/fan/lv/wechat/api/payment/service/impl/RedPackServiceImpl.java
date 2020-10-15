package fan.lv.wechat.api.payment.service.impl;

import fan.lv.wechat.api.payment.service.CouponService;
import fan.lv.wechat.api.payment.service.RedPackService;
import fan.lv.wechat.entity.pay.config.WxPayConfig;
import fan.lv.wechat.entity.pay.coupon.WxCouponInfoResult;
import fan.lv.wechat.entity.pay.coupon.WxQueryCouponStockResult;
import fan.lv.wechat.entity.pay.coupon.WxSendCouponResult;
import fan.lv.wechat.entity.pay.payment.WxMicroPayResult;
import fan.lv.wechat.entity.pay.payment.WxSandboxSignKeyResult;
import fan.lv.wechat.entity.pay.redpack.WxGetRedPackResult;
import fan.lv.wechat.entity.pay.redpack.WxMpSendRedPackResult;
import fan.lv.wechat.entity.pay.redpack.WxSendRedPackResult;
import fan.lv.wechat.util.RequestOptions;
import fan.lv.wechat.util.SimpleMap;
import fan.lv.wechat.util.pay.WxPayConstants;
import fan.lv.wechat.util.pay.WxPayUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @author lv_fan2008
 */
@Slf4j
public class RedPackServiceImpl extends PayClientImpl implements RedPackService {

    public RedPackServiceImpl(WxPayConfig payConfig) {
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
        WxPayConstants.SignType signType = WxPayConstants.MD5.equals(payConfig.getSignType()) ? WxPayConstants.SignType.MD5
                : WxPayConstants.SignType.HMACSHA256;
        reqData.put("wxappid", payConfig.getAppId());
        reqData.put("mch_id", payConfig.getMchId());
        reqData.put("nonce_str", WxPayUtil.generateNonceStr());
        reqData.put("sub_mch_id", payConfig.getSubMchId());
        reqData.put("msgappid", payConfig.getSubAppId());
        reqData.put("sign_type", payConfig.getSignType());
        reqData = filterBlank(reqData);
        reqData.put("sign", WxPayUtil.generateSignature(reqData, payConfig.getKey(), signType));
        return reqData;
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
                .addAll(others);
        return postXml("/mmpaymkttransfers/sendredpack", map, WxSendRedPackResult.class, defSslOpts());
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
                .addAll(others);
        return postXml("/mmpaymkttransfers/sendgroupredpack", map, WxSendRedPackResult.class, defSslOpts());
    }

    @Override
    public WxGetRedPackResult getRedPack(String mchBillNo, String billType) {
        try {
            WxPayConstants.SignType signType = WxPayConstants.MD5.equals(payConfig.getSignType()) ? WxPayConstants.SignType.MD5
                    : WxPayConstants.SignType.HMACSHA256;
            SimpleMap<String, String> map = SimpleMap.of("nonce_str", WxPayUtil.generateNonceStr())
                    .add("mch_billno", mchBillNo)
                    .add("mch_id", payConfig.getMchId())
                    .add("appid", payConfig.getMchId())
                    .add("bill_type", billType);
            map.add("sign", WxPayUtil.generateSignature(map, payConfig.getKey(), signType));
            return request("/mmpaymkttransfers/gethbinfo", defSslOpts().body(WxPayUtil.mapToXml(map))
                    .mimeType("application/xml"), WxGetRedPackResult.class);
        } catch (Exception e) {
            return errorResult(-1, e.getMessage(), WxGetRedPackResult.class);
        }
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
                .addAll(others);
        return postXml("/mmpaymkttransfers/sendminiprogramhb", map, WxMpSendRedPackResult.class, defSslOpts());
    }
}
