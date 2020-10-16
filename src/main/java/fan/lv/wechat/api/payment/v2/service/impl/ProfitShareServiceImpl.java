package fan.lv.wechat.api.payment.v2.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import fan.lv.wechat.api.payment.v2.PayClient;
import fan.lv.wechat.api.payment.v2.service.ProfitShareService;
import fan.lv.wechat.entity.pay.config.WxPayConfig;
import fan.lv.wechat.entity.pay.profitshare.*;
import fan.lv.wechat.util.JsonUtil;
import fan.lv.wechat.util.SimpleMap;
import fan.lv.wechat.util.pay.WxPayUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

/**
 * @author lv_fan2008
 */
@Slf4j
public class ProfitShareServiceImpl extends BaseService implements ProfitShareService {


    public ProfitShareServiceImpl(PayClient client, WxPayConfig payConfig) {
        super(client, payConfig);
    }

    /**
     * 默认初始化数据
     *
     * @return 初始化数据
     */
    protected SimpleMap<String, String> defData() {
        return SimpleMap.of("appid", payConfig.getAppId())
                .add("mch_id", payConfig.getMchId())
                .add("nonce_str", WxPayUtil.generateNonceStr())
                .add("sub_mch_id", payConfig.getSubMchId())
                .add("sub_appid", payConfig.getSubAppId());
    }

    @Override
    public WxProfitShareResult profitShare(String transactionId, String outOrderNo, List<WxReceiver> receivers,
                                           Map<String, String> others) {
        SimpleMap<String, String> map = SimpleMap.of("transaction_id", transactionId,
                "out_order_no", outOrderNo,
                "receivers", JsonUtil.toJson(receivers),
                "sign_type", "HMAC-SHA256")
                .addAll(others)
                .addAll(defData());
        return client.postXml("/secapi/pay/profitsharing", map, WxProfitShareResult.class, defSslOpts());
    }

    @Override
    public WxProfitShareResult multiProfitShare(String transactionId, String outOrderNo, List<WxReceiver> receivers, Map<String, String> others) {
        SimpleMap<String, String> map = SimpleMap.of("transaction_id", transactionId,
                "out_order_no", outOrderNo,
                "receivers", JsonUtil.toJson(receivers),
                "sign_type", "HMAC-SHA256")
                .addAll(others)
                .addAll(defData());
        return client.postXml("/secapi/pay/multiprofitsharing", map, WxProfitShareResult.class, defSslOpts());
    }

    @Override
    public WxQueryProfitShareResult queryProfitShare(String transactionId, String outOrderNo) {
        SimpleMap<String, String> map = SimpleMap.of(
                "transaction_id", transactionId,
                "out_order_no", outOrderNo,
                "nonce_str", WxPayUtil.generateNonceStr(),
                "mch_id", payConfig.getMchId(),
                "sign_type", "HMAC-SHA256"
        );

        WxQueryProfitShareResult result = client.postXml("/pay/profitsharingquery", map,
                WxQueryProfitShareResult.class, defOpts());

        if (result.success() && result.resultSuccess() && result.getReceivers() != null) {
            result.setDecodeReceivers(JsonUtil.parseJson(result.getReceivers(),
                    new TypeReference<List<WxReceiverForQuery>>() {
                    }));
        }
        return result;
    }

    @Override
    public WxAddReceiversResult addReceivers(WxReceiverForAdd receiver) {
        SimpleMap<String, String> map = SimpleMap.of("receiver", JsonUtil.toJson(receiver),
                "sign_type", "HMAC-SHA256").addAll(defData());

        WxAddReceiversResult result = client.postXml("/pay/profitsharingaddreceiver", map, WxAddReceiversResult.class, defOpts());
        if (result.success() && result.resultSuccess() && result.getReceiver() != null) {
            result.setDecodeReceiver(JsonUtil.parseJson(result.getReceiver(), WxReceiverForAdd.class));
        }
        return result;
    }

    @Override
    public WxDeleteReceiverResult deleteReceivers(WxReceiverForDelete receiver) {
        SimpleMap<String, String> map = SimpleMap.of("receiver", JsonUtil.toJson(receiver),
                "sign_type", "HMAC-SHA256").addAll(defData());

        WxDeleteReceiverResult result = client.postXml("/pay/profitsharingaddreceiver", map, WxDeleteReceiverResult.class, defOpts());
        if (result.success() && result.resultSuccess() && result.getReceiver() != null) {
            result.setDecodeReceiver(JsonUtil.parseJson(result.getReceiver(), WxReceiverForDelete.class));
        }
        return result;
    }

    @Override
    public WxProfitShareResult finishProfitShare(String transactionId, String outOrderNo, String description) {
        SimpleMap<String, String> map = SimpleMap.of("transaction_id", transactionId,
                "out_order_no", outOrderNo,
                "description", description,
                "sign_type", "HMAC-SHA256")
                .addAll(defData());
        return client.postXml("/secapi/pay/profitsharingfinish", map, WxProfitShareResult.class, defSslOpts());
    }

    @Override
    public WxReturnProfitShareResult returnProfitShare(String orderId, String outOrderNo, String outReturnNo,
                                                       String returnAccountType, String returnAccount, Integer returnAmount,
                                                       String description) {
        SimpleMap<String, String> map = SimpleMap.of("order_id", orderId)
                .add("out_order_no", outOrderNo)
                .add("description", description)
                .add("out_return_no", outReturnNo)
                .add("sign_type", "HMAC-SHA256")
                .add("return_account_type", returnAccountType)
                .add("return_account", returnAccount)
                .add("return_amount", returnAmount.toString())
                .addAll(defData());
        return client.postXml("/secapi/pay/profitsharingreturn", map, WxReturnProfitShareResult.class, defSslOpts());
    }

    @Override
    public WxReturnProfitShareResult queryReturnProfitShare(String orderId, String outOrderNo, String outReturnNo) {
        SimpleMap<String, String> map = SimpleMap.of("order_id", orderId)
                .add("out_order_no", outOrderNo)
                .add("out_return_no", outReturnNo)
                .add("sign_type", "HMAC-SHA256")
                .addAll(defData());
        return client.postXml("/pay/profitsharingreturnquery", map, WxReturnProfitShareResult.class, defOpts());
    }
}
