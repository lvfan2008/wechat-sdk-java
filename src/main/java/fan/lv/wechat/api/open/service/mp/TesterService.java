package fan.lv.wechat.api.open.service.mp;

import fan.lv.wechat.entity.open.mp.tester.WxBindTesterResult;
import fan.lv.wechat.entity.open.mp.tester.WxTesterListResult;
import fan.lv.wechat.entity.result.WxResult;

/**
 * @author lv_fan2008
 */
public interface TesterService {

    /**
     * 绑定微信用户为体验者
     *
     * @param wechatId 微信号
     * @return 绑定结果
     */
    WxBindTesterResult bindTester(String wechatId);

    /**
     * 解除绑定体验者
     *
     * @param wechatId 微信号
     * @param userStr  人员对应的唯一字符串， 可通过获取已绑定的体验者列表获取人员对应的字符串
     *                 wechatId 和 userStr 填写其中一个即可
     * @return 返回结果
     */
    WxResult unbindTester(String wechatId, String userStr);

    /**
     * 获取体验者列表
     *
     * @return 体验者列表
     */
    WxTesterListResult getTesterList();

}
