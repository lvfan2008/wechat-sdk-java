package fan.lv.wechat.api.official.official;

import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.kernel.impl.ContainerImpl;
import fan.lv.wechat.api.official.Intelligence.AiService;
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
import fan.lv.wechat.entity.official.config.OfficialAccountConfig;

/**
 * @author lv_fan2008
 */
public class OfficialAccountApp extends ContainerImpl implements OfficialAccountService {

    /**
     * @param config 公众号配置
     */
    public OfficialAccountApp(OfficialAccountConfig config) {
        this.bind(OfficialAccountConfig.class, () -> config);
        this.register(new ClientServiceProvider());
        this.register(new OfficialServiceProvider());
    }

    @Override
    public Client getClient() {
        return get(Client.class);
    }

    @Override
    public AccountService getAccountService() {
        return get(AccountService.class);
    }

    @Override
    public MaterialService getMaterialService() {
        return get(MaterialService.class);
    }

    @Override
    public BaseService getBaseService() {
        return get(BaseService.class);
    }

    @Override
    public CommentService getCommentService() {
        return get(CommentService.class);
    }

    @Override
    public CustomerService getCustomerService() {
        return get(CustomerService.class);
    }

    @Override
    public AiService getIntelligenceService() {
        return get(AiService.class);
    }

    @Override
    public JsSdkService getJsSdkService() {
        return get(JsSdkService.class);
    }

    @Override
    public MenuService getMenuService() {
        return get(MenuService.class);
    }

    @Override
    public MassSendService getMassSendService() {
        return get(MassSendService.class);
    }

    @Override
    public TemplateService getTemplateService() {
        return get(TemplateService.class);
    }

    @Override
    public ServerService getServerService() {
        return get(ServerService.class);
    }

    @Override
    public SnsService getSnsService() {
        return get(SnsService.class);
    }

    @Override
    public ArticleStaticService getArticleStaticService() {
        return get(ArticleStaticService.class);
    }

    @Override
    public InterfaceStaticService getInterfaceStaticService() {
        return get(InterfaceStaticService.class);
    }

    @Override
    public MessageStaticService getMessageStaticService() {
        return get(MessageStaticService.class);
    }

    @Override
    public PublisherAdStaticService getPublishAdStaticService() {
        return get(PublisherAdStaticService.class);
    }

    @Override
    public UserStaticService getUserStaticService() {
        return get(UserStaticService.class);
    }

    @Override
    public UserService getUserService() {
        return get(UserService.class);
    }

    @Override
    public UserTagService getUserTagService() {
        return get(UserTagService.class);
    }
}
