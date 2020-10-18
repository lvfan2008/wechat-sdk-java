package fan.lv.wechat.api.payment.v2;

import fan.lv.wechat.api.kernel.container.impl.ContainerImpl;
import fan.lv.wechat.api.payment.v2.service.*;
import fan.lv.wechat.api.payment.v2.service.impl.*;
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
        this.bind(CouponService.class, () -> new CouponServiceImpl(client, config));
        this.bind(EnterprisePayService.class, () -> new EnterprisePayServiceImpl(client, config));
        this.bind(ProfitShareService.class, () -> new ProfitShareServiceImpl(client, config));
        this.bind(RedPackService.class, () -> new RedPackServiceImpl(client, config));
    }

    /**
     * 得到支付配置信息
     *
     * @return 配置信息
     */
    WxPayConfig config() {
        return get(WxPayConfig.class);
    }

    /**
     * 支付请求客户端
     *
     * @return 请求客户端
     */
    PayClient client() {
        return get(PayClient.class);
    }


    /**
     * 支付服务
     *
     * @return 支付服务
     */
    PaymentService pay() {
        return get(PaymentService.class);
    }

    /**
     * 代金券、立减优惠服务
     *
     * @return 代金券、立减优惠服务
     */
    CouponService coupon() {
        return get(CouponService.class);
    }

    /**
     * 企业付款服务
     *
     * @return 企业付款服务
     */
    EnterprisePayService entPay() {
        return get(EnterprisePayService.class);
    }

    /**
     * 分账服务
     *
     * @return 分账服务
     */
    ProfitShareService share() {
        return get(ProfitShareService.class);
    }

    /**
     * 现金红包服务
     *
     * @return 现金红包服务
     */
    RedPackService redPack() {
        return get(RedPackService.class);
    }
}