package fan.lv.wechat.entity.pay.redpack;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import fan.lv.wechat.entity.pay.base.WxCommonPayResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 小程序发放红包结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxMpSendRedPackResult extends WxSendRedPackResult {

    /**
     * 返回jaspi的入参package的值
     */
    @XStreamAlias("package")
    String jsApiPackage;
}
