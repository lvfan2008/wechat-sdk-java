package fan.lv.wechat.entity.official.intelligence;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 身份证OCR识别结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxOcrIdCardResult extends WxResult {
    /**
     * 类型：Front 和 Back
     */
    String type;

    /**
     * 姓名（type=Front有效）
     */
    String name;

    /**
     * 身份证号码（type=Front有效）
     */
    String id;

    /**
     * 住址（type=Front有效）
     */
    String addr;

    /**
     * 性别（type=Front有效）
     */
    String gender;

    /**
     * 民族，仅（type=Front有效）
     */
    String nationality;

    /**
     * 有效期，仅（type=Back有效）
     */
    @JsonProperty("valid_date")
    String validDate;

}
