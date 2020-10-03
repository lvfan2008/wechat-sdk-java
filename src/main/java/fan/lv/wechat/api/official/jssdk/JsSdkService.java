package fan.lv.wechat.api.official.jssdk;

import fan.lv.wechat.entity.official.jssdk.*;

import java.util.List;

/**
 * @author lv_fan2008
 */
public interface JsSdkService {

    /**
     * 获取 公众号用于调用微信JS接口的临时票据
     *
     * @return JS接口的临时票据
     */
    default WxJsSdkTicketResult getJsSdkTicket() {
        return getJsSdkTicket(true);
    }


    /**
     * 获取 公众号用于调用微信JS接口的临时票据
     *
     * @param tryCache 是否尝试从cache读取
     * @return JS接口的临时票据
     */
    WxJsSdkTicketResult getJsSdkTicket(boolean tryCache);

    /**
     * 得到签名后的JSSDK页面的配置信息，
     * 通过config接口注入权限验证配置，所有需要使用JS-SDK的页面必须先注入配置信息，否则将无法调用（同一个url仅需调用一次，
     * 对于变化url的SPA的web app可在每次url变化时进行调用,
     *
     * @param jsConfig 待签名的配置
     * @param url      当前页面Url
     * @param ticket   临时票据
     * @return JSSDK页面的配置
     */
    WxJsConfig getSignedJsConfig(WxJsConfig jsConfig, String url, String ticket);

    /**
     * 获取卡券相关接口的临时票据
     *
     * @return 卡券相关接口的临时票据
     */
    default WxCardApiTicketResult getCardApiTicket() {
        return getCardApiTicket(true);
    }


    /**
     * 获取卡券相关接口的临时票据
     *
     * @param tryCache 是否尝试从cache读取
     * @return 卡券相关接口的临时票据
     */
    WxCardApiTicketResult getCardApiTicket(boolean tryCache);

    /**
     * 添加到卡包JSAPI(wx.addCard)签名
     *
     * @param cardExt       添加卡包参数。
     * @param cardApiTicket 卡券相关接口的临时票据
     * @param cardId        卡券Id
     * @param balance       红包类型余额
     * @return 签名
     */
    WxCardExt getSignedCartExt(WxCardExt cardExt, String cardApiTicket, String cardId, String balance);

    /**
     * 拉取适用卡券列表(wx.chooseCard)签名
     *
     * @param chooseCard    拉起卡券列表参数
     * @param cardApiTicket 卡券相关接口的临时票据
     * @param locationId    位置Id
     * @return 签名
     */
    WxChooseCard getSignedChooseCard(WxChooseCard chooseCard, String cardApiTicket, String locationId);
}
