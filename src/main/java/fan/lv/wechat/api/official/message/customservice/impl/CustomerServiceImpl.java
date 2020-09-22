package fan.lv.wechat.api.official.message.customservice.impl;

import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.official.message.customservice.CustomerService;
import fan.lv.wechat.entity.message.customservice.WxCustomerServiceAccountParam;
import fan.lv.wechat.entity.message.customservice.WxDeleteCustomerServiceAccountParam;
import fan.lv.wechat.entity.result.WxResult;

import java.util.Collections;
import java.util.Map;

/**
 * 客服服务接口
 *
 * @author lv_fan2008
 */
public class CustomerServiceImpl implements CustomerService {
    /**
     * 请求客户端
     */
    protected Client client;

    public CustomerServiceImpl(Client client) {
        this.client = client;
    }

    @Override
    public WxResult addAccount(WxCustomerServiceAccountParam param) {
        return client.post("/customservice/kfaccount/add", param, WxResult.class);
    }

    @Override
    public WxResult modifyAccount(WxCustomerServiceAccountParam param) {
        return client.post("/customservice/kfaccount/update", param, WxResult.class);
    }

    @Override
    public WxResult deleteAccount(WxDeleteCustomerServiceAccountParam param) {
        return client.post("/customservice/kfaccount/del", param, WxResult.class);
    }

    @Override
    public WxResult updateAccountAvatar(String customerAccount, String filePath) {
        Map<String, String> queryMap = Collections.singletonMap("kf_account", customerAccount);
        return client.uploadFile("/customservice/kfaccount/uploadheadimg?", queryMap,
                Collections.<String, String>emptyMap(),
                Collections.singletonMap("updateAccountAvatar", filePath),
                WxResult.class);
    }
}
