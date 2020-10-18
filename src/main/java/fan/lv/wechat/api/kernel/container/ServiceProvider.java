package fan.lv.wechat.api.kernel.container;

/**
 * 服务提供接口，用户提供服务配置的入口
 *
 * @author lv_fan2008
 */
public interface ServiceProvider {
    /**
     * 注册服务到容器中
     *
     * @param container 容器
     */
    void register(Container container);
}
