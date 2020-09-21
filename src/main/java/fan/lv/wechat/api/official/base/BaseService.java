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
     */
    WxCallbackIpResult getCallbackIp();


    /**
     * 获取微信API接口IP地址,API接口IP即api.weixin.qq.com的解析地址，由开发者调用微信侧的接入IP
     *
     * @return 微信API接口IP地址
     */
    WxApiIpResult getApiDomainIp();

    /**
     * 网络检测
     *
     * @param checkParam 检测参数
     * @return 检测结果
     */
    WxCheckResult checkNetwork(WxCheckParam checkParam);
}
