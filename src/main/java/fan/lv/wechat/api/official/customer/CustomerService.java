package fan.lv.wechat.api.official.customer;

import fan.lv.wechat.entity.official.customer.*;
import fan.lv.wechat.entity.result.WxResult;

/**
 * 客服接口
 *
 * @author lv_fan2008
 * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/Customer_Service/Customer_Service_Management.html" target="_blank">微信官方接口文档</a>
 */
public interface CustomerService {
    /**
     * 获取客服列表
     *
     * @return 客服列表
     * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/Customer_Service/Customer_Service_Management.html" target="_blank">微信官方接口文档</a>
     */
    WxCustomerListResult getCustomerList();

    /**
     * 获取在线客服列表
     *
     * @return 客服列表
     * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/Customer_Service/Customer_Service_Management.html" target="_blank">微信官方接口文档</a>
     */
    WxOnlineCustomerListResult getOnlineCustomerList();

    /**
     * 添加客服帐号
     *
     * @param kfAccount 完整客服帐号，格式为：帐号前缀@公众号微信号，帐号前缀最多10个字符，必须是英文、数字字符或者下划线，
     *                  后缀为公众号微信号，长度不超过30个字符
     * @param nickname  客服昵称，最长16个字
     * @return 添加结果
     * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/Customer_Service/Customer_Service_Management.html" target="_blank">微信官方接口文档</a>
     */
    WxResult addCustomer(String kfAccount, String nickname);

    /**
     * 邀请绑定客服帐号
     *
     * @param kfAccount 完整客服帐号，格式为：帐号前缀@公众号微信号
     * @param inviteWx  客服昵称，最长16个字
     * @return 返回结果
     * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/Customer_Service/Customer_Service_Management.html" target="_blank">微信官方接口文档</a>
     */
    WxResult inviteBindKfAccount(String kfAccount, String inviteWx);

    /**
     * 设置客服信息
     *
     * @param kfAccount 完整客服帐号，格式为：帐号前缀@公众号微信号
     * @param nickname  客服昵称，最长16个字
     * @return 返回结果
     * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/Customer_Service/Customer_Service_Management.html" target="_blank">微信官方接口文档</a>
     */
    WxResult setCustomer(String kfAccount, String nickname);

    /**
     * 设置客服头像
     *
     * @param kfAccount  完整客服帐号，格式为：帐号前缀@公众号微信号
     * @param avatarPath 头像文件路径
     * @return 返回结果
     * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/Customer_Service/Customer_Service_Management.html" target="_blank">微信官方接口文档</a>
     */
    WxResult setCustomerAvatar(String kfAccount, String avatarPath);

    /**
     * 删除客服
     *
     * @param kfAccount 完整客服帐号，格式为：帐号前缀@公众号微信号
     * @return 返回结果
     * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/Customer_Service/Customer_Service_Management.html" target="_blank">微信官方接口文档</a>
     */
    WxResult delCustomer(String kfAccount);

    /**
     * 创建会话，此接口在客服和用户之间创建一个会话，如果该客服和用户会话已存在，则直接返回0。指定的客服帐号必须已经绑定微信号且在线。
     *
     * @param kfAccount 完整客服帐号，格式为：帐号前缀@公众号微信号
     * @param openId    粉丝的openid
     * @return 返回结果
     * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/Customer_Service/Session_control.html" target="_blank">微信官方接口文档</a>
     */
    WxResult createSession(String kfAccount, String openId);

    /**
     * 关闭会话
     *
     * @param kfAccount 完整客服帐号，格式为：帐号前缀@公众号微信号
     * @param openId    粉丝的openid
     * @return 返回结果
     * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/Customer_Service/Session_control.html" target="_blank">微信官方接口文档</a>
     */
    WxResult closeSession(String kfAccount, String openId);

    /**
     * 获取客户会话状态
     *
     * @param openId 粉丝的openid
     * @return 客户会话状态
     * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/Customer_Service/Session_control.html" target="_blank">微信官方接口文档</a>
     */
    WxSessionResult getSession(String openId);

    /**
     * 获取客服会话列表
     *
     * @param kfAccount 完整客服帐号，格式为：帐号前缀@公众号微信号
     * @return 会话列表、
     * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/Customer_Service/Session_control.html" target="_blank">微信官方接口文档</a>
     */
    WxSessionListResult getSessionList(String kfAccount);

    /**
     * 获取未接入会话列表
     *
     * @return 未接入会话列表
     * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/Customer_Service/Session_control.html" target="_blank">微信官方接口文档</a>
     */
    WxWaitSessionListResult getWaitSessionList();

    /**
     * 获取聊天记录
     *
     * @param startTime 起始时间，unix时间戳
     * @param endTime   结束时间，unix时间戳，每次查询时段不能超过24小时
     * @param msgId     消息id顺序从小到大，从1开始
     * @param number    每次获取条数，最多10000条
     * @return 聊天记录
     * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/Customer_Service/Obtain_chat_transcript.html" target="_blank">微信官方接口文档</a>
     */
    WxMsgRecordResult getMsgRecord(Integer startTime, Integer endTime, Integer msgId, Integer number);
}
