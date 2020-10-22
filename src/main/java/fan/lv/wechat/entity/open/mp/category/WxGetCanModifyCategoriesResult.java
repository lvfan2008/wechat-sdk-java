package fan.lv.wechat.entity.open.mp.category;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 获取审核时可填写的类目信息
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxGetCanModifyCategoriesResult extends WxResult {

    /**
     * 类目列表
     */
    @JsonProperty("category_list")
    List<Category>  categoryList;

    @Data
    public static class Category {

        /**
         * 一级类目名称
         */
        @JsonProperty("first_class")
        String firstClass;


        /**
         * 二级类目名称
         */
        @JsonProperty("first_class")
        String secondClass;

        /**
         * 三级类目名称
         */
        @JsonProperty("third_class")
        String thirdClass;


        /**
         * 一级类目的 ID 编号
         */
        @JsonProperty("first_id")
        Integer firstId;


        /**
         * 二级类目的 ID 编号
         */
        @JsonProperty("second_id")
        Integer secondId;


        /**
         * 三级类目的 ID 编号
         */
        @JsonProperty("third_id")
        Integer thirdId;
    }
}
