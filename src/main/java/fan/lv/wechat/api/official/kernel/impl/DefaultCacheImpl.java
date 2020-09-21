package fan.lv.wechat.api.official.kernel.impl;

import fan.lv.wechat.api.official.kernel.Cache;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.*;
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
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void remove(String key) {
        String filePath = null;
        try {
            filePath = getKeyFilePath(key, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (filePath != null) {
            new File(filePath).delete();
        }
    }

    private void filePutContent(String key, String content, int ttl) throws IOException {
        String filePath = getKeyFilePath(key, true);
        OutputStream os = new FileOutputStream(filePath);
        ObjectOutputStream oos = new ObjectOutputStream(os);
        CacheObject object = new CacheObject(content, (int) (System.currentTimeMillis() / 1000 + ttl));
        oos.writeObject(object);
        oos.flush();
        oos.close();
        os.close();
    }

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


    private String fileGetContent(String key) throws IOException, ClassNotFoundException {
        String filePath = getKeyFilePath(key, false);
        if (filePath == null) {
            return null;
        }
        InputStream is = new FileInputStream(filePath);
        ObjectInputStream ois = new ObjectInputStream(is);
        CacheObject object = (CacheObject) ois.readObject();
        ois.close();
        is.close();
        if (object.expireTimestamp > System.currentTimeMillis() / 1000) {
            return object.content;
        }
        new File(filePath).delete();
        return null;
    }

    @Data
    @AllArgsConstructor
    public static class CacheObject implements Serializable {
        public String content;
        public Integer expireTimestamp;
    }
}
