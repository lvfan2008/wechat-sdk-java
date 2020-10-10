package fan.lv.wechat.api.mp.service.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.mp.service.OperationService;
import fan.lv.wechat.entity.mp.operation.*;
import fan.lv.wechat.util.JsonUtil;
import fan.lv.wechat.util.SimpleMap;

import java.util.LinkedHashMap;

/**
 * @author lv_fan2008
 */
public class OperationServiceImpl implements OperationService {
    /**
     * 请求客户端
     */
    protected Client client;


    /**
     * @param client 请求客户端
     */
    public OperationServiceImpl(Client client) {
        this.client = client;
    }

    @Override
    public WxGetFeedbackResult getFeedback(Integer page, Integer num, Integer type) {
        return client.get("/wxaapi/feedback/list",
                SimpleMap.of("page", String.valueOf(page), "num", String.valueOf(num), "type",
                        type == null ? null : String.valueOf(type)),
                WxGetFeedbackResult.class);
    }

    @Override
    public WxGetJsErrSearchResult getJsErrSearch(WxGetJsErrSearchParam param) {
        return client.postJson("/wxaapi/log/jserr_search", param, WxGetJsErrSearchResult.class);
    }

    @Override
    public WxGetPerformanceResult getPerformance(WxGetPerformanceParam param) {
        return client.postJson("/wxaapi/log/get_performance", param, WxGetPerformanceResult.class);
    }

    @Override
    public WxGetSceneListResult getSceneList() {
        return client.get("/wxaapi/log/get_scene", WxGetSceneListResult.class);
    }

    @Override
    public WxGetVersionListResult getVersionList() {
        return client.get("/wxaapi/log/get_client_version", WxGetVersionListResult.class);
    }

    @Override
    public WxRealtimeLogSearchResult getRealtimeLogSearch(WxRealtimeLogSearchParam param) {
        SimpleMap<String, String> map = SimpleMap.of("date", param.getDate())
                .add("begintime", String.valueOf(param.getBeginTime()))
                .add("endtime", String.valueOf(param.getEndTime()))
                .add("start", param.getStart() == null ? null : String.valueOf(param.getStart()))
                .add("limit", param.getLimit() == null ? null : String.valueOf(param.getLimit()))
                .add("traceId", param.getTraceId())
                .add("url", param.getUrl())
                .add("id", param.getId())
                .add("filterMsg", param.getFilterMsg())
                .add("level", param.getLevel() == null ? null : String.valueOf(param.getLevel()));
        return client.get("/wxaapi/userlog/userlog_search", map, WxRealtimeLogSearchResult.class);
    }
}
