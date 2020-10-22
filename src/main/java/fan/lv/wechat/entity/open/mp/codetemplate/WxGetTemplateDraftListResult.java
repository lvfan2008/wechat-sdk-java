package fan.lv.wechat.entity.open.mp.codetemplate;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 获取代码草稿列表结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxGetTemplateDraftListResult extends WxResult {

    /**
     * 草稿信息列表
     */
    @JsonProperty("draft_list")
    List<Draft> draftList;

    @Data
    public static class Draft {
        /**
         * 说开发者上传草稿时间戳
         */
        @JsonProperty("create_time")
        Integer createTime;

        /**
         * 版本号，开发者自定义字段
         */
        @JsonProperty("user_version")
        String userVersion;

        /**
         * 版本描述   开发者自定义字段
         */
        @JsonProperty("user_desc")
        String userDesc;

        /**
         * 草稿 id
         */
        @JsonProperty("draft_id")
        Integer draftId;
    }
}
