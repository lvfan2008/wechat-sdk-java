package fan.lv.wechat.api.payment.v2;

import fan.lv.wechat.api.kernel.impl.ContainerImpl;
import fan.lv.wechat.api.payment.v2.service.PaymentService;
import fan.lv.wechat.api.payment.v2.service.impl.PayClientImpl;
import fan.lv.wechat.api.payment.v2.service.impl.PaymentServiceImpl;
import fan.lv.wechat.entity.pay.config.WxPayConfig;

/**
 * @author lv_fan2008
 */
public class PaymentApp extends ContainerImpl {
    /**
     * @param config 支付设置
     */
    public PaymentApp(WxPayConfig config) {
        PayClient client = new PayClientImpl(config);
        this.bind(WxPayConfig.class, () -> config);
        this.bind(PayClient.class, () -> client);
        this.bind(PaymentService.class, () -> new PaymentServiceImpl(client, config));
    }
}