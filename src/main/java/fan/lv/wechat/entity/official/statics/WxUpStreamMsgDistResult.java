package fan.lv.wechat.entity.official.statics;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 消息发送分布数据
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxUpStreamMsgDistResult extends WxResult {

    /**
     * 数据列表
     */
    List<UpStreamMsgDist> list;

    /**
     * 消息发送概况数据
     */
    @Data
    public static class UpStreamMsgDist {
        /**
         * 数据的日期，需在begin_date和end_date之间
         */
        @JsonProperty("ref_date")
        String refDate;

        /**
         * 当日发送消息量分布的区间，0代表 “0”，1代表“1-5”，2代表“6-10”，3代表“10次以上”
         */
        @JsonProperty("count_interval")
        Integer countInterval;

        /**
         * 上行发送了（向公众号发送了）消息的用户数
         */
        @JsonProperty("msg_user")
        Integer msgUser;
    }
}
