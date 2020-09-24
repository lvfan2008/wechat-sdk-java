package fan.lv.wechat.api.official.user;

import fan.lv.wechat.entity.official.user.*;
import fan.lv.wechat.entity.result.WxResult;

import java.util.List;

/**
 * 用户管理接口
 *
 * @author lv_fan2008
 */
public interface UserService {

    /**
     * 指定用户设置备注名
     *
     * @param openId 用户标识
     * @param remark 新的备注名，长度必须小于30字符
     * @return 返回结果
     * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/User_Management/Configuring_user_notes.html" target="_blank">微信官方接口文档</a>
     */
    WxResult setUserRemark(String openId, String remark);

    /**
     * 获取用户基本信息(UnionID机制)
     *
     * @param openId 普通用户的标识，对当前公众号唯一
     * @param lang   返回国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语
     * @return 用户基本信息
     * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/User_Management/Get_users_basic_information_UnionID.html#UinonId" target="_blank">微信官方接口文档</a>
     */
    WxGetUserInfoResult getUserInfo(String openId, String lang);

    /**
     * 批量获取用户基本信息,最多支持一次拉取100条。
     *
     * @param wxBatchGetUserInfoParam 用户OpenId列表
     * @return 用户信息列表
     * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/User_Management/Get_users_basic_information_UnionID.html#UinonId" target="_blank">微信官方接口文档</a>
     */
    WxBatchGetUserInfoResult batchGetUserInfo(WxBatchGetUserInfoParam wxBatchGetUserInfoParam);

    /**
     * 获取帐号的关注者列表
     *
     * @param nextOpenId 第一个拉取的OPENID，不填(null)默认从头开始拉取
     * @return 关注者列表
     * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/User_Management/Getting_a_User_List.html" target="_blank">微信官方接口文档</a>
     */
    WxGetSubscribeUserResult getSubscribeUserList(String nextOpenId);

    /**
     * 获取公众号的黑名单列表
     *
     * @param beginOpenid 第一个拉取的OPENID，不填(null)默认从头开始拉取
     * @return 黑名单列表
     * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/User_Management/Manage_blacklist.html" target="_blank">微信官方接口文档</a>
     */
    WxGetBlackUserResult getBlackUserList(String beginOpenid);

    /**
     * 拉黑用户
     *
     * @param openIdList 需要拉入黑名单的用户的openid，一次拉黑最多允许20个
     * @return 返回结果
     * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/User_Management/Manage_blacklist.html" target="_blank">微信官方接口文档</a>
     */
    WxResult batchBlackUser(List<String> openIdList);

    /**
     * 取消拉黑用户
     *
     * @param openIdList 拉入黑名单的用户的openid，一次最多允许20个
     * @return 返回结果
     * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/User_Management/Manage_blacklist.html" target="_blank">微信官方接口文档</a>
     */
    WxResult batchCancelBlackUser(List<String> openIdList);
}
