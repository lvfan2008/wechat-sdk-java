package fan.lv.wechat.entity.official.statics;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 消息发送概况数据结果列表
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxUpStreamMsgResult extends WxResult {

    /**
     * 数据列表
     */
    List<UpStreamMsg> list;

    /**
     * 消息发送概况数据
     */
    @Data
    public static class UpStreamMsg {
        /**
         * 数据的日期，需在begin_date和end_date之间
         */
        @JsonProperty("ref_date")
        String refDate;

        /**
         * 消息类型，代表含义如下： 1代表文字 2代表图片 3代表语音 4代表视频 6代表第三方应用消息（链接消息）
         */
        @JsonProperty("msg_type")
        Integer msgType;

        /**
         * 上行发送了（向公众号发送了）消息的用户数
         */
        @JsonProperty("msg_user")
        Integer msgUser;

        /**
         * 上行发送了消息的消息总数
         */
        @JsonProperty("msg_count")
        Integer msgCount;
    }
}
