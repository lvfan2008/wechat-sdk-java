package fan.lv.wechat.api.kernel.impl;

import fan.lv.wechat.api.kernel.Cache;
import fan.lv.wechat.util.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 实现默认的基于文件的cache
 *
 * @author lv_fan2008
 */
public class DefaultCacheImpl implements Cache {

    @Override
    public void put(String key, String value, int ttl) {
        try {
            filePutContent(key, value, ttl);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String get(String key) {
        try {
            return fileGetContent(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void remove(String key) {
        try {
            String filePath = getKeyFilePath(key, true);
            if (filePath != null && Files.exists(Paths.get(filePath))) {
                Files.delete(Paths.get(filePath));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 写入文件
     *
     * @param key     键值
     * @param content 内容
     * @param ttl     过期时间
     * @throws IOException 异常
     */
    private void filePutContent(String key, String content, int ttl) throws IOException {
        String filePath = getKeyFilePath(key, true);
        if (filePath != null) {
            CacheObject object = new CacheObject(content, (int) (System.currentTimeMillis() / 1000 + ttl));
            Files.write(Paths.get(filePath), JsonUtil.toJson(object).getBytes(StandardCharsets.UTF_8));
        }
    }

    /**
     * 获取键值对应文件路径
     *
     * @param key       键值
     * @param createDir 是否创建目录
     * @return 文件路径
     * @throws IOException 异常
     */
    private String getKeyFilePath(String key, boolean createDir) throws IOException {
        String tmpDir = System.getProperty("java.io.tmpdir");
        tmpDir = tmpDir + "wechat";
        if (!Files.exists(Paths.get(tmpDir))) {
            if (createDir) {
                Files.createDirectory(Paths.get(tmpDir));
            } else {
                return null;
            }
        }
        return tmpDir + "/" + DigestUtils.md5Hex(key);
    }


    /**
     * 读取文件
     *
     * @param key 键值
     * @return 字符串
     * @throws IOException 异常
     */
    private String fileGetContent(String key) throws IOException {
        String filePath = getKeyFilePath(key, false);
        if (filePath == null || !Files.exists(Paths.get(filePath))) {
            return null;
        }
        byte[] bytes = Files.readAllBytes(Paths.get(filePath));
        CacheObject object = JsonUtil.parseJson(new String(bytes, StandardCharsets.UTF_8), CacheObject.class);
        if (object.expireTimestamp > System.currentTimeMillis() / 1000) {
            return object.content;
        } else {
            Files.delete(Paths.get(filePath));
            return null;
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CacheObject implements Serializable {
        public String content;
        public Integer expireTimestamp;
    }
}
