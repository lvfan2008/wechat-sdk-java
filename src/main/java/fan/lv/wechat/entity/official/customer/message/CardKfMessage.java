package fan.lv.wechat.entity.official.customer.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class CardKfMessage extends BaseKfMessage {
    /**
     * 发送类型
     */
    @JsonProperty("msgtype")
    String msgType = "wxcard";

    /**
     * 卡券
     */
    WxCard wxCard;

    public CardKfMessage(String cardId) {
        this.wxCard = new WxCard(cardId);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class WxCard {
        /**
         * 卡券Id
         */
        @JsonProperty("card_id")
        String cardId;
    }
}
