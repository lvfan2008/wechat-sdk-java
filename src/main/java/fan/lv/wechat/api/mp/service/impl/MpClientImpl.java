package fan.lv.wechat.api.mp.service.impl;

import fan.lv.wechat.api.kernel.Cache;
import fan.lv.wechat.api.official.base.impl.ClientImpl;

/**
 * @author lv_fan2008
 */
public class MpClientImpl extends ClientImpl {

    /**
     * @param appId     小程序appId
     * @param appSecret 小程序密钥
     * @param cache     缓存接口，用于存储token
     */
    public MpClientImpl(String appId, String appSecret, Cache cache) {
        super(appId, appSecret, cache);
    }
}
