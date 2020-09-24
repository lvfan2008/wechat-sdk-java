package fan.lv.wechat.api.official.user.impl;

import fan.lv.wechat.api.official.Util;
import fan.lv.wechat.api.official.user.UserTagService;
import fan.lv.wechat.entity.result.WxResult;
import fan.lv.wechat.entity.user.tag.WxCreateTagResult;
import fan.lv.wechat.entity.user.tag.WxGetTagUserResult;
import fan.lv.wechat.entity.user.tag.WxGetTagsResult;
import fan.lv.wechat.entity.user.tag.WxGetUserTagListResult;
import junit.framework.TestCase;

import java.util.Collections;
import java.util.Random;

/**
 * @author lv_fan2008
 */
public class UserTagServiceImplTest extends TestCase {
    UserTagService userTagService;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        userTagService = new UserTagServiceImpl(Util.getClient());
    }

    public void testCreateTag() {
        String name = String.valueOf(new Random().nextInt());
        WxCreateTagResult result = userTagService.createTag(name);
        assertTrue(result.success());
    }

    public void testGetTags() {
        String name = String.valueOf(new Random().nextInt());
        WxCreateTagResult result = userTagService.createTag(name);
        WxGetTagsResult tagResult = userTagService.getTags();
        assertTrue(tagResult.success());
    }

    public void testUpdateTag() {
        String name = String.valueOf(new Random().nextInt());
        WxCreateTagResult result = userTagService.createTag(name);
        WxResult tagResult = userTagService.updateTag(result.getTag().getId(), name + "-dd");
        assertTrue(tagResult.success());
    }

    public void testDeleteTag() {
        String name = String.valueOf(new Random().nextInt());
        WxCreateTagResult result = userTagService.createTag(name);
        WxResult tagResult = userTagService.deleteTag(result.getTag().getId());
        assertTrue(tagResult.success());
    }

    public void testGetTagUser() {
        String name = String.valueOf(new Random().nextInt());
        WxCreateTagResult result = userTagService.createTag(name);
        WxGetTagUserResult tagResult = userTagService.getTagUser(result.getTag().getId(), null);
        assertTrue(tagResult.success());
    }

    public void testBatchTag() {
        String name = String.valueOf(new Random().nextInt());
        WxCreateTagResult result = userTagService.createTag(name);
        WxResult tagResult = userTagService.batchTag(Collections.singletonList(Util.getProperty("user_id")), result.getTag().getId());
        assertTrue(tagResult.success());
    }


    public void testGetUserTagList() {
        String name = String.valueOf(new Random().nextInt());
        WxCreateTagResult createTagResult = userTagService.createTag(name);
        userTagService.batchTag(Collections.singletonList(Util.getProperty("user_id")), createTagResult.getTag().getId());
        WxGetUserTagListResult tagResult = userTagService.getUserTagList(Util.getProperty("user_id"));
        assertTrue(tagResult.success());
    }

    public void testBatchCancelTag() {
        WxGetTagsResult tagsResult = userTagService.getTags();
        WxResult tagResult = userTagService.batchCancelTag(Collections.singletonList(Util.getProperty("user_id")),
                tagsResult.getTags().get(0).getId());
        assertTrue(tagResult.success());
    }
}