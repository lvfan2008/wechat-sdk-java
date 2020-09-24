package fan.lv.wechat.entity.user.tag;

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
public class WxGetSubscribeUserResult extends WxResult {
    /**
     * 关注该公众账号的总用户数
     */
    Integer total;

    /**
     * 拉取的OPENID个数，最大值为10000
     */
    Integer count;

    /**
     * 拉取列表的最后一个用户的OPENID
     */
    String nextOpenId;

    /**
     * 列表数据，OPENID的列表
     */
    UserData data;

    /**
     * 列表数据，OPENID的列表
     */
    @Data
    public static class UserData {
        /**
         * OpenId列表
         */
        @JsonProperty("openid")
        List<String> openId;
    }
}
