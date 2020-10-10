package fan.lv.wechat.api.mp.service;

import fan.lv.wechat.entity.mp.market.WxInvokeServiceParam;
import fan.lv.wechat.entity.mp.market.WxInvokeServiceResult;

/**
 * @author lv_fan2008
 */
public interface MarketService {

    /**
     * 调用服务平台提供的服务
     *
     * @param param 参数
     * @return 接口结果
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/service-market/serviceMarket.invokeService.html" target="_blank">微信官方文档</a>
     */
    WxInvokeServiceResult invokeService(WxInvokeServiceParam param);
}
