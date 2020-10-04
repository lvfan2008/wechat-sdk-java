package fan.lv.wechat.entity.mp.datacube;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 小程序新增或活跃用户的画像分布数据
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxUserPortraitResult extends WxResult {

    /**
     * 时间范围，如："20170611-20170617"
     */
    @JsonProperty("ref_date")
    String refDate;

    /**
     * 新用户画像
     */
    @JsonProperty("visit_uv_new")
    UserPortrait visitUvNew;

    /**
     * 活跃用户画像
     */
    @JsonProperty("visit_uv")
    UserPortrait visitUv;

    @Data
    public static class UserPortrait {

        /**
         * 分布类型
         */
        Integer index;


        /**
         * 省份，如北京、广东等
         */
        List<Property> province;

        /**
         * 城市，如北京、广州等
         */
        List<Property> city;

        /**
         * 性别，包括男、女、未知
         */
        List<Property> genders;

        /**
         * 终端类型，包括 iPhone，android，其他
         */
        List<Property> platforms;

        /**
         * 机型，如苹果 iPhone 6，OPPO R9 等
         */
        List<Property> devices;

        /**
         * 年龄，包括17岁以下、18-24岁等区间
         */
        List<Property> ages;

    }

    @Data
    public static class Property {
        /**
         * 属性值id
         */
        Integer id;

        /**
         * 属性值名称，与id对应。如属性为 province 时，返回的属性值名称包括「广东」等。
         */
        String name;

        /**
         * 该场景访问uv
         */
        Integer accessSourceVisitUv;
    }
}
