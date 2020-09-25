package fan.lv.wechat.api.official.customer.impl;

import fan.lv.wechat.api.official.Util;
import fan.lv.wechat.api.official.customer.CustomerService;
import fan.lv.wechat.entity.official.customer.WxCustomerListResult;
import fan.lv.wechat.entity.official.customer.WxOnlineCustomerListResult;
import fan.lv.wechat.entity.result.WxResult;
import junit.framework.TestCase;

import java.util.Random;

/**
 * @author lv_fan2008
 */
public class CustomerServiceImplTest extends TestCase {
    CustomerService customerService;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        customerService = new CustomerServiceImpl(Util.getClient());
    }

    public void testGetCustomerList() {
        WxCustomerListResult result = customerService.getCustomerList();
        assertTrue(result.success() || result.getErrorCode() == 65400);
    }

    public void testGetOnlineCustomerList() {
        WxOnlineCustomerListResult result = customerService.getOnlineCustomerList();
        assertTrue(result.success() || result.getErrorCode() == 65400);
    }

    public void testAddCustomer() {
        String rand = String.valueOf((new Random().nextInt()));
        WxResult result = customerService.addCustomer("user" + rand + "@test", "nick" + rand);
        assertTrue(result.success() || result.getErrorCode() == 65400);
    }

    public void testInviteBindKfAccount() {
        String rand = String.valueOf((new Random().nextInt()));
        String account = "user" + rand + "@test";
        String wx = "wx" + rand;
        customerService.addCustomer(account, "nick" + rand);
        WxResult result2 = customerService.inviteBindKfAccount(account, wx);
        assertTrue(result2.success() || result2.getErrorCode() == 65400);
    }

    public void testSetCustomer() {
        String rand = String.valueOf((new Random().nextInt()));
        String account = "user" + rand + "@test";
        String nick2 = "nick2" + rand;
        customerService.addCustomer(account, "nick" + rand);
        WxResult result2 = customerService.setCustomer(account, nick2);
        assertTrue(result2.success() || result2.getErrorCode() == 65400);
    }

    public void testSetCustomerAvatar() {
        String rand = String.valueOf((new Random().nextInt()));
        String account = "user" + rand + "@test";
        customerService.addCustomer(account, "nick" + rand);
        WxResult result2 = customerService.setCustomerAvatar(account, Util.getProperty("thumb.path"));
        assertTrue(result2.success() || result2.getErrorCode() == 65400);
    }

    public void testDelCustomer() {
        String rand = String.valueOf((new Random().nextInt()));
        String account = "user" + rand + "@test";
        customerService.addCustomer(account, "nick" + rand);
        WxResult result2 = customerService.delCustomer(account);
        assertTrue(result2.success() || result2.getErrorCode() == 65400);
    }

    public void testCreateSession() {
        String rand = String.valueOf((new Random().nextInt()));
        String account = "user" + rand + "@test";
        WxResult result = customerService.createSession(account, Util.getProperty("user_id"));
        assertTrue(result.success() || result.getErrorCode() == 65400);
    }

    public void testCloseSession() {
        String rand = String.valueOf((new Random().nextInt()));
        String account = "user" + rand + "@test";
        customerService.createSession(account, Util.getProperty("user_id"));
        WxResult result = customerService.closeSession(account, Util.getProperty("user_id"));
        assertTrue(result.success() || result.getErrorCode() == 65400);
    }


    public void testGetSession() {
        String rand = String.valueOf((new Random().nextInt()));
        String account = "user" + rand + "@test";
        customerService.createSession(account, Util.getProperty("user_id"));
        WxResult result = customerService.getSession(Util.getProperty("user_id"));
        assertTrue(result.success() || result.getErrorCode() == 65400);
    }

    public void testGetSessionList() {
        String rand = String.valueOf((new Random().nextInt()));
        String account = "user" + rand + "@test";
        customerService.createSession(account, Util.getProperty("user_id"));
        WxResult result = customerService.getSessionList(account);
        assertTrue(result.success() || result.getErrorCode() == 65400);
    }

    public void testGetWaitSessionList() {
        WxResult result = customerService.getWaitSessionList();
        assertTrue(result.success() || result.getErrorCode() == 65400);
    }
}