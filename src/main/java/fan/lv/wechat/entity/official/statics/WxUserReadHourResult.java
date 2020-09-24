package fan.lv.wechat.entity.official.statics;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 获取图文统计分时数据（getuserreadhour）结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxUserReadHourResult extends WxUserReadResult {

    /**
     * 数据的小时，包括从000到2300，分别代表的是[000,100)到[2300,2400)，即每日的第1小时和最后1小时
     */
    @JsonProperty("ref_hour")
    Integer refHour;

}
