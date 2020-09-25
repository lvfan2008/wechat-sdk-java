package fan.lv.wechat.entity.official.intelligence;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 营业执照OCR识别结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxOcrBizLicenseResult extends WxResult {

    /**
     * 注册号
     */
    @JsonProperty("reg_num")
    String regNum;

    /**
     * 编号
     */
    String serial;

    /**
     * 法定代表人姓名
     */
    @JsonProperty("legal_representative")
    String legalRepresentative;

    /**
     * 企业名称
     */
    @JsonProperty("enterprise_name")
    String enterpriseName;

    /**
     * 组成形式
     */
    @JsonProperty("type_of_organization")
    String typeOfOrganization;

    /**
     * 经营场所/企业住所
     */
    String address;

    /**
     * 公司类型
     */
    @JsonProperty("type_of_enterprise")
    String typeOfEnterprise;

    /**
     * 经营范围
     */
    @JsonProperty("business_scope")
    String businessScope;

    /**
     * 注册资本
     */
    @JsonProperty("registered_capital")
    String registeredCapital;

    /**
     * 实收资本
     */
    @JsonProperty("paid_in_capital")
    String paidInCapital;

    /**
     * 营业期限
     */
    @JsonProperty("valid_period")
    String validPeriod;

    /**
     * 注册日期/成立日期
     */
    @JsonProperty("registered_date")
    String registeredDate;

    /**
     * 营业执照位置
     */
    @JsonProperty("cert_position")
    WxOcrDrivingCardResult.CardPos certPosition;

    /**
     * 图片大小
     */
    @JsonProperty("img_size")
    WxOcrDrivingCardResult.ImageSize imageSize;
}
