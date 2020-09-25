package fan.lv.wechat.entity.official.intelligence;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 驾驶证OCR识别结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxOcrDrivingLicenseCardResult extends WxResult {
    /**
     * 证号
     */
    @JsonProperty("id_num")
    String idNum;

    /**
     * 姓名
     */
    String name;

    /**
     * 性别
     */
    String sex;

    /**
     * 国籍
     */
    String nationality;

    /**
     * 住址
     */
    String address;

    /**
     * 出生日期
     */
    @JsonProperty("birth_date")
    String birthDate;

    /**
     * 初次领证日期
     */
    @JsonProperty("issue_date")
    String issueDate;

    /**
     * 准驾车型
     */
    @JsonProperty("car_class")
    String carClass;

    /**
     * 有效期限起始日
     */
    @JsonProperty("valid_from")
    String validFrom;

    /**
     * 有效期限终止日
     */
    @JsonProperty("valid_to")
    String validTo;

    /**
     * 印章文字
     */
    @JsonProperty("official_seal")
    String officialSeal;
}
