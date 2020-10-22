package fan.lv.wechat.entity.open.mp.basicinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 设置名称参数
 *
 * @author lv_fan2008
 */
@Data
@NoArgsConstructor
public class WxSetNicknameParam {
    /**
     * 昵称，不支持包含“小程序”关键字的昵称
     */
    @JsonProperty("nick_name")
    String nickname;

    /**
     * 身份证照片 mediaid,个人号必填
     */
    @JsonProperty("id_card")
    String idCard;

    /**
     * 组织机构代码证或营业执照 mediaid，组织号必填
     */
    @JsonProperty("license")
    String license;

    /**
     * 其他证明材料 mediaid
     */
    @JsonProperty("naming_other_stuff_1")
    String namingOtherStuff1;

    /**
     * 其他证明材料 mediaid
     */
    @JsonProperty("naming_other_stuff_2")
    String namingOtherStuff2;

    /**
     * 其他证明材料 mediaid
     */
    @JsonProperty("naming_other_stuff_3")
    String namingOtherStuff3;

    /**
     * 其他证明材料 mediaid
     */
    @JsonProperty("naming_other_stuff_4")
    String namingOtherStuff4;

    /**
     * 其他证明材料 mediaid
     */
    @JsonProperty("naming_other_stuff_5")
    String namingOtherStuff5;


    public WxSetNicknameParam(String nickname, String idCard, String license) {
        this.nickname = nickname;
        this.idCard = idCard;
        this.license = license;
    }
}
