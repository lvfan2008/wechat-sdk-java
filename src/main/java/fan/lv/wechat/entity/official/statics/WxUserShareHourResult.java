package fan.lv.wechat.entity.official.statics;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 获取图文分享转发分时数据（getusersharehour）结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxUserShareHourResult extends WxResult {

    /**
     * 数据列表
     */
    List<UserReadHour> list;

    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class UserReadHour extends WxUserShareResult.UserShare {
        /**
         * 数据的小时，包括从000到2300，分别代表的是[000,100)到[2300,2400)，即每日的第1小时和最后1小时
         */
        @JsonProperty("ref_hour")
        Integer refHour;
    }


}
