package fan.lv.wechat.api.official;

import com.fasterxml.jackson.core.JsonProcessingException;
import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.official.base.impl.ClientImpl;
import fan.lv.wechat.api.kernel.impl.DefaultCacheImpl;
import fan.lv.wechat.entity.result.WxResult;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * 测试工具类
 */
public class Util {

    /**
     * 客户端
     */
    private static Client client;
    private static Properties properties;

    static {
        properties = new Properties();
        InputStream inputStream = Util.class.getClassLoader().getResourceAsStream("application.properties");
        try {
            assert inputStream != null;
            properties.load(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
        client = new ClientImpl(properties.getProperty("app_id"), properties.getProperty("app_secret"), new DefaultCacheImpl());
    }

    /**
     * 得到客户端
     *
     * @return 请求客户端
     */
    public static Client getClient() {
        return client;
    }


    /**
     * 输出Json
     *
     * @param object result对象
     */
    public static void printJson(WxResult object) {
        try {
            System.out.println(object.toJson());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 得到配置属性
     *
     * @param key 键值
     * @return 键对应值
     */
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
