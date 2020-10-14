package fan.lv.wechat.entity.result;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxCommonPayResult extends WxBasePayResult {



    /**
     * 服务商的appId或商户AppId
     */
    @XStreamAlias("appid")
    String appId;

    /**
     * 调用接口提交的商户号
     */
    @XStreamAlias("mch_id")
    String mchId;


    /**
     * 微信分配的子商户公众账号ID
     */
    @XStreamAlias("sub_appid")
    String subAppid;


    /**
     * 微信支付分配的子商户号
     */
    @XStreamAlias("sub_mch_id")
    String subMchId;


    /**
     * 签名
     */
    @XStreamAlias("sign")
    String sign;

    /**
     * 签名
     */
    @XStreamAlias("sign_type")
    String signType;


    /**
     * 详细参见第6节错误列表
     */
    @XStreamAlias("err_code")
    String payErrCode;


    /**
     * 错误返回的信息描述
     */
    @XStreamAlias("err_code_des")
    String payErrCodeDes;
}
