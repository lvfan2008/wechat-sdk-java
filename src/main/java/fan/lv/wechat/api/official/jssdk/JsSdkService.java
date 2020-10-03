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
     * 生成JS-SDK权限验证的签名
     *
     * @param nonce     随机字符串,与wx.config中的nonceStr相同。
     * @param timestamp 时间戳,与wx.config中的timestamp相同。
     * @param url       必须是调用JS接口页面的完整URL
     * @param ticket    调用微信JS接口的临时票据
     * @return 权限验证的签名
     */
    String signatureJsSdk(String nonce, String timestamp, String url, String ticket);

    /**
     * 得到JSSDK页面的配置信息，
     * 通过config接口注入权限验证配置，所有需要使用JS-SDK的页面必须先注入配置信息，否则将无法调用（同一个url仅需调用一次，
     * 对于变化url的SPA的web app可在每次url变化时进行调用,
     *
     * @param debug     开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，
     *                  参数信息会通过log打出，仅在pc端时才会打印。
     * @param jsApiList 需要使用的JS接口列表
     * @param url       当前页面Url
     * @param ticket    临时票据
     * @return JSSDK页面的配置
     */
    WxJsConfig getJsConfig(Boolean debug, List<String> jsApiList, String url, String ticket);

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
    WxCardExt signatureChooseCard(WxCardExt cardExt, String cardApiTicket, String cardId, String balance);

    /**
     * 拉取适用卡券列表(wx.chooseCard)签名
     *
     * @param chooseCard    拉起卡券列表参数
     * @param cardApiTicket 卡券相关接口的临时票据
     * @param locationId    位置Id
     * @return 签名
     */
    WxChooseCard signatureChooseCard(WxChooseCard chooseCard, String cardApiTicket, String locationId);
}
