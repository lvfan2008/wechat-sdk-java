package fan.lv.wechat.api.official.message;

import fan.lv.wechat.entity.message.template.*;
import fan.lv.wechat.entity.result.WxResult;

/**
 * 模板消息接口
 *
 * @author lv_fan2008
 * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Template_Message_Interface.html#0" target="_blank">微信官方接口文档</a>
 */
public interface TemplateService {


    /**
     * 设置所属行业
     *
     * @param industryId1 行业编号
     * @param industryId2 行业编号
     * @return 设置结果
     */
    WxResult setIndustry(Integer industryId1, Integer industryId2);

    /**
     * 获取设置的行业信息
     *
     * @return 行业信息
     */
    WxIndustryResult getIndustry();

    /**
     * 获得模板ID
     *
     * @param templateIdShort 模板库中模板的编号，有“TM**”和“OPENTMTM**”等形式
     * @return 模板Id信息
     */
    WxGetTemplateIdResult getTemplateId(String templateIdShort);

    /**
     * 获取模板列表
     *
     * @return 模板列表
     */
    WxTemplateListResult getTemplateList();

    /**
     * 删除模板
     *
     * @param templateId 模板Id
     * @return 删除模板结果
     */
    WxResult deleteTemplateId(String templateId);

    /**
     * 发送模板消息
     *
     * @param wxTemplateMessageParam 模板消息参数
     * @return 发送结果
     */
    WxSendTemplateMessageResult sendTemplateMessage(WxTemplateMessageParam wxTemplateMessageParam);
}
