package fan.lv.wechat.api.mp;

import fan.lv.wechat.api.kernel.Cache;
import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.kernel.container.impl.ContainerImpl;
import fan.lv.wechat.api.mp.service.MpServiceProvider;
import fan.lv.wechat.api.mp.service.impl.MpClientImpl;
import fan.lv.wechat.entity.mp.config.MiniProgramConfig;

/**
 * 小程序
 * <p>
 * 使用方法: MiniProgramApp mp = new MiniProgramApp(config);
 * </p>
 *
 * @author lv_fan2008
 */
public class MiniProgramApp extends ContainerImpl {
    /**
     * @param config 小程序配置
     */
    public MiniProgramApp(MiniProgramConfig config) {
        this.bind(MiniProgramConfig.class, () -> config);
        this.bind(Cache.class, config::getCache);
        this.bind(Client.class, () -> new MpClientImpl(config.getAppId(), config.getAppSecret(), config.getCache()));
        this.register(new MpServiceProvider());
    }
}
