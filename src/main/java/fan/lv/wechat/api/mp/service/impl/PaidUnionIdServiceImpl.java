package fan.lv.wechat.api.mp.service.impl;

import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.mp.service.PaidUnionIdService;
import fan.lv.wechat.entity.mp.user.WxPaidUnionIdResult;
import fan.lv.wechat.util.SimpleMap;

/**
 * @author lv_fan2008
 */
public class PaidUnionIdServiceImpl implements PaidUnionIdService {

    /**
     * 请求客户端
     */
    protected Client client;


    /**
     * @param client 请求客户端
     */
    public PaidUnionIdServiceImpl(Client client) {
        this.client = client;
    }

    @Override
    public WxPaidUnionIdResult getPaidUnionId(String openId, String transactionId, String mchId, String outTradeNo) {
        return client.get("/wxa/getpaidunionid",
                SimpleMap.of("openid", openId, "transaction_id", transactionId,
                        "mch_id", mchId, "out_trade_no", outTradeNo),
                WxPaidUnionIdResult.class);
    }
}
