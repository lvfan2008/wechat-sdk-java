package fan.lv.wechat.api.official.message.customservice;

import fan.lv.wechat.entity.message.customservice.WxCustomerServiceAccountParam;
import fan.lv.wechat.entity.message.customservice.WxDeleteCustomerServiceAccountParam;
import fan.lv.wechat.entity.result.WxResult;

/**
 * 客服接口(老接口废弃)
 *
 * @author lv_fan2008
 * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Service_Center_messages.html" target="_blank">微信官方接口文档</a>
 */
@Deprecated
public interface CustomerService {

    /**
     * 添加客服账号
     *
     * @param param 客服账号
     * @return 添加结果
     */
    WxResult addAccount(WxCustomerServiceAccountParam param);

    /**
     * 修改客服账号
     *
     * @param param 客服账号
     * @return 修改结果
     */
    WxResult modifyAccount(WxCustomerServiceAccountParam param);

    /**
     * 删除客服账号
     *
     * @param param 客服账号
     * @return 修改结果
     */
    WxResult deleteAccount(WxDeleteCustomerServiceAccountParam param);

    /**
     * 设置客服帐号的头像
     *
     * @param customerAccount 客服账号
     * @param filePath        头像全路径
     * @return 设置结果
     */
    WxResult updateAccountAvatar(String customerAccount, String filePath);

}
