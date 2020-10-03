package fan.lv.wechat.entity.official.jssdk;

import lombok.Data;

/**
 * @author lv_fan2008
 */
@Data
public class WxChooseCard {
    /**
     * 门店ID。shopID用于筛选出拉起带有指定location_list(shopID)的卡券列表，非必填。
     */
    String shopId;

    /**
     * 卡券类型，用于拉起指定卡券类型的卡券列表。当cardType为空时，默认拉起所有卡券的列表，非必填。
     */
    String cardType;

    /**
     * 卡券ID，用于拉起指定cardId的卡券列表，当cardId为空时，默认拉起所有卡券的列表，非必填。
     */
    String cardId;

    /**
     * 时间戳。
     */
    String timestamp;

    /**
     * 随机字符串。
     */
    String nonceStr;

    /**
     * 签名方式，目前仅支持SHA1
     */
    String signType = "SHA1";

    /**
     * 签名。
     */
    String cardSign;
}
