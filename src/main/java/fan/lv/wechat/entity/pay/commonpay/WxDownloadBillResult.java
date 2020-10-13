package fan.lv.wechat.entity.pay.commonpay;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import fan.lv.wechat.entity.result.WxBasePayResult;
import fan.lv.wechat.entity.result.WxCommonPayResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 下载账单结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxDownloadBillResult extends WxBasePayResult {

    /**
     * 失败错误码，详见错误码列表
     */
    @XStreamAlias("error_code")
    String downloadBillErrorCode;
}
