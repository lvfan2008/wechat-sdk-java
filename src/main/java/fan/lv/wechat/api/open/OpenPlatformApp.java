package fan.lv.wechat.api.open;

import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.kernel.container.impl.ContainerImpl;
import fan.lv.wechat.api.official.server.ServerService;
import fan.lv.wechat.api.official.server.impl.ServerServiceImpl;
import fan.lv.wechat.api.open.service.open.OpenFastRegisterMpService;
import fan.lv.wechat.api.open.service.open.OpenPlatformService;
import fan.lv.wechat.api.open.service.open.OpenServerService;
import fan.lv.wechat.api.open.service.open.impl.OpenClientImpl;
import fan.lv.wechat.api.open.service.open.impl.OpenFastRegisterMpServiceImpl;
import fan.lv.wechat.api.open.service.open.impl.OpenPlatformServiceImpl;
import fan.lv.wechat.api.open.service.open.impl.OpenServerServiceImpl;
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
        Client client = new OpenClientImpl(config.getComponentAppId(), config.getComponentSecret(), config.getCache());
        this.bind(OpenPlatformConfig.class, () -> config);
        this.bind(Client.class, () -> client);
        this.bind(OpenPlatformService.class, () -> new OpenPlatformServiceImpl(client, config));
        this.bind(ServerService.class, () -> new ServerServiceImpl(config.getAesKey(), config.getToken(), config.getComponentAppId()));
        this.bind(OpenServerService.class, () -> new OpenServerServiceImpl(config));
        this.bind(OpenFastRegisterMpService.class, () -> new OpenFastRegisterMpServiceImpl(client));
    }

    /**
     * 获取开放平台的客户端
     *
     * @return 开放平台的客户端
     */
    public Client client() {
        return get(Client.class);
    }

    /**
     * 开放平台服务
     *
     * @return 开放平台服务
     */
    public OpenPlatformService open() {
        return get(OpenPlatformService.class);
    }

    /**
     * 公众号或小程序回调消息服务
     *
     * @return 公众号或小程序回调消息服务
     */
    public ServerService authorizerServer() {
        return get(ServerService.class);
    }

    /**
     * 开放平台消息服务，包含ticket事件、授权相关事件
     *
     * @return 开放平台消息服务
     */
    public OpenServerService openServer() {
        return get(OpenServerService.class);
    }

    /**
     * 得到小程序appId的服务
     *
     * @param appId 小程序appId
     * @return 小程序appId的服务
     */
    OpenMpApp miniProgram(String appId) {
        return open().getMpApp(appId);
    }

    /**
     * 得到公众号appId的服务
     *
     * @param appId 公众号appId
     * @return 公众号appId的服务
     */
    OpenOfficialApp officialAccount(String appId) {
        return open().getOfficialApp(appId);
    }

    /**
     * 授权公众号或小程序的消息处理服务端
     *
     * @param appId 公众号或小程序appId
     * @return 公众号或小程序的消息处理服务端
     */
    ServerService authorizerServer(String appId) {
        return officialAccount(appId).get(ServerService.class);
    }
}
