package fan.lv.wechat.api.open.service.authorizer.impl;

import fan.lv.wechat.api.official.customer.CustomerService;
import fan.lv.wechat.api.official.server.MessageCallback;
import fan.lv.wechat.api.official.server.impl.ServerServiceImpl;
import fan.lv.wechat.api.open.service.open.OpenPlatformService;
import fan.lv.wechat.entity.official.customer.message.TextKfMessage;
import fan.lv.wechat.entity.official.server.message.BaseReceiveMessage;
import fan.lv.wechat.entity.official.server.message.BaseReplyMessage;
import fan.lv.wechat.entity.official.server.message.CommonTextMessage;
import fan.lv.wechat.entity.official.server.message.ReplyTextMessage;
import fan.lv.wechat.entity.open.config.OpenPlatformConfig;

/**
 * @author lv_fan2008
 */
public class AuthorizerServerImpl extends ServerServiceImpl {
    /**
     * 第三方授权的appId
     */
    String authorizerAppId;

    /**
     * 开放平台服务
     */
    OpenPlatformService open;

    /**
     * 构造函数
     *
     * @param config          开放平台配置
     * @param open            开放平台服务
     * @param authorizerAppId 公众号或小程序appId
     */
    public AuthorizerServerImpl(OpenPlatformConfig config, OpenPlatformService open, String authorizerAppId) {
        super(config.getAesKey(), config.getToken(), config.getComponentAppId());
        this.authorizerAppId = authorizerAppId;
        messageCallback(new GlobalTestCallback(authorizerAppId, open));
    }

    /**
     * 全网发布接入测试
     */
    public static class GlobalTestCallback implements MessageCallback {

        String appId;

        OpenPlatformService open;

        public GlobalTestCallback(String appId, OpenPlatformService open) {
            this.appId = appId;
            this.open = open;
        }

        @Override
        public BaseReplyMessage handle(BaseReceiveMessage message) {
            if (!isGlobalTestMpAppId(appId) && !isGlobalTestOfficialAppId(appId)) {
                return null;
            }
            if (message instanceof CommonTextMessage) {
                CommonTextMessage msg = (CommonTextMessage) message;
                if ("TESTCOMPONENT_MSG_TYPE_TEXT".equals(msg.getContent())) {
                    if (isGlobalTestMpAppId(appId)) {
                        // 小程序 只能推送客服消息，自动回复不起作用
                        CustomerService customer = open.getMpApp(appId).get(CustomerService.class);
                        customer.sendMessage(message.getFromUserName(), new TextKfMessage("TESTCOMPONENT_MSG_TYPE_TEXT_callback"));
                        return null;
                    } else {
                        // 公众号，回复文本消息
                        return new ReplyTextMessage("TESTCOMPONENT_MSG_TYPE_TEXT_callback");
                    }
                }

                if (msg.getContent().startsWith("QUERY_AUTH_CODE:")) {
                    String authCode = msg.getContent().substring("QUERY_AUTH_CODE:".length());
                    open.getAuthorizationInfo(authCode);
                    CustomerService customerService = open.getOfficialApp(appId).get(CustomerService.class);
                    customerService.sendMessage(message.getFromUserName(), new TextKfMessage(authCode + "_from_api"));
                    return null;
                }
            }
            return null;
        }


        protected boolean isGlobalTestMpAppId(String appId) {
            return "wxd101a85aa106f53e".equals(appId);
        }

        protected boolean isGlobalTestOfficialAppId(String appId) {
            return "wx570bc396a51b8ff8".equals(appId);
        }
    }
}
