package fan.lv.wechat.entity.mp.subscribe;

import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 模板标题下的关键词列表
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxPubTemplateKeywordsResult extends WxResult {
    /**
     * 模版标题列表总数
     */
    Integer count;

    /**
     * 类目列表
     */
    List<PubTemplateKeywords> data;

    @Data
    public static class PubTemplateKeywords {
        /**
         * 关键词 id，选用模板时需要
         */
        Integer kid;

        /**
         * 关键词内容
         */
        String name;

        /**
         * 关键词内容对应的示例
         */
        String example;

        /**
         * 参数类型
         */
        String rule;
    }
}
