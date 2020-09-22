package fan.lv.wechat.entity.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 根据标签进行群发结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxMassSendResult extends WxResult {

    /**
     * 消息发送任务的ID
     */
    @JsonProperty("msg_id")
    Integer msgId;

    /**
     * 消息的数据ID，该字段只有在群发图文消息时，才会出现。可以用于在图文分析数据接口中，获取到对应的图文消息的数据，
     * 是图文分析数据接口中的msgid字段中的前半部分，详见图文分析数据接口中的msgid字段的介绍。
     */
    @JsonProperty("msg_data_id")
    Integer msgDataId;
}
