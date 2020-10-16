package fan.lv.wechat.api.payment.v2;

import fan.lv.wechat.api.kernel.impl.ContainerImpl;
import fan.lv.wechat.api.payment.v2.service.PaymentService;
import fan.lv.wechat.api.payment.v2.service.impl.PaymentServiceImpl;
import fan.lv.wechat.entity.pay.config.WxPayConfig;

/**
 * @author lv_fan2008
 */
public class PaymentAppV2 extends ContainerImpl {
    /**
     * @param config 支付设置
     */
    public PaymentAppV2(WxPayConfig config) {
        this.bind(WxPayConfig.class, () -> config);
        this.bind(PaymentService.class, () -> new PaymentServiceImpl(config));
    }
}