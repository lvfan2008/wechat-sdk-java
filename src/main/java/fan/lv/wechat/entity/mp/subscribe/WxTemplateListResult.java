package fan.lv.wechat.entity.mp.subscribe;

import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 帐号下的个人模板列表
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxTemplateListResult extends WxResult {
    /**
     * 模板标题列表
     */
    List<Template> data;

    @Data
    public static class Template {
        /**
         * 模版标题 id
         */
        String priTmplId;

        /**
         * 模版标题
         */
        String title;

        /**
         * 模版内容
         */
        String content;

        /**
         * 模板内容示例
         */
        String example;

        /**
         * 模版类型，2 为一次性订阅，3 为长期订阅
         */
        Integer type;
    }
}
