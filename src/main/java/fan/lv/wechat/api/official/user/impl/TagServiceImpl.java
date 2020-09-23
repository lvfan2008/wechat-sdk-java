package fan.lv.wechat.api.official.user.impl;

import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.official.user.UserService;
import fan.lv.wechat.entity.result.WxResult;
import fan.lv.wechat.entity.user.*;

/**
 * @author lv_fan2008
 */
public class TagServiceImpl implements UserService {
    /**
     * 请求客户端
     */
    protected Client client;

    /**
     * @param client 请求客户端
     */
    public TagServiceImpl(Client client) {
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
}
