package fan.lv.wechat.api.mp;

import fan.lv.wechat.entity.mp.subscribe.*;
import fan.lv.wechat.entity.result.WxResult;

import java.util.List;

/**
 * 订阅消息服务
 *
 * @author lv_fan2008
 */
public interface SubscribeService {
    /**
     * 组合模板并添加至帐号下的个人模板库
     *
     * @param tid       模板标题 id，可通过接口获取，也可登录小程序后台查看获取
     * @param kidList   开发者自行组合好的模板关键词列表，关键词顺序可以自由搭配（例如 [3,5,4] 或 [4,5,3]），最多支持5个，最少2个关键词组合
     * @param sceneDesc 服务场景描述，15个字以内
     * @return 模板Id结果
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/subscribe-message/subscribeMessage.addTemplate.html" target="_blank">微信官方文档</a>
     */
    WxAddTemplateResult addTemplate(String tid, List<Integer> kidList, String sceneDesc);

    /**
     * 删除帐号下的个人模板
     *
     * @param priTmplId 要删除的模板id
     * @return 返回结果
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/subscribe-message/subscribeMessage.deleteTemplate.html" target="_blank">微信官方文档</a>
     */
    WxResult deleteTemplate(String priTmplId);

    /**
     * 获取小程序账号的类目
     *
     * @return 程序账号的类目
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/subscribe-message/subscribeMessage.getCategory.html" target="_blank">微信官方文档</a>
     */
    WxCategoryResult getCategory();

    /**
     * 获取模板标题下的关键词列表
     *
     * @param tid 模板标题 id，可通过接口获取
     * @return 模板标题下的关键词列表
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/subscribe-message/subscribeMessage.getPubTemplateKeyWordsById.html" target="_blank">微信官方文档</a>
     */
    WxPubTemplateKeywordsResult getPubTemplateKeywords(String tid);


    /**
     * 获取帐号所属类目下的公共模板标题
     *
     * @param ids   类目 id，多个用逗号隔开
     * @param start 用于分页，表示从 start 开始。从 0 开始计数。
     * @param limit 用于分页，表示拉取 limit 条记录。最大为 30
     * @return 帐号所属类目下的公共模板标题
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/subscribe-message/subscribeMessage.getPubTemplateTitleList.html" target="_blank">微信官方文档</a>
     */
    WxPubTemplateTitleResult getPubTemplateTitle(String ids, Integer start, Integer limit);


    /**
     * 获取当前帐号下的个人模板列表
     *
     * @return 前帐号下的个人模板列表
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/subscribe-message/subscribeMessage.getTemplateList.html" target="_blank">微信官方文档</a>
     */
    WxTemplateListResult getTemplateList();

    /**
     * 发送订阅消息
     *
     * @param param 发送模板内容
     * @return 返回结果
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/subscribe-message/subscribeMessage.send.html" target="_blank">微信官方文档</a>
     */
    WxResult send(WxSendTemplateParam param);
}
