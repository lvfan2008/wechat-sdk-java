package fan.lv.wechat.api.official.official;

import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.kernel.Container;
import fan.lv.wechat.api.kernel.ServiceProvider;
import fan.lv.wechat.api.official.base.impl.ClientImpl;
import fan.lv.wechat.entity.official.config.OfficialAccountConfig;

/**
 * @author lv_fan2008
 */
public class ClientServiceProvider implements ServiceProvider {
    @Override
    public void register(Container container) {
        OfficialAccountConfig config = container.get(OfficialAccountConfig.class);
        container.bind(Client.class, () -> new ClientImpl(config.getAppId(), config.getAppSecret(), config.getCache()));
    }
}
