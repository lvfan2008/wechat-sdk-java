package fan.lv.wechat.entity.official.customer;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 聊天记录
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxMsgRecordResult extends WxResult {

    /**
     * 聊天记录
     */
    @JsonProperty("recordlist")
    List<MsgRecord> recordList;

    /**
     * 获取聊天记录数
     */
    Integer number;

    /**
     * 消息id顺序从小到大，从1开始
     */
    @JsonProperty("msgid")
    Integer msgId;


    @Data
    public static class MsgRecord {

        /**
         * 粉丝OpenId
         */
        @JsonProperty("openid")
        String openId;

        /**
         * 操作码，2002（客服发送信息），2003（客服接收消息）
         */
        @JsonProperty("opercode")
        Integer operateCode;

        /**
         * 聊天记录
         */
        String text;

        /**
         * 操作时间，unix时间戳
         */
        Integer time;

        /**
         * 完整客服帐号，格式为：帐号前缀@公众号微信号
         */
        String worker;
    }
}
