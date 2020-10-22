package fan.lv.wechat.entity.open.mp.tester;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 获取体验者列表结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxTesterListResult extends WxResult {

    /**
     * 人员列表
     */
    List<Member> members;

    @Data
    public static class Member{
        /**
         * 人员对应的唯一字符串
         */
        @JsonProperty("userstr")
        String userStr;
    }
}
