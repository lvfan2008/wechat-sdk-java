package fan.lv.wechat.api.mp.service;

import fan.lv.wechat.entity.mp.operation.*;

/**
 * @author lv_fan2008
 */
public interface OperationService {
    /**
     * 获取用户反馈列表
     *
     * @param page 分页的页数，从1开始
     * @param num  分页拉取的数据数量
     * @param type 反馈的类型,null 拉取全部类型，1 无法打开小程序, 2 小程序闪退, 3 卡顿, 4 黑屏白屏, 5 死机, 6 界面错位, 7 界面加载慢, 8 其他异常
     * @return 用户反馈列表
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/operation/operation.getFeedback.html" target="_blank">官方接口文档</a>
     */
    WxGetFeedbackResult getFeedback(Integer page, Integer num, Integer type);

    /**
     * 错误查询
     *
     * @param param 查询参数
     * @return 错误查询列表
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/operation/operation.getJsErrSearch.html" target="_blank">官方接口文档</a>
     */
    WxGetJsErrSearchResult getJsErrSearch(WxGetJsErrSearchParam param);

    /**
     * 性能监控
     *
     * @param param 查询参数
     * @return 性能监控列表
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/operation/operation.getPerformance.html" target="_blank">官方接口文档</a>
     */
    WxGetPerformanceResult getPerformance(WxGetPerformanceParam param);

    /**
     * 获取访问来源
     *
     * @return 访问来源列表
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/operation/operation.getSceneList.html" target="_blank">官方接口文档</a>
     */
    WxGetSceneListResult getSceneList();

    /**
     * 获取客户端版本
     *
     * @return 客户端版本列表
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/operation/operation.getVersionList.html" target="_blank">官方接口文档</a>
     */
    WxGetVersionListResult getVersionList();

    /**
     * 实时日志查询
     *
     * @param param 查询参数
     * @return 实时日志查询结果
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/operation/operation.realtimelogSearch.html" target="_blank">官方接口文档</a>
     */
    WxRealtimeLogSearchResult getRealtimeLogSearch(WxRealtimeLogSearchParam param);
}
