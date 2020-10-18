package fan.lv.wechat.api.open;

import fan.lv.wechat.api.kernel.container.impl.ContainerImpl;
import fan.lv.wechat.entity.open.config.OpenPlatformConfig;

/**
 * 开放平台
 *
 * @author lv_fan2008
 */
public class OpenPlatformApp extends ContainerImpl {
    /**
     * @param config 小程序配置
     */
    public OpenPlatformApp(OpenPlatformConfig config) {
        this.bind(OpenPlatformConfig.class, () -> config);
    }
}
