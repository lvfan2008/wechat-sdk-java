package fan.lv.wechat.api.official.official;

import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.kernel.impl.DefaultCacheImpl;
import fan.lv.wechat.api.official.Intelligence.AiService;
import fan.lv.wechat.api.official.Intelligence.impl.AiServiceImpl;
import fan.lv.wechat.api.official.Util;
import fan.lv.wechat.api.official.account.AccountService;
import fan.lv.wechat.api.official.account.impl.AccountServiceImpl;
import fan.lv.wechat.api.official.base.BaseService;
import fan.lv.wechat.api.official.base.impl.BaseServiceImpl;
import fan.lv.wechat.api.official.base.impl.ClientImpl;
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
import junit.framework.TestCase;

/**
 * @author lv_fan2008
 */
public class OfficialAccountAppTest extends TestCase {

    OfficialAccountApp officialAccountApp;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        OfficialAccountConfig config = new OfficialAccountConfig(
                Util.getProperty("app_id"), Util.getProperty("app_secret"),
                Util.getProperty("aes_key"), Util.getProperty("token"),
                new DefaultCacheImpl()
        );
        officialAccountApp = new OfficialAccountApp(config);
    }

    public void testBindServices() {
        assertEquals(officialAccountApp.get(OfficialAccountConfig.class).getClass(), OfficialAccountConfig.class);
        assertEquals(officialAccountApp.get(Client.class).getClass(), ClientImpl.class);
        assertEquals(officialAccountApp.get(AccountService.class).getClass(), AccountServiceImpl.class);
        assertEquals(officialAccountApp.get(BaseService.class).getClass(), BaseServiceImpl.class);
        assertEquals(officialAccountApp.get(CommentService.class).getClass(), CommentServiceImpl.class);
        assertEquals(officialAccountApp.get(CustomerService.class).getClass(), CustomerServiceImpl.class);
        assertEquals(officialAccountApp.get(AiService.class).getClass(), AiServiceImpl.class);
        assertEquals(officialAccountApp.get(JsSdkService.class).getClass(), JsSdkServiceImpl.class);
        assertEquals(officialAccountApp.get(MenuService.class).getClass(), MenuServiceImpl.class);
        assertEquals(officialAccountApp.get(MassSendService.class).getClass(), MassSendServiceImpl.class);
        assertEquals(officialAccountApp.get(TemplateService.class).getClass(), TemplateServiceImpl.class);
        assertEquals(officialAccountApp.get(ServerService.class).getClass(), ServerServiceImpl.class);
        assertEquals(officialAccountApp.get(SnsService.class).getClass(), SnsServiceImpl.class);
        assertEquals(officialAccountApp.get(ArticleStaticService.class).getClass(), ArticleStaticServiceImpl.class);
        assertEquals(officialAccountApp.get(PublisherAdStaticService.class).getClass(), PublisherAdStaticServiceImpl.class);
        assertEquals(officialAccountApp.get(UserStaticService.class).getClass(), UserStaticServiceImpl.class);
        assertEquals(officialAccountApp.get(MessageStaticService.class).getClass(), MessageStaticServiceImpl.class);
        assertEquals(officialAccountApp.get(InterfaceStaticService.class).getClass(), InterfaceStaticServiceImpl.class);
        assertEquals(officialAccountApp.get(UserService.class).getClass(), UserServiceImpl.class);
        assertEquals(officialAccountApp.get(UserTagService.class).getClass(), UserTagServiceImpl.class);
    }
}