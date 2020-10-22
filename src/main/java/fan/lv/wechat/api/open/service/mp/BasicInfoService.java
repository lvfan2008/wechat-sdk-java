package fan.lv.wechat.api.open.service.mp;

import fan.lv.wechat.entity.open.mp.basicinfo.*;
import fan.lv.wechat.entity.result.WxResult;

import java.util.List;

/**
 * 小程序基础信息服务
 *
 * @author lv_fan2008
 */
public interface BasicInfoService {

    /**
     * 获取小程序基本信息
     *
     * @return 小程序基本信息
     */
    WxMpBasicInfoResult getMpBasicInfo();

    /**
     * 设置服务器域名
     *
     * @param action          操作类型
     * @param requestDomain   request 合法域名；当 action 是 get 时不需要此字段
     * @param wsRequestDomain socket 合法域名；当 action 是 get 时不需要此字段
     * @param uploadDomain    uploadFile 合法域名；当 action 是 get 时不需要此字段
     * @param downloadDomain  downloadFile 合法域名；当 action 是 get 时不需要此字段
     * @return 设置服务器域名结果
     */
    WxModifyDomainResult modifyDomain(String action, List<String> requestDomain, List<String> wsRequestDomain,
                                      List<String> uploadDomain, List<String> downloadDomain);


    /**
     * 设置业务域名
     *
     * @param action        操作类型，如果没有指定 action，则默认将第三方平台登记的小程序业务域名全部添加到该小程序
     * @param webViewDomain 小程序业务域名，当 action 参数是 get 时不需要此字段
     * @return 返回结果
     */
    WxResult modifyWebViewDomain(String action, List<String> webViewDomain);

    /**
     * 设置名称
     * 调用本接口可以设置小程序名称，当名称没有命中关键词，则直接设置成功；当名称命中关键词，需提交证明材料，并需要审核。
     * 审核结果会向消息与事件接收 URL 进行事件推送。使用过程中如遇到问题，可在开放平台服务商专区发帖交流
     *
     * @param param 设置名称参数
     * @return 设置结果
     */
    WxSetNicknameResult setNickname(WxSetNicknameParam param);

    /**
     * 微信认证名称检测
     * 注：该接口只允许通过api创建的小程序使用。
     *
     * @param nickname 名称（昵称）
     * @return 微信认证名称检测结果
     */
    WxVerifyNicknameResult verifyNickname(String nickname);

    /**
     * 查询改名审核状态
     *
     * @param auditId 审核单 id
     * @return 改名审核状态
     */
    WxQueryNicknameAuditResult queryNicknameAudit(String auditId);


    /**
     * 修改头像
     *
     * @param headImgMediaId 头像素材 media_id
     * @param x1             裁剪框左上角 x 坐标（取值范围：[0, 1]）
     * @param y1             裁剪框左上角 y 坐标（取值范围：[0, 1]）
     * @param x2             裁剪框右下角 x 坐标（取值范围：[0, 1]）
     * @param y2             裁剪框右下角 y 坐标（取值范围：[0, 1]）
     * @return 修改结果
     */
    WxResult modifyHeadImage(String headImgMediaId, Double x1, Double y1, Double x2, Double y2);

    /**
     * 修改功能介绍
     *
     * @param signature 功能介绍（简介）
     * @return 修改结果
     */
    WxResult modifySignature(String signature);

    /**
     * 查询隐私设置，通过本接口可以查询小程序当前的隐私设置，即是否可被搜索。
     *
     * @return 查询隐私设置结果
     */
    WxGetSearchStatusResult getSearchStatus();

    /**
     * 修改隐私设置,通过本接口修改小程序隐私设置，即修改是否可被搜索，可以先查询小程序当前的隐私设置再决定是否修改
     *
     * @param status 1 表示不可搜索，0 表示可搜索
     * @return 返回结果
     */
    WxResult setSearchStatus(Integer status);
}
