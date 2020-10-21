package fan.lv.wechat.api.open.service.open;

import fan.lv.wechat.entity.result.WxResult;

/**
 * @author lv_fan2008
 * @see <a href="https://developers.weixin.qq.com/doc/oplatform/Third-party_Platforms/Mini_Programs/Fast_Registration_Interface_document.html" target="_blank">微信官方接口文档</a>
 */
public interface OpenFastRegisterMpService {

    /**
     * 创建小程序接口
     *
     * @param name               企业名（需与工商部门登记信息一致）
     * @param code               企业代码
     * @param codeType           企业代码类型 1：统一社会信用代码（18 位） 2：组织机构代码（9 位 xxxxxxxx-x） 3：营业执照注册号(15 位)
     * @param legalPersonaWechat 法人微信号
     * @param legalPersonaName   法人姓名（绑定银行卡）
     * @param componentPhone     第三方联系电话
     * @return 返回结果
     */
    WxResult fastRegister(String name, String code, Integer codeType, String legalPersonaWechat,
                          String legalPersonaName, String componentPhone);

    /**
     * 查询创建任务状态
     *
     * @param name               企业名（需与工商部门登记信息一致）
     * @param legalPersonaWechat 法人微信号
     * @param legalPersonaName   法人姓名（绑定银行卡）
     * @return 返回结果
     */
    WxResult queryFastRegisterState(String name, String legalPersonaWechat, String legalPersonaName);
}
