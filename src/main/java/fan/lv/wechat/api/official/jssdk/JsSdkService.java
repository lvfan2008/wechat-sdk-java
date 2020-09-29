package fan.lv.wechat.api.official.jssdk;

import fan.lv.wechat.entity.official.jssdk.WxJsSdkTicketResult;

/**
 * @author lv_fan2008
 */
public interface JsSdkService {

    /**
     * 获取 公众号用于调用微信JS接口的临时票据
     *
     * @return JS接口的临时票据
     */
    default WxJsSdkTicketResult getTicket() {
        return getTicket(true);
    }


    /**
     * 获取 公众号用于调用微信JS接口的临时票据
     *
     * @param tryCache 是否尝试从cache读取
     * @return JS接口的临时票据
     */
    WxJsSdkTicketResult getTicket(boolean tryCache);

    /**
     * 生成JS-SDK权限验证的签名
     *
     * @param nonce     随机字符串,与wx.config中的nonceStr相同。
     * @param timestamp 时间戳,与wx.config中的timestamp相同。
     * @param url       必须是调用JS接口页面的完整URL
     * @param ticket    调用微信JS接口的临时票据
     * @return 权限验证的签名
     */
    String signature(String nonce, String timestamp, String url, String ticket);
}
