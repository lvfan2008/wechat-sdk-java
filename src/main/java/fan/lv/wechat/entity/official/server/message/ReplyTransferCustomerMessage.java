package fan.lv.wechat.entity.official.server.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 消息转发到指定客服
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ReplyTransferCustomerMessage extends BaseReplyMessage {
    /**
     * 消息类型
     */
    @XStreamAlias("MsgType")
    @JsonProperty("MsgType")
    String msgType = "transfer_customer_service";

    @XStreamAlias("TransInfo")
    @JsonProperty("TransInfo")
    TransInfo transInfo;

    public ReplyTransferCustomerMessage() {
    }

    public ReplyTransferCustomerMessage(String kfAccount) {
        this.transInfo = new TransInfo(kfAccount);
    }

    /**
     *
     */
    @XStreamAlias("TransInfo")
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class TransInfo {
        /**
         * 指定会话接入的客服账号
         */
        @XStreamAlias("KfAccount")
        @JsonProperty("KfAccount")
        String kfAccount;
    }
}
