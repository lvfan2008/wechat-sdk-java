package fan.lv.wechat.api.official.base;

import fan.lv.wechat.entity.official.base.WxCheckParam;
import fan.lv.wechat.entity.official.base.WxApiIpResult;
import fan.lv.wechat.entity.official.base.WxCallbackIpResult;
import fan.lv.wechat.entity.official.base.WxCheckResult;
import fan.lv.wechat.entity.official.message.reply.WxAutoReplyRuleResult;
import fan.lv.wechat.entity.result.WxResult;

/**
 * 基础Api
 *
 * @author lv_fan2008
 */
public interface BaseService {

    /**
     * 获取微信callback IP地址
     *
     * @return 微信callback IP地址
     * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/Basic_Information/Get_the_WeChat_server_IP_address.html" target="_blank">微信官方接口文档</a>
     */
    WxCallbackIpResult getCallbackIp();


    /**
     * 获取微信API接口IP地址,API接口IP即api.weixin.qq.com的解析地址，由开发者调用微信侧的接入IP
     *
     * @return 微信API接口IP地址
     * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/Basic_Information/Get_the_WeChat_server_IP_address.html" target="_blank">微信官方接口文档</a>
     */
    WxApiIpResult getApiDomainIp();

    /**
     * 网络检测
     *
     * @param checkParam 检测参数
     * @return 检测结果
     * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/Basic_Information/Network_Detection.html" target="_blank">微信官方接口文档</a>
     */
    WxCheckResult checkNetwork(WxCheckParam checkParam);

    /**
     * 公众号调用或第三方平台帮公众号调用对公众号的所有api调用（包括第三方帮其调用）次数进行清零：
     *
     * @param appId 公众号的APPID
     * @return 清零结果
     * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/Message_Management/API_Call_Limits.html" target="_blank">微信官方接口文档</a>
     */
    WxResult clearQuota(String appId);

    /**
     * 获取公众号当前使用的自动回复规则，包括关注后自动回复、消息自动回复（60分钟内触发一次）、关键词自动回复。
     *
     * @return 自动回复规则
     */
    WxAutoReplyRuleResult getAutoReplyRule();
}
