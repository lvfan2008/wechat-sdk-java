package fan.lv.wechat.entity.pay.profitshare;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lv_fan2008
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WxReceiverForAdd {
    /**
     * 分账接收方类型
     */
    String type;

    /**
     * 分账接收方帐号
     */
    String account;

    /**
     * 分账接收方全称
     */
    String name;


    /**
     * 与分账方的关系类型
     */
    @JsonProperty("relation_type")
    String relationType;

    /**
     * 自定义的分账关系
     */
    @JsonProperty("custom_relation")
    String customRelation;
}
