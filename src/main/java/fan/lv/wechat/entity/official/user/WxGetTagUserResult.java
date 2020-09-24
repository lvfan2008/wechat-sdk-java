package fan.lv.wechat.entity.official.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxGetTagUserResult extends WxResult {
    /**
     * 获取的粉丝数量
     */
    Integer count;

    /**
     * 粉丝数据
     */
    User data;

    /**
     * 第一个拉取的OPENID，不填默认从头开始拉取 }
     */
    @JsonProperty("next_openid")
    String nextOpenId;

    @lombok.Data
    public static class User {
        /**
         * 用户OpenId列表
         */
        @JsonProperty("openid")
        List<String> openId;
    }
}
