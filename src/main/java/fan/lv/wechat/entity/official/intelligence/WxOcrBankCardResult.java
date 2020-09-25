package fan.lv.wechat.entity.official.intelligence;

import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 银行卡OCR识别结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxOcrBankCardResult extends WxResult {
    /**
     * 银行卡号
     */
    String number;
}
