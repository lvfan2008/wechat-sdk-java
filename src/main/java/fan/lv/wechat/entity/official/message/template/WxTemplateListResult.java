package fan.lv.wechat.entity.official.message.template;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxTemplateListResult extends WxResult {

    /**
     * 模板列表
     */
    @JsonProperty("template_list")
    List<Template> templateList;

    @Data
    public static class Template {
        /**
         * 模板ID
         */
        @JsonProperty("template_id")
        String templateId;

        /**
         * 模板标题
         */
        String title;

        /**
         * 模板所属行业的一级行业
         */
        @JsonProperty("primary_industry")
        String primaryIndustry;

        /**
         * 模板所属行业的二级行业
         */
        @JsonProperty("deputy_industry")
        String deputyIndustry;

        /**
         * 模板内容
         */
        String content;

        /**
         * 模板示例
         */
        String example;
    }
}
