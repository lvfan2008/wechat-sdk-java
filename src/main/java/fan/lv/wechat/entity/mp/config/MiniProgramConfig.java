package fan.lv.wechat.entity.mp.config;

import fan.lv.wechat.api.kernel.Cache;
import fan.lv.wechat.entity.official.config.OfficialAccountConfig;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class MiniProgramConfig extends OfficialAccountConfig {
    public MiniProgramConfig(String appId, String appSecret, String encodingAesKey, String token, Cache cache) {
        super(appId, appSecret, encodingAesKey, token, cache);
    }
}
