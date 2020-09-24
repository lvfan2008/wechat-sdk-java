package fan.lv.wechat.api.official.user.impl;

import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.official.user.UserTagService;
import fan.lv.wechat.entity.result.WxResult;
import fan.lv.wechat.entity.user.tag.*;

import java.util.List;

/**
 * @author lv_fan2008
 */
public class UserTagServiceImpl implements UserTagService {
    /**
     * 请求客户端
     */
    protected Client client;

    /**
     * @param client 请求客户端
     */
    public UserTagServiceImpl(Client client) {
        this.client = client;
    }

    @Override
    public WxCreateTagResult createTag(String name) {
        return client.post("/cgi-bin/tags/create", new WxCreateTagParam(name), WxCreateTagResult.class);
    }

    @Override
    public WxGetTagsResult getTags() {
        return client.get("/cgi-bin/tags/get", WxGetTagsResult.class);
    }

    @Override
    public WxResult updateTag(Integer id, String name) {
        return client.post("/cgi-bin/tags/update", new WxUpdateTagParam(id, name), WxResult.class);
    }

    @Override
    public WxResult deleteTag(Integer id) {
        return client.post("/cgi-bin/tags/delete", new WxDeleteTagParam(id), WxResult.class);
    }

    @Override
    public WxGetTagUserResult getTagUser(Integer tagId, String nextOpenId) {
        return client.post("/cgi-bin/user/tag/get", new WxGetTagUserParam(tagId, nextOpenId), WxGetTagUserResult.class);
    }

    @Override
    public WxResult batchTag(List<String> openIds, Integer tagId) {
        return client.post("/cgi-bin/tags/members/batchtagging", new WxBatchTagParam(openIds, tagId), WxResult.class);
    }

    @Override
    public WxResult batchCancelTag(List<String> openIds, Integer tagId) {
        return client.post("/cgi-bin/tags/members/batchuntagging", new WxBatchTagParam(openIds, tagId), WxResult.class);
    }

    @Override
    public WxGetUserTagListResult getUserTagList(String openId) {
        return client.post("/cgi-bin/tags/getidlist", new WxGetUserTagListParam(openId), WxGetUserTagListResult.class);
    }
}
