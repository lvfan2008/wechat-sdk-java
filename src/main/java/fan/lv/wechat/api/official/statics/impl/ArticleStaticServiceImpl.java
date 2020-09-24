package fan.lv.wechat.api.official.statics.impl;

import com.google.common.collect.ImmutableMap;
import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.official.statics.ArticleStaticService;
import fan.lv.wechat.entity.official.statics.*;

import java.util.Map;

/**
 * @author lv_fan2008
 */
public class ArticleStaticServiceImpl implements ArticleStaticService {

    /**
     * 请求客户端
     */
    protected Client client;

    /**
     * @param client 请求客户端
     */
    public ArticleStaticServiceImpl(Client client) {
        this.client = client;
    }

    @Override
    public WxArticlesSummaryResult getArticlesSummary(String beginDate, String endDate) {
        Map<String, String> map = ImmutableMap.of("begin_date", beginDate, "end_date", endDate);
        return client.post("/datacube/getarticlesummary", (Object) map, WxArticlesSummaryResult.class);
    }

    @Override
    public WxArticleTotalResult getArticleTotal(String beginDate, String endDate) {
        Map<String, String> map = ImmutableMap.of("begin_date", beginDate, "end_date", endDate);
        return client.post("/datacube/getarticletotal", (Object) map, WxArticleTotalResult.class);
    }

    @Override
    public WxUserReadResult getUserRead(String beginDate, String endDate) {
        Map<String, String> map = ImmutableMap.of("begin_date", beginDate, "end_date", endDate);
        return client.post("/datacube/getuserread", (Object) map, WxUserReadResult.class);
    }

    @Override
    public WxUserReadHourResult getUserReadHour(String beginDate, String endDate) {
        Map<String, String> map = ImmutableMap.of("begin_date", beginDate, "end_date", endDate);
        return client.post("/datacube/getuserreadhour", (Object) map, WxUserReadHourResult.class);
    }

    @Override
    public WxUserShareResult getUserShare(String beginDate, String endDate) {
        Map<String, String> map = ImmutableMap.of("begin_date", beginDate, "end_date", endDate);
        return client.post("/datacube/getusershare", (Object) map, WxUserShareResult.class);
    }

    @Override
    public WxUserShareHourResult getUserShareHour(String beginDate, String endDate) {
        Map<String, String> map = ImmutableMap.of("begin_date", beginDate, "end_date", endDate);
        return client.post("/datacube/getusersharehour", (Object) map, WxUserShareHourResult.class);
    }


}
