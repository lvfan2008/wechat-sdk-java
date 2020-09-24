package fan.lv.wechat.api.official.user.impl;

import fan.lv.wechat.api.official.Util;
import fan.lv.wechat.api.official.user.UserService;
import fan.lv.wechat.entity.result.WxResult;
import fan.lv.wechat.entity.user.tag.*;
import junit.framework.TestCase;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author lv_fan2008
 */
public class UserServiceImplTest extends TestCase {

    UserService userService;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        userService = new UserServiceImpl(Util.getClient());
    }

    public void testSetUserRemark() {
        WxResult result = userService.setUserRemark(Util.getProperty("user_id"), "remark haha");
        assertTrue(result.success());
    }

    public void testGetUserInfo() {
        WxGetUserInfoResult result = userService.getUserInfo(Util.getProperty("user_id"), "zh_CN");
        assertTrue(result.success());
    }

    public void testBatchGetUserInfo() {
        WxBatchGetUserInfoParam.UserParam user = new WxBatchGetUserInfoParam.UserParam(Util.getProperty("user_id"), "zh_CN");
        WxBatchGetUserInfoResult result = userService.batchGetUserInfo(
                new WxBatchGetUserInfoParam(Arrays.asList(ArrayUtils.toArray(user))));
        assertTrue(result.success());
    }

    public void testGetSubscribeUserList() {
        WxGetSubscribeUserResult result = userService.getSubscribeUserList(null);
        assertTrue(result.success());
    }

    public void testGetBlackUserList() {
        WxGetBlackUserResult result = userService.getBlackUserList(null);
        assertTrue(result.success());
    }

    public void testBatchBlackUser() {
        WxResult result = userService.batchBlackUser(Collections.singletonList(Util.getProperty("user_id")));
        assertTrue(result.success());
    }

    public void testBatchCancelBlackUser() {
        WxResult result = userService.batchCancelBlackUser(Collections.singletonList(Util.getProperty("user_id")));
        assertTrue(result.success());
    }
}