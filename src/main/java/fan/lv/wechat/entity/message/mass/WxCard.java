package fan.lv.wechat.entity.message.mass;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 卡券消息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WxCard {
    /**
     * 卡券Id
     */
    @JsonProperty("card_id")
    String cardId;
}
