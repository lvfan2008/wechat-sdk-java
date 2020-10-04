package fan.lv.wechat.api.kernel.impl;

import fan.lv.wechat.api.kernel.Cache;
import fan.lv.wechat.api.kernel.Container;
import junit.framework.TestCase;

/**
 * @author lv_fan2008
 */
public class ContainerImplTest extends TestCase {

    public void testBind() {
        Container container = new ContainerImpl();
        container.bind("hello", () -> "world");
        assertEquals(container.get("hello"), "world");
        assertEquals(container.get("hello"), "world");
        container.bind("hello", () -> "world");
        assertEquals(container.get("hello"), "world");
        container.bind(Cache.class, DefaultCacheImpl::new);
        assertEquals(container.get(Cache.class).getClass(), DefaultCacheImpl.class);
    }

}