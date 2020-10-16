package fan.lv.wechat.api.payment.v2.service.impl;

import fan.lv.wechat.api.payment.v2.PayClient;
import fan.lv.wechat.entity.pay.config.WxPayConfig;
import fan.lv.wechat.util.RequestOptions;
import fan.lv.wechat.util.SslCert;

/**
 * 服务基类
 */
public class BaseService {
    /**
     * 客户端
     */
    PayClient client;

    WxPayConfig payConfig;

    public BaseService(PayClient client, WxPayConfig payConfig) {
        this.client = client;
        this.payConfig = payConfig;
    }

    protected RequestOptions defOpts() {
        return RequestOptions.defOpts();
    }

    protected RequestOptions defSslOpts() {
        return RequestOptions.defOpts().sslCert(new SslCert(payConfig.getMchId(), payConfig.getCertBytes()));
    }
}
