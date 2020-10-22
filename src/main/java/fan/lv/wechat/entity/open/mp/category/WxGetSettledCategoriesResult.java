package fan.lv.wechat.entity.open.mp.category;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 获取已设置的所有类目结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxGetSettledCategoriesResult extends WxResult {

    /**
     * 类目列表
     */
    List<Category> categories;

    /**
     * 一个更改周期内可以添加类目的次数
     */
    Integer limit;

    /**
     * 本更改周期内还可以添加类目的次数
     */
    Integer quota;

    /**
     * 最多可以设置的类目数量
     */
    @JsonProperty("category_limit")
    Integer categoryLimit;

    @Data
    public static class Category {
        /**
         * 一级类目 ID
         */
        Integer first;

        /**
         * 一级类目名称
         */
        @JsonProperty("first_name")
        String firstName;

        /**
         * 二级类目 ID
         */
        Integer second;

        /**
         * 二级类目名称
         */
        @JsonProperty("second_name")
        String secondName;


        /**
         * 审核状态（1 审核中 2 审核不通过 3 审核通过）
         */
        @JsonProperty("audit_status")
        Integer auditStatus;

        /**
         * 审核不通过的原因
         */
        @JsonProperty("audit_status")
        String auditReason;
    }
}
