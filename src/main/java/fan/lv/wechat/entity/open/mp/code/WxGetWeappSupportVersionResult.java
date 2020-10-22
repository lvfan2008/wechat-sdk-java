package fan.lv.wechat.entity.open.mp.code;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 提交审核结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxGetWeappSupportVersionResult extends WxResult {

    /**
     * 当前版本
     */
    @JsonProperty("now_version")
    String nowVersion;

    /**
     * 用户占比列表
     */
    @JsonProperty("uv_info")
    UvInfo uvInfo;

    @Data
    public static class UvInfo {
        /**
         * 用户占比列表
         */
        List<UvInfoItem> items;
    }

    @Data
    public static class UvInfoItem{
        /**
         * 百分比
         */
        Double percentage;

        /**
         * 基础库版本号
         */
        String version;
    }
}
