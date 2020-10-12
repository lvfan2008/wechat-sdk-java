package fan.lv.wechat.util;

import lombok.Data;

import java.io.InputStream;

/**
 * @author lv_fan2008
 */
@Data
public class SslCert {
    /**
     * 证书密码
     */
    String password;

    /**
     * 证书流
     */
    InputStream certInputStream;
}
