package fan.lv.wechat.entity.mp.plugin;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 已添加的插件
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxPluginListResult extends WxResult {
    /**
     * 申请或使用中的插件列表
     */
    @JsonProperty("plugin_list")
    List<WxPlugin> pluginList;

    @Data
    public static class WxPlugin {
        /**
         * 插件 appId
         */
        @JsonProperty("appid")
        String appId;

        /**
         * 插件状态：  1 申请中 2 申请通过 3 已拒绝 4 已超时
         */
        Integer status;

        /**
         * 插件昵称
         */
        String nickname;

        /**
         * 插件头像
         */
        @JsonProperty("headimgurl")
        String headImgUrl;
    }
}
