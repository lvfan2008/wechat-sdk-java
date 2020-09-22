package fan.lv.wechat.api.official.message.customservice.impl;

import fan.lv.wechat.api.official.Util;
import fan.lv.wechat.api.official.message.customservice.CustomerService;
import fan.lv.wechat.entity.message.customservice.WxCustomerServiceAccountParam;
import fan.lv.wechat.entity.message.customservice.WxDeleteCustomerServiceAccountParam;
import fan.lv.wechat.entity.result.WxResult;
import junit.framework.TestCase;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author lv_fan2008
 */
public class CustomerServiceImplTest extends TestCase {

    CustomerService menuService;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        menuService = new CustomerServiceImpl(Util.getClient());
    }

    public void testAddAccount() {
        WxResult wxResult = menuService.addAccount(new WxCustomerServiceAccountParam("user001@test.com", "客服1", DigestUtils.md5Hex("123456")));
        assertTrue(wxResult.success());
    }

    public void testModifyAccount() {
        WxResult wxResult = menuService.modifyAccount(new WxCustomerServiceAccountParam("user001@test.com", "客服001", DigestUtils.md5Hex("1234567")));
        assertTrue(wxResult.success());
    }

    public void testDeleteAccount() {
        WxResult wxResult = menuService.addAccount(new WxCustomerServiceAccountParam("user002@test.com", "客服2", DigestUtils.md5Hex("123456")));
        wxResult = menuService.deleteAccount(new WxDeleteCustomerServiceAccountParam("user002@test.com"));
        assertTrue(wxResult.success());
    }

    public void testUpdateAccountAvatar() {
        WxResult wxResult = menuService.updateAccountAvatar("user001@test.com",Util.getProperty("customer.avatar"));
        assertTrue(wxResult.success());
    }
}