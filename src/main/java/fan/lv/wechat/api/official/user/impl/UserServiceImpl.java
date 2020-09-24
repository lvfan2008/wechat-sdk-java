package fan.lv.wechat.api.official.user.impl;

import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.official.user.UserService;
import fan.lv.wechat.entity.official.user.*;
import fan.lv.wechat.entity.result.WxResult;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lv_fan2008
 */
public class UserServiceImpl implements UserService {

    /**
     * 请求客户端
     */
    protected Client client;

    /**
     * @param client 请求客户端
     */
    public UserServiceImpl(Client client) {
        this.client = client;
    }

    @Override
    public WxResult setUserRemark(String openId, String remark) {
        return client.post("/cgi-bin/user/info/updateremark", new WxUserRemarkParam(openId, remark), WxResult.class);
    }

    @Override
    public WxGetUserInfoResult getUserInfo(String openId, String lang) {
        Map<String, String> map = new HashMap<>();
        map.put("openid", openId);
        if (lang != null) {
            map.put("lang", lang);
        }
        return client.get("/cgi-bin/user/info", map, WxGetUserInfoResult.class);
    }

    @Override
    public WxBatchGetUserInfoResult batchGetUserInfo(WxBatchGetUserInfoParam wxBatchGetUserInfoParam) {
        return client.post("/cgi-bin/user/info/batchget", wxBatchGetUserInfoParam, WxBatchGetUserInfoResult.class);
    }

    @Override
    public WxGetSubscribeUserResult getSubscribeUserList(String nextOpenId) {
        return client.get("/cgi-bin/user/get",
                nextOpenId == null ? Collections.<String, String>emptyMap()
                        : Collections.singletonMap("next_openid", nextOpenId),
                WxGetSubscribeUserResult.class);
    }

    @Override
    public WxGetBlackUserResult getBlackUserList(String beginOpenid) {
        Object object = beginOpenid == null ? Collections.<String, String>emptyMap()
                : Collections.singletonMap("begin_openid", beginOpenid);
        return client.post("/cgi-bin/tags/members/getblacklist", object, WxGetBlackUserResult.class);
    }

    @Override
    public WxResult batchBlackUser(List<String> openIdList) {
        Object object = Collections.singletonMap("openid_list", openIdList);
        return client.post("/cgi-bin/tags/members/batchblacklist", object, WxResult.class);
    }

    @Override
    public WxResult batchCancelBlackUser(List<String> openIdList) {
        Object object = Collections.singletonMap("openid_list", openIdList);
        return client.post("/cgi-bin/tags/members/batchunblacklist", object, WxResult.class);
    }
}
