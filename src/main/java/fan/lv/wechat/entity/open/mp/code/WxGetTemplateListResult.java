package fan.lv.wechat.entity.open.mp.code;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 获取代码模板列表结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxGetTemplateListResult extends WxResult {

    /**
     * 模板信息列表
     */
    @JsonProperty("template_list")
    List<Template> templateList;

    @Data
    public static class Template {
        /**
         * 说开发者上传草稿时间戳
         */
        @JsonProperty("create_time")
        Integer createTime;

        /**
         * 模板版本号，开发者自定义字段
         */
        @JsonProperty("user_version")
        String userVersion;

        /**
         * 模板描述，开发者自定义字段
         */
        @JsonProperty("user_desc")
        String userDesc;

        /**
         * 模板 id
         */
        @JsonProperty("template_id")
        Integer templateId;
    }
}
