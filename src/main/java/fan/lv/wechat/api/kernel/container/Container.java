package fan.lv.wechat.api.kernel.container;

/**
 * @author lv_fan2008
 */
public interface Container {

    /**
     * 绑定类和实现
     *
     * @param cls       名称
     * @param implement 实现
     */
    default void bind(Class<?> cls, Implement implement) {
        bind(cls.getName(), implement);
    }


    /**
     * 绑定名称和实现
     *
     * @param name      名称
     * @param implement 实现
     */
    void bind(String name, Implement implement);

    /**
     * 得到实现单例
     *
     * @param name 名称
     * @return 实现的单例
     */
    Object get(String name);

    /**
     * 注册服务提供者
     *
     * @param serviceProvider 服务提供者
     */
    default void register(ServiceProvider serviceProvider) {
        serviceProvider.register(this);
    }

    /**
     * 得到实现单例
     *
     * @param name       名称
     * @param resultType 单例类型
     * @param <T>        模板类型
     * @return 单例
     */
    default <T> T get(String name, Class<T> resultType) {
        return resultType.cast(get(name));
    }

    /**
     * 得到实现单例
     *
     * @param resultType 单例类型
     * @param <T>        模板类型
     * @return 单例
     */
    default <T> T get(Class<T> resultType) {
        return resultType.cast(get(resultType.getName()));
    }
}

