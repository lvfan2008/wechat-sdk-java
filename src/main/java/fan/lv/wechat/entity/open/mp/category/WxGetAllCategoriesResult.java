package fan.lv.wechat.entity.open.mp.category;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 获取可以设置的所有类目结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxGetAllCategoriesResult extends WxResult {

    /**
     * 类目列表
     */
    @JsonProperty("categories_list")
    CategoriesList categoriesList;

    @Data
    public static class CategoriesList {
        /**
         * 类目列表
         */
        List<Category> categories;
    }

    @Data
    public static class Category {
        /**
         * 类目 ID
         */
        Integer id;

        /**
         * 类目名称
         */
        String name;

        /**
         * 类目层级
         */
        Integer level;

        /**
         * 类目父级 ID
         */
        Integer father;

        /**
         * 子级类目 ID
         */
        List<Integer> children;


        /**
         * 是否为敏感类目（1 为敏感类目，需要提供相应资质审核；0 为非敏感类目，无需审核）
         */
        @JsonProperty("sensitive_type")
        Integer sensitiveType;

        /**
         * sensitive_type 为 1 的类目需要提供的资质证明
         */
        Qualify qualify;

    }

    @Data
    public static class Qualify {
        /**
         * sensitive_type 为 1 的类目
         */
        @JsonProperty("exter_list")
        List<Exter> exterList;

        /**
         * 备注
         */
        String remark;
    }

    @Data
    public static class Exter {
        /**
         * 敏感类目需提供的资质信息说明
         */
        @JsonProperty("inner_list")
        List<Inner> innerList;
    }

    @Data
    public static class Inner {
        /**
         * 资质文件名称
         */
        String name;

        /**
         * 资质文件示例
         */
        String url;
    }
}
