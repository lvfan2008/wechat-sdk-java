package fan.lv.wechat.api.official.customer;

import fan.lv.wechat.entity.official.customer.WxCustomerListResult;
import fan.lv.wechat.entity.official.customer.WxOnlineCustomerListResult;
import fan.lv.wechat.entity.result.WxResult;

/**
 * 客服接口
 *
 * @author lv_fan2008
 * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/Analytics/Analytics_API.html" target="_blank">微信官方接口文档</a>
 */
public interface CustomerService {
    /**
     * 获取客服列表
     *
     * @return 客服列表
     */
    WxCustomerListResult getCustomerList();

    /**
     * 获取在线客服列表
     *
     * @return 客服列表
     */
    WxOnlineCustomerListResult getOnlineCustomerList();

    /**
     * 添加客服帐号
     *
     * @param kfAccount 完整客服帐号，格式为：帐号前缀@公众号微信号，帐号前缀最多10个字符，必须是英文、数字字符或者下划线，
     *                  后缀为公众号微信号，长度不超过30个字符
     * @param nickname  客服昵称，最长16个字
     * @return 添加结果
     */
    WxResult addCustomer(String kfAccount, String nickname);

    /**
     * 邀请绑定客服帐号
     *
     * @param kfAccount 完整客服帐号，格式为：帐号前缀@公众号微信号
     * @param inviteWx  客服昵称，最长16个字
     * @return 返回结果
     */
    WxResult inviteBindKfAccount(String kfAccount, String inviteWx);

    /**
     * 设置客服信息
     *
     * @param kfAccount 完整客服帐号，格式为：帐号前缀@公众号微信号
     * @param nickname  客服昵称，最长16个字
     * @return 返回结果
     */
    WxResult setCustomer(String kfAccount, String nickname);

    /**
     * 设置客服头像
     *
     * @param kfAccount  完整客服帐号，格式为：帐号前缀@公众号微信号
     * @param avatarPath 头像文件路径
     * @return 返回结果
     */
    WxResult setCustomerAvatar(String kfAccount, String avatarPath);

    /**
     * 删除客服
     *
     * @param kfAccount 完整客服帐号，格式为：帐号前缀@公众号微信号
     * @return 返回结果
     */
    WxResult delCustomer(String kfAccount);
}
