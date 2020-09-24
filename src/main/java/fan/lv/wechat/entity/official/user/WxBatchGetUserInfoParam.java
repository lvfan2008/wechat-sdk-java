package fan.lv.wechat.entity.official.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author lv_fan2008
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WxBatchGetUserInfoParam {

    /**
     * 用户列表
     */
    @JsonProperty("user_list")
    List<UserParam> userList;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UserParam {
        /**
         * 用户的标识，对当前公众号唯一
         */
        String openid;

        /**
         * 用户的语言，简体中文为zh_CN
         */
        String lang;
    }
}
