package fan.lv.wechat.api.payment;

import fan.lv.wechat.api.kernel.impl.ContainerImpl;
import fan.lv.wechat.api.payment.service.PaymentService;
import fan.lv.wechat.api.payment.service.impl.PaymentServiceImpl;
import fan.lv.wechat.entity.pay.config.WxPayConfig;

/**
 * @author lv_fan2008
 */
public class PaymentApp extends ContainerImpl {
    /**
     * @param config 支付设置
     */
    public PaymentApp(WxPayConfig config) {
        this.bind(WxPayConfig.class, () -> config);
        this.bind(PaymentService.class, () -> new PaymentServiceImpl(config));
    }
}