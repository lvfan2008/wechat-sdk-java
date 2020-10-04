package fan.lv.wechat.entity.official.config;

import fan.lv.wechat.api.kernel.Cache;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lv_fan2008
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfficialAccountConfig {
    /**
     * 公众号appId
     */
    String appId;

    /**
     * 公众号密钥
     */
    String appSecret;

    /**
     * 服务加密Aes密钥
     */
    protected String encodingAesKey;

    /**
     * 服务验证凭证
     */
    protected String token;

    /**
     * 缓存接口
     */
    protected Cache cache;
}
