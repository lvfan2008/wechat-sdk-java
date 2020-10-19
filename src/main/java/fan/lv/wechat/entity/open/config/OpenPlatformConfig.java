package fan.lv.wechat.entity.open.config;

import fan.lv.wechat.api.kernel.Cache;
import lombok.Data;

/**
 * @author lv_fan2008
 */
@Data
public class OpenPlatformConfig {
    /**
     * 开放平台AppId
     */
    String componentAppId;

    /**
     * 开放平台secret
     */
    String componentSecret;

    /**
     * 消息加解密Key
     */
    String aesKey;

    /**
     * 消息校验Token
     */
    String token;

    /**
     * 缓存接口
     */
    Cache cache;
}
