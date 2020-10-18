package fan.lv.wechat.api.official.official;

import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.kernel.container.Container;
import fan.lv.wechat.api.kernel.container.ServiceProvider;
import fan.lv.wechat.api.official.Intelligence.AiService;
import fan.lv.wechat.api.official.Intelligence.impl.AiServiceImpl;
import fan.lv.wechat.api.official.account.AccountService;
import fan.lv.wechat.api.official.account.impl.AccountServiceImpl;
import fan.lv.wechat.api.official.base.BaseService;
import fan.lv.wechat.api.official.base.impl.BaseServiceImpl;
import fan.lv.wechat.api.official.comment.CommentService;
import fan.lv.wechat.api.official.comment.impl.CommentServiceImpl;
import fan.lv.wechat.api.official.customer.CustomerService;
import fan.lv.wechat.api.official.customer.impl.CustomerServiceImpl;
import fan.lv.wechat.api.official.jssdk.JsSdkService;
import fan.lv.wechat.api.official.jssdk.imp.JsSdkServiceImpl;
import fan.lv.wechat.api.official.menu.MenuService;
import fan.lv.wechat.api.official.menu.impl.MenuServiceImpl;
import fan.lv.wechat.api.official.message.MassSendService;
import fan.lv.wechat.api.official.message.TemplateService;
import fan.lv.wechat.api.official.message.impl.MassSendServiceImpl;
import fan.lv.wechat.api.official.message.impl.TemplateServiceImpl;
import fan.lv.wechat.api.official.server.ServerService;
import fan.lv.wechat.api.official.server.impl.ServerServiceImpl;
import fan.lv.wechat.api.official.sns.SnsService;
import fan.lv.wechat.api.official.sns.impl.SnsServiceImpl;
import fan.lv.wechat.api.official.statics.*;
import fan.lv.wechat.api.official.statics.impl.*;
import fan.lv.wechat.api.official.user.UserService;
import fan.lv.wechat.api.official.user.UserTagService;
import fan.lv.wechat.api.official.user.impl.UserServiceImpl;
import fan.lv.wechat.api.official.user.impl.UserTagServiceImpl;
import fan.lv.wechat.entity.official.config.OfficialAccountConfig;

/**
 * @author lv_fan2008
 */
public class OfficialServiceProvider implements ServiceProvider {
    @Override
    public void register(Container container) {
        OfficialAccountConfig config = container.get(OfficialAccountConfig.class);
        Client client = container.get(Client.class);
        container.bind(AccountService.class, () -> new AccountServiceImpl(client));
        container.bind(BaseService.class, () -> new BaseServiceImpl(client, config.getAppId()));
        container.bind(CommentService.class, () -> new CommentServiceImpl(client));
        container.bind(CustomerService.class, () -> new CustomerServiceImpl(client));
        container.bind(AiService.class, () -> new AiServiceImpl(client));
        container.bind(JsSdkService.class, () -> new JsSdkServiceImpl(config.getAppId(), client, config.getCache()));
        container.bind(MenuService.class, () -> new MenuServiceImpl(client));
        container.bind(MassSendService.class, () -> new MassSendServiceImpl(client));
        container.bind(TemplateService.class, () -> new TemplateServiceImpl(client));
        container.bind(ServerService.class, () -> new ServerServiceImpl(config.getEncodingAesKey(), config.getToken(), config.getAppId()));
        container.bind(SnsService.class, () -> new SnsServiceImpl(config.getAppId(), config.getAppSecret(), config.getCache()));
        container.bind(ArticleStaticService.class, () -> new ArticleStaticServiceImpl(client));
        container.bind(PublisherAdStaticService.class, () -> new PublisherAdStaticServiceImpl(client));
        container.bind(UserStaticService.class, () -> new UserStaticServiceImpl(client));
        container.bind(MessageStaticService.class, () -> new MessageStaticServiceImpl(client));
        container.bind(InterfaceStaticService.class, () -> new InterfaceStaticServiceImpl(client));
        container.bind(UserService.class, () -> new UserServiceImpl(client));
        container.bind(UserTagService.class, () -> new UserTagServiceImpl(client));
    }
}
