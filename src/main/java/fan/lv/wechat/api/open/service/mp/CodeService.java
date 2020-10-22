package fan.lv.wechat.api.open.service.mp;

import fan.lv.wechat.entity.open.mp.code.*;
import fan.lv.wechat.entity.result.WxResult;

/**
 * @author lv_fan2008
 */
public interface CodeService {
    /**
     * 上传小程序代码
     *
     * @param templateId  代码库中的代码模板 ID
     * @param extJson     第三方自定义的配置(json格式）
     * @param userVersion 代码版本号，开发者可自定义（长度不要超过 64 个字符）
     * @param userDesc    代码描述，开发者可自定义
     * @return 上传结果
     */
    WxResult uploadCode(String templateId, String extJson, String userVersion, String userDesc);

    /**
     * 获取已上传的代码的页面列表
     *
     * @return 已上传的代码的页面列表
     */
    WxGetPageListResult getPageList();

    /**
     * 获取体验版二维码
     *
     * @param path 指定二维码扫码后直接进入指定页面并可同时带上参数
     * @return 体验版二维码的数据流，失败可以查看原因
     */
    WxResult getTesterQrCode(String path);

    /**
     * 提交审核
     *
     * @param param 提交审核参数
     * @return 提交结果
     */
    WxSubmitCodeResult submitCode(WxSubmitCodeParam param);

    /**
     * 查询指定发布审核单的审核状态
     *
     * @param auditId 提交审核时获得的审核 id
     * @return 审核状态
     */
    WxGetAuditStatusResult getAuditStatus(Integer auditId);

    /**
     * 查询最新一次提交的审核状态
     *
     * @return 审核状态
     */
    WxGetAuditStatusResult getLatestAuditStatus();

    /**
     * 小程序审核撤回
     *
     * @return 撤回结果
     */
    WxResult undoCodeAudit();

    /**
     * 发布已通过审核的小程序
     *
     * @return 发布结果
     */
    WxResult release();

    /**
     * 版本回退
     * 调用本接口可以将小程序的线上版本进行回退。使用过程中如遇到问题，可在开放平台服务商专区发帖交流。
     * <p>
     * 注意：
     * <p>
     * 如果没有上一个线上版本，将无法回退
     * 只能向上回退一个版本，即当前版本回退后，不能再调用版本回退接口
     *
     * @return 发布结果
     */
    WxResult revertCodeRelease();

    /**
     * 分阶段发布
     *
     * @param grayPercentage 灰度的百分比 1 ~ 100 的整数
     * @return 返回结果
     */
    WxResult grayRelease(Integer grayPercentage);

    /**
     * 查询当前分阶段发布详情
     *
     * @return 当前分阶段发布详情
     */
    WxGetGrayReleasePlanResult getGrayReleasePlan();

    /**
     * 取消分阶段发布
     *
     * @return 返回结果
     */
    WxResult revertGrayRelease();

    /**
     * 修改小程序线上代码的可见状态
     *
     * @param action 设置可访问状态，发布后默认可访问，close 为不可见，open 为可见
     * @return 修改结果
     */
    WxResult changeVisitStatus(String action);

    /**
     * 查询当前设置的最低基础库版本及各版本用户占比
     *
     * @return 当前设置的最低基础库版本及各版本用户占比
     */
    WxGetWeappSupportVersionResult getWeappSupportVersion();

    /**
     * 设置最低基础库版本
     *
     * @param version 为已发布的基础库版本号
     * @return 设置结果
     */
    WxResult setWeappSupportVersion(String version);

    /**
     * 查询服务商的当月提审限额（quota）和加急次数
     *
     * @return 查询结果
     */
    WxQueryQuotaResult queryQuota();

    /**
     * 加急审核申请
     *
     * @param auditId 审核单ID
     * @return 返回结果
     */
    WxResult speedupAudit(Integer auditId);
}
