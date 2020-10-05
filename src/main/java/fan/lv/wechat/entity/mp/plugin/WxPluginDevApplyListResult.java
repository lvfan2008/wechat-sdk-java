package fan.lv.wechat.entity.mp.plugin;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 当前所有插件使用方
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxPluginDevApplyListResult extends WxResult {
    /**
     * 插件使用方列表
     */
    @JsonProperty("apply_list")
    List<Apply> applyList;

    @Data
    public static class Apply {
        /**
         * 使用者的appid
         */
        @JsonProperty("appid")
        String appId;

        /**
         * 插件状态：  1 申请中 2 申请通过 3 已拒绝 4 已超时
         */
        Integer status;

        /**
         * 使用者的昵称
         */
        String nickname;

        /**
         * 使用者的头像
         */
        @JsonProperty("headimgurl")
        String headImgUrl;

        /**
         * 模版类型，2 为一次性订阅，3 为长期订阅
         */
        List<Category> categories;

        /**
         * 使用者的申请时间
         */
        @JsonProperty("create_time")
        Integer createTime;

        /**
         * 使用者的小程序码
         */
        @JsonProperty("apply_url")
        String applyUrl;

        /**
         * 使用者的申请说明
         */
        String reason;
    }

    @Data
    public static class Category {
        /**
         * 一级类目
         */
        String first;

        /**
         * 二级类目
         */
        String second;

    }
}
