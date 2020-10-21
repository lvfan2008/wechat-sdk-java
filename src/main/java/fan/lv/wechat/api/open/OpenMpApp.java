package fan.lv.wechat.api.open;

import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.kernel.container.impl.ContainerImpl;
import fan.lv.wechat.api.mp.service.*;
import fan.lv.wechat.api.mp.service.impl.*;
import fan.lv.wechat.api.official.server.ServerService;
import fan.lv.wechat.api.open.service.authorizer.OpenAccountService;
import fan.lv.wechat.api.open.service.open.OpenPlatformService;
import fan.lv.wechat.api.open.service.authorizer.impl.AuthorizerClientImpl;
import fan.lv.wechat.api.open.service.authorizer.impl.OpenAccountServiceImpl;
import fan.lv.wechat.entity.open.config.OpenPlatformConfig;

/**
 * 小程序服务
 *
 * @author lv_fan2008
 */
public class OpenMpApp extends ContainerImpl {

    /**
     * @param config 公众号配置
     */
    public OpenMpApp(OpenPlatformService open, OpenPlatformConfig config, String appId) {
        Client client = new AuthorizerClientImpl(open, config, appId);
        this.bind(OpenPlatformConfig.class, () -> config);
        this.bind(Client.class, () -> client);
        this.bind(DataAnalysisService.class, () -> new DataAnalysisServiceImpl(client));
//        this.bind(UserService.class, () -> new UserServiceImpl(config.getAppId(), config.getAppSecret(), client));
        this.bind(NearByPoiService.class, () -> new NearByPoiServiceImpl(client));
        this.bind(PluginService.class, () -> new PluginServiceImpl(client));
        this.bind(QrCodeService.class, () -> new QrCodeServiceImpl(client));
        this.bind(SecurityService.class, () -> new SecurityServiceImpl(client));
        this.bind(SubscribeService.class, () -> new SubscribeServiceImpl(client));
        this.bind(MpImageOcrService.class, () -> new MpImageOcrServiceImpl(client));
        this.bind(MarketService.class, () -> new MarketServiceImpl(client));
        this.bind(SoterService.class, () -> new SoterServiceImpl(client));
        this.bind(OperationService.class, () -> new OperationServiceImpl(client));
        this.bind(OpenAccountService.class, () -> new OpenAccountServiceImpl(appId, client));
        this.bind(ServerService.class, () -> new AuthorizerClientImpl(open, config, appId));
    }
}
