package fan.lv.wechat.api.official.customer.impl;

import com.google.common.collect.ImmutableMap;
import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.official.customer.CustomerService;
import fan.lv.wechat.entity.official.customer.WxCustomerListResult;
import fan.lv.wechat.entity.official.customer.WxOnlineCustomerListResult;
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
        Map<String, String> map = ImmutableMap.of("kf_account", kfAccount, "nickname", nickname);
        return client.post("/customservice/kfaccount/add", map, WxResult.class);
    }

    @Override
    public WxResult inviteBindKfAccount(String kfAccount, String inviteWx) {
        Map<String, String> map = ImmutableMap.of("kf_account", kfAccount, "invite_wx", inviteWx);
        return client.post("/customservice/kfaccount/inviteworker", map, WxResult.class);
    }

    @Override
    public WxResult setCustomer(String kfAccount, String nickname) {
        Map<String, String> map = ImmutableMap.of("kf_account", kfAccount, "nickname", nickname);
        return client.post("/customservice/kfaccount/update", map, WxResult.class);
    }

    @Override
    public WxResult setCustomerAvatar(String kfAccount, String avatarPath) {
        Map<String, String> queryMap = ImmutableMap.of("kf_account", kfAccount);
        return client.uploadFile("/customservice/kfaccount/uploadheadimg", queryMap,
                ImmutableMap.<String, String>of(),
                ImmutableMap.of("media", avatarPath),
                WxResult.class);
    }

    @Override
    public WxResult delCustomer(String kfAccount) {
        return client.get("/customservice/kfaccount/del",
                ImmutableMap.of("kf_account", kfAccount),
                WxResult.class);
    }
}
