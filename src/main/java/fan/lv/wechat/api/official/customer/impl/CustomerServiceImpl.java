package fan.lv.wechat.api.official.customer.impl;

import fan.lv.wechat.util.SimpleMap;
import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.official.customer.CustomerService;
import fan.lv.wechat.entity.official.customer.*;
import fan.lv.wechat.entity.official.customer.message.BaseKfMessage;
import fan.lv.wechat.entity.result.WxResult;

import java.util.Map;

/**
 * @author lv_fan2008
 */
public class CustomerServiceImpl implements CustomerService {

    /**
     * 请求客户端
     */
    protected Client client;

    /**
     * @param client 请求客户端
     */
    public CustomerServiceImpl(Client client) {
        this.client = client;
    }

    @Override
    public WxCustomerListResult getCustomerList() {
        return client.get("/cgi-bin/customservice/getkflist", WxCustomerListResult.class);
    }

    @Override
    public WxOnlineCustomerListResult getOnlineCustomerList() {
        return client.get("/cgi-bin/customservice/getonlinekflist", WxOnlineCustomerListResult.class);
    }

    @Override
    public WxResult addCustomer(String kfAccount, String nickname) {
        Map<String, String> map = SimpleMap.of("kf_account", kfAccount, "nickname", nickname);
        return client.postJson("/customservice/kfaccount/add", map, WxResult.class);
    }

    @Override
    public WxResult inviteBindKfAccount(String kfAccount, String inviteWx) {
        Map<String, String> map = SimpleMap.of("kf_account", kfAccount, "invite_wx", inviteWx);
        return client.postJson("/customservice/kfaccount/inviteworker", map, WxResult.class);
    }

    @Override
    public WxResult setCustomer(String kfAccount, String nickname) {
        Map<String, String> map = SimpleMap.of("kf_account", kfAccount, "nickname", nickname);
        return client.postJson("/customservice/kfaccount/update", map, WxResult.class);
    }

    @Override
    public WxResult setCustomerAvatar(String kfAccount, String avatarPath) {
        Map<String, String> queryMap = SimpleMap.of("kf_account", kfAccount);
        return client.uploadFile("/customservice/kfaccount/uploadheadimg", queryMap,
                SimpleMap.<String, String>of(),
                SimpleMap.of("media", avatarPath),
                WxResult.class);
    }

    @Override
    public WxResult delCustomer(String kfAccount) {
        return client.get("/customservice/kfaccount/del",
                SimpleMap.of("kf_account", kfAccount),
                WxResult.class);
    }

    @Override
    public WxResult createSession(String kfAccount, String openId) {
        Map<String, String> map = SimpleMap.of("kf_account", kfAccount, "openid", openId);
        return client.postJson("/customservice/kfsession/create", map, WxResult.class);
    }

    @Override
    public WxResult closeSession(String kfAccount, String openId) {
        Map<String, String> map = SimpleMap.of("kf_account", kfAccount, "openid", openId);
        return client.postJson("/customservice/kfsession/close", map, WxResult.class);
    }

    @Override
    public WxSessionResult getSession(String openId) {
        return client.get("/customservice/kfsession/getsession", SimpleMap.of("openid", openId),
                WxSessionResult.class);
    }

    @Override
    public WxSessionListResult getSessionList(String kfAccount) {
        return client.get("/customservice/kfsession/getsessionlist", SimpleMap.of("kf_account", kfAccount),
                WxSessionListResult.class);
    }

    @Override
    public WxWaitSessionListResult getWaitSessionList() {
        return client.get("/customservice/kfsession/getwaitcase", WxWaitSessionListResult.class);
    }

    @Override
    public WxMsgRecordResult getMsgRecord(Integer startTime, Integer endTime, Integer msgId, Integer number) {
        Map<String, Integer> map = SimpleMap.of(
                "starttime", (startTime), "endtime", (endTime),
                "msgid", (msgId), "number", (number)
        );
        return client.postJson("/customservice/kfsession/close", map, WxMsgRecordResult.class);
    }

    @Override
    public WxResult sendMessage(String toUser, BaseKfMessage kfMessage) {
        kfMessage.setToUser(toUser);
        return client.postJson("/cgi-bin/message/custom/send", kfMessage, WxResult.class);
    }

    @Override
    public WxResult sendKfTypingState(String toUser, String command) {
        Map<String, String> map = SimpleMap.of("touser", toUser, "command", command);
        return client.postJson("/cgi-bin/message/custom/typing", map, WxResult.class);
    }
}
