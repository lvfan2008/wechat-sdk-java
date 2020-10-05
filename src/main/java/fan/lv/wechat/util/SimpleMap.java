package fan.lv.wechat.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 快捷Map
 *
 * @param <K>
 * @param <V>
 * @author lixinguo
 */
public class SimpleMap<K, V> extends HashMap<K, V> {

    public static final SimpleMap<Object, Object> EMPTY = new SimpleMap<>();

    public SimpleMap<K, V> add(K k, V v) {
        put(k, v);
        return this;
    }

    public static <K, V> SimpleMap<K, V> of() {
        return new SimpleMap<K, V>();
    }

    public static <K, V> SimpleMap<K, V> of(K k1, V v1) {
        return new SimpleMap<K, V>().add(k1, v1);
    }

    public static <K, V> SimpleMap<K, V> of(K k1, V v1, K k2, V v2) {
        return new SimpleMap<K, V>().add(k1, v1).add(k2, v2);
    }

    public static <K, V> SimpleMap<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3) {
        return new SimpleMap<K, V>().add(k1, v1).add(k2, v2).add(k3, v3);
    }

    public static <K, V> SimpleMap<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4) {
        return new SimpleMap<K, V>().add(k1, v1).add(k2, v2).add(k3, v3).add(k4, v4);
    }

    public static <K, V> SimpleMap<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        return new SimpleMap<K, V>().add(k1, v1).add(k2, v2).add(k3, v3).add(k4, v4).add(k5, v5);
    }

    public static <K, V> SimpleMap<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6) {
        return new SimpleMap<K, V>().add(k1, v1).add(k2, v2).add(k3, v3).add(k4, v4).add(k5, v5).add(k6, v6);
    }
}
