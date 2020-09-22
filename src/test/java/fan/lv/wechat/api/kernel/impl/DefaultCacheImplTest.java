package fan.lv.wechat.api.kernel.impl;

import junit.framework.TestCase;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.File;

public class DefaultCacheImplTest extends TestCase {

    DefaultCacheImpl cache;

    static final String CACHE_KEY = "test";
    static final String CACHE_VALUE = "haha";
    static final String CACHE_PATH;

    static final String CACHE_KEY2 = "test";
    static final String CACHE_VALUE2 = "haha";
    static final String CACHE_PATH2;

    static {
        String tmpDir = System.getProperty("java.io.tmpdir");
        tmpDir = tmpDir + "wechat";
        CACHE_PATH = tmpDir + "/" + DigestUtils.md5Hex(CACHE_KEY);
        CACHE_PATH2 = tmpDir + "/" + DigestUtils.md5Hex(CACHE_KEY2);
    }


    public void setUp() throws Exception {
        super.setUp();
        cache = new DefaultCacheImpl();
    }


    public void testPut() {
        cache.put(CACHE_KEY, CACHE_VALUE, 2000);
        assertTrue(new File(CACHE_PATH).exists());
    }

    public void testGet() {
        String testGetKey = "testGetKey";
        cache.put(testGetKey, CACHE_VALUE, 2000);
        String value = cache.get(testGetKey);
        assertEquals(value, CACHE_VALUE);
    }

    public void testRemove() {
        cache.put(CACHE_KEY2, CACHE_VALUE2, 2000);
        cache.remove(CACHE_KEY2);
        assertFalse(new File(CACHE_PATH2).exists());
    }
}