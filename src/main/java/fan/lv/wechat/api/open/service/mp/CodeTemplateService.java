package fan.lv.wechat.api.open.service.mp;

import fan.lv.wechat.entity.open.mp.codetemplate.WxGetTemplateDraftListResult;
import fan.lv.wechat.entity.open.mp.codetemplate.WxGetTemplateListResult;
import fan.lv.wechat.entity.result.WxResult;

/**
 * 代码模板设置
 *
 * @author lv_fan2008
 */
public interface CodeTemplateService {
    /**
     * 获取代码草稿列表
     *
     * @return 代码草稿列表
     */
    WxGetTemplateDraftListResult getTemplateDraftList();

    /**
     * 将草稿添加到代码模板库
     *
     * @param draftId 草稿 ID
     * @return 添加结果
     */
    WxResult addToTemplate(Integer draftId);

    /**
     * 获取代码模板列表
     *
     * @return 代码模板列表
     */
    WxGetTemplateListResult getTemplateList();

    /**
     * 删除指定代码模板
     *
     * @param templateId 要删除的模板 ID
     * @return 删除结果
     */
    WxResult deleteTemplate(String templateId);
}
