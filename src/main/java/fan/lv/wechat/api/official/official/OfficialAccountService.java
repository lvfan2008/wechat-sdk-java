package fan.lv.wechat.api.official.official;

import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.official.Intelligence.IntelligenceService;
import fan.lv.wechat.api.official.account.AccountService;
import fan.lv.wechat.api.official.asset.MaterialService;
import fan.lv.wechat.api.official.base.BaseService;
import fan.lv.wechat.api.official.comment.CommentService;
import fan.lv.wechat.api.official.customer.CustomerService;
import fan.lv.wechat.api.official.jssdk.JsSdkService;
import fan.lv.wechat.api.official.menu.MenuService;
import fan.lv.wechat.api.official.message.MassSendService;
import fan.lv.wechat.api.official.message.TemplateService;
import fan.lv.wechat.api.official.server.ServerService;
import fan.lv.wechat.api.official.sns.SnsService;
import fan.lv.wechat.api.official.statics.*;
import fan.lv.wechat.api.official.user.UserService;
import fan.lv.wechat.api.official.user.UserTagService;

/**
 * @author lv_fan2008
 */
public interface OfficialAccountService {

    /**
     * 得到api客户端，可以独立请求以后扩展的api
     *
     * @return api客户端
     */
    Client getClient();

    /**
     * 得到账号管理服务
     *
     * @return 账号管理服务
     */
    AccountService getAccountService();

    /**
     * 得到素材管理服务
     *
     * @return 素材管理服务
     */
    MaterialService getMaterialService();

    /**
     * 得到基础服务，包含调用次数清零、网络监测、获取微信IP等
     *
     * @return 基础服务
     */
    BaseService getBaseService();

    /**
     * 得到图文消息留言管理服务
     *
     * @return 图文消息留言管理服务
     */
    CommentService getCommentService();

    /**
     * 得到客服管理服务
     *
     * @return 客服管理服务
     */
    CustomerService getCustomerService();

    /**
     * 得到智能接口服务
     *
     * @return 智能接口服务
     */
    IntelligenceService getIntelligenceService();

    /**
     * 得到JsSdk服务
     *
     * @return JsSdk服务
     */
    JsSdkService getJsSdkService();

    /**
     * 得到菜单管理服务
     *
     * @return 菜单管理服务
     */
    MenuService getMenuService();

    /**
     * 得到群发服务
     *
     * @return 群发服务
     */
    MassSendService getMassSendService();

    /**
     * 得到模板消息接口服务
     *
     * @return 模板消息接口服务
     */
    TemplateService getTemplateService();

    /**
     * 得到服务端服务,包括回调消息验证，消息处理机制
     *
     * @return 服务端服务
     */
    ServerService getServerService();

    /**
     * 得到网页授权服务
     *
     * @return 网页授权服务
     */
    SnsService getSnsService();

    /**
     * 得到图文分析统计服务
     *
     * @return 图文分析统计服务
     */
    ArticleStaticService getArticleStaticService();

    /**
     * 得到接口分析统计服务
     *
     * @return 接口分析统计服务
     */
    InterfaceStaticService getInterfaceStaticService();

    /**
     * 得到消息分析统计服务
     *
     * @return 消息分析统计服务
     */
    MessageStaticService getMessageStaticService();

    /**
     * 得到广告分析统计服务
     *
     * @return 广告分析统计服务
     */
    PublisherAdStaticService getPublishAdStaticService();

    /**
     * 得到用户分析统计服务
     *
     * @return 用户分析统计服务
     */
    UserStaticService getUserStaticService();

    /**
     * 得到用户服务
     *
     * @return 用户服务
     */
    UserService getUserService();

    /**
     * 得到用户标签服务
     *
     * @return 用户标签服务
     */
    UserTagService getUserTagService();
}
