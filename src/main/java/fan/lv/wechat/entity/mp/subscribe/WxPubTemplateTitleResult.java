package fan.lv.wechat.entity.mp.subscribe;

import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 帐号所属类目下的公共模板标题
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxPubTemplateTitleResult extends WxResult {
    /**
     * 模版标题列表总数
     */
    Integer count;

    /**
     * 模板标题列表
     */
    List<PubTemplateTitle> data;

    @Data
    public static class PubTemplateTitle {
        /**
         * 模版标题 id
         */
        Integer tid;

        /**
         * 关键词内容
         */
        String title;

        /**
         * 模版类型，2 为一次性订阅，3 为长期订阅
         */
        Integer type;

        /**
         * 模版所属类目 id
         */
        Integer categoryId;
    }
}
