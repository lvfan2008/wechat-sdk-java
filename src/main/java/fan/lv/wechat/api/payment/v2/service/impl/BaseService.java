package fan.lv.wechat.api.payment.v2.service.impl;

import fan.lv.wechat.api.payment.v2.PayClientV2;
import fan.lv.wechat.entity.pay.base.WxBasePayResult;
import fan.lv.wechat.entity.pay.config.WxPayConfig;
import fan.lv.wechat.util.RequestOptions;
import fan.lv.wechat.util.SimpleHttpResp;
import fan.lv.wechat.util.SslCert;
import fan.lv.wechat.util.XmlUtil;
import fan.lv.wechat.util.pay.WxPayUtil;

import java.nio.charset.StandardCharsets;

/**
 * 服务基类
 */
public class BaseService {
    /**
     * 客户端
     */
    PayClientV2 client;

    WxPayConfig payConfig;

    public BaseService(PayClientV2 client, WxPayConfig payConfig) {
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
