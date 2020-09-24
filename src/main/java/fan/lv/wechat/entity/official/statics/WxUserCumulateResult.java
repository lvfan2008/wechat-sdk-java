package fan.lv.wechat.entity.official.statics;

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
public class WxUserCumulateResult extends WxResult {

    /**
     * 统计数据列表
     */
    List<UserStatic> list;

    @Data
    public static class UserStatic {
        /**
         * 数据的日期
         */
        @JsonProperty("ref_date")
        String refDate;

        /**
         * 总用户量
         */
        @JsonProperty("cumulate_user")
        Integer cumulateUser;
    }

}
