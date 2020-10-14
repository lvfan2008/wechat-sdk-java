package fan.lv.wechat.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.InputStream;

/**
 * @author lv_fan2008
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SslCert {
    /**
     * 证书密码
     */
    String password;

    /**
     * 证书流
     */
    byte[] certBytes;
}
