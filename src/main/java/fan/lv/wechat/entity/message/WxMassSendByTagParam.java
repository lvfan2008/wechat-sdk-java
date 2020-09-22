package fan.lv.wechat.entity.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 根据标签进行群发参数
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxMassSendByTagParam extends WxMessage {

    /**
     * 用于设定图文消息的接收者
     */
    Filter filter;

    /**
     * 图文消息被判定为转载时，是否继续群发。 1为继续群发（转载），0为停止群发。 该参数默认为0。
     */
    @JsonProperty("send_ignore_reprint")
    Integer sendIgnoreReprint;

    /**
     * 开发者侧群发msgid，长度限制64字节，如不填，则后台默认以群发范围和群发内容的摘要值做为clientmsgid
     */
    @JsonProperty("clientmsgid")
    String clientMsgId;

    /**
     * 用于设定图文消息的接收者
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Filter {
        /**
         * 用于设定是否向全部用户发送，值为true或false，选择true该消息群发给所有用户，选择false可根据tag_id发送给指定群组的用户
         */
        @JsonProperty("is_to_all")
        Boolean isToAll;

        /**
         * 群发到的标签的tag_id，参见用户管理中用户分组接口，若is_to_all值为true，可不填写tag_id
         */
        @JsonProperty("tag_id")
        Integer tagId;
    }


}
