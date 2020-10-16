package fan.lv.wechat.api.payment.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import fan.lv.wechat.api.payment.service.ProfitShareService;
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
public class ProfitShareServiceImpl extends PayClientImpl implements ProfitShareService {

    public ProfitShareServiceImpl(WxPayConfig payConfig) {
        super(payConfig);
    }

    @Override
    public WxProfitShareResult profitShare(String transactionId, String outOrderNo, List<WxReceiver> receivers,
                                           Map<String, String> others) {
        SimpleMap<String, String> map = SimpleMap.of("transaction_id", transactionId,
                "out_order_no", outOrderNo,
                "receivers", JsonUtil.toJson(receivers),
                "sign_type", "HMAC-SHA256")
                .addAll(others);
        return postXml("/secapi/pay/profitsharing", map, WxProfitShareResult.class, defSslOpts());
    }

    @Override
    public WxProfitShareResult multiProfitShare(String transactionId, String outOrderNo, List<WxReceiver> receivers, Map<String, String> others) {
        SimpleMap<String, String> map = SimpleMap.of("transaction_id", transactionId,
                "out_order_no", outOrderNo,
                "receivers", JsonUtil.toJson(receivers),
                "sign_type", "HMAC-SHA256")
                .addAll(others);
        return postXml("/secapi/pay/multiprofitsharing", map, WxProfitShareResult.class, defSslOpts());
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

        WxQueryProfitShareResult result = postXml("/pay/profitsharingquery", map, false,
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
                "sign_type", "HMAC-SHA256");

        WxAddReceiversResult result = postXml("/pay/profitsharingaddreceiver", map, WxAddReceiversResult.class, defOpts());
        if (result.success() && result.resultSuccess() && result.getReceiver() != null) {
            result.setDecodeReceiver(JsonUtil.parseJson(result.getReceiver(), WxReceiverForAdd.class));
        }
        return result;
    }

    @Override
    public WxDeleteReceiverResult deleteReceivers(WxReceiverForDelete receiver) {
        SimpleMap<String, String> map = SimpleMap.of("receiver", JsonUtil.toJson(receiver),
                "sign_type", "HMAC-SHA256");

        WxDeleteReceiverResult result = postXml("/pay/profitsharingaddreceiver", map, WxDeleteReceiverResult.class, defOpts());
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
                "sign_type", "HMAC-SHA256");
        return postXml("/secapi/pay/profitsharingfinish", map, WxProfitShareResult.class, defSslOpts());
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
                .add("return_amount", returnAmount.toString());
        return postXml("/secapi/pay/profitsharingreturn", map, WxReturnProfitShareResult.class, defSslOpts());
    }

    @Override
    public WxReturnProfitShareResult queryReturnProfitShare(String orderId, String outOrderNo, String outReturnNo) {
        SimpleMap<String, String> map = SimpleMap.of("order_id", orderId)
                .add("out_order_no", outOrderNo)
                .add("out_return_no", outReturnNo)
                .add("sign_type", "HMAC-SHA256");
        return postXml("/pay/profitsharingreturnquery", map, WxReturnProfitShareResult.class, defOpts());
    }
}
