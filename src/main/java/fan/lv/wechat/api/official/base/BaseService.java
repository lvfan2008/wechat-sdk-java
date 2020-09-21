package fan.lv.wechat.api.official.base;

import fan.lv.wechat.entity.base.param.WxCheckParam;
import fan.lv.wechat.entity.base.result.WxApiIpResult;
import fan.lv.wechat.entity.base.result.WxCallbackIpResult;
import fan.lv.wechat.entity.base.result.WxCheckResult;

/**
 * 基础Api
 *
 * @author lixinguo
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
}
