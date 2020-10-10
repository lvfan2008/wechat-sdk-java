package fan.lv.wechat.api.mp.service;

import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.kernel.Container;
import fan.lv.wechat.api.kernel.ServiceProvider;
import fan.lv.wechat.api.mp.service.impl.*;
import fan.lv.wechat.api.official.server.ServerService;
import fan.lv.wechat.api.official.server.impl.ServerServiceImpl;
import fan.lv.wechat.entity.mp.config.MiniProgramConfig;

/**
 * @author lv_fan2008
 */
public class MpServiceProvider implements ServiceProvider {
    @Override
    public void register(Container container) {
        MiniProgramConfig config = container.get(MiniProgramConfig.class);
        Client client = container.get(Client.class);
        container.bind(DataAnalysisService.class, () -> new DataAnalysisServiceImpl(client));
        container.bind(UserService.class, () -> new UserServiceImpl(config.getAppId(), config.getAppSecret(), client));
        container.bind(NearByPoiService.class, () -> new NearByPoiServiceImpl(client));
        container.bind(PluginService.class, () -> new PluginServiceImpl(client));
        container.bind(QrCodeService.class, () -> new QrCodeServiceImpl(client));
        container.bind(SecurityService.class, () -> new SecurityServiceImpl(client));
        container.bind(SubscribeService.class, () -> new SubscribeServiceImpl(client));
        container.bind(ServerService.class, () -> new ServerServiceImpl(config.getEncodingAesKey(), config.getToken(), config.getAppId()));
        container.bind(MpImageOcrService.class, () -> new MpImageOcrServiceImpl(client));
        container.bind(MarketService.class, () -> new MarketServiceImpl(client));
        container.bind(SoterService.class, () -> new SoterServiceImpl(client));
        container.bind(OperationService.class, () -> new OperationServiceImpl(client));
    }
}
