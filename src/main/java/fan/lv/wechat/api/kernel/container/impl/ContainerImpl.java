package fan.lv.wechat.api.kernel.container.impl;

import fan.lv.wechat.api.kernel.container.Container;
import fan.lv.wechat.api.kernel.container.Implement;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author lv_fan2008
 */
public class ContainerImpl implements Container {

    /**
     * 名称与实现map
     */
    protected ConcurrentMap<String, Implement> map = new ConcurrentHashMap<>();

    /**
     * 名称与实现的实例map
     */
    protected ConcurrentMap<String, Object> instanceMap = new ConcurrentHashMap<>();


    @Override
    public void bind(String name, Implement implement) {
        synchronized (this) {
            map.put(name, implement);
            instanceMap.remove(name);
        }
    }

    @Override
    public Object get(String name) {
        synchronized (this) {
            if (instanceMap.containsKey(name)) {
                return instanceMap.get(name);
            } else {
                if (map.containsKey(name)) {
                    Object ins = map.get(name).run();
                    instanceMap.put(name, ins);
                    return ins;
                }
                return null;
            }
        }
    }
}
