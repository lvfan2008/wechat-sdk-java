package fan.lv.wechat.api.official.statics.impl;

import fan.lv.wechat.util.SimpleMap;
import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.official.statics.MessageStaticService;
import fan.lv.wechat.entity.official.statics.*;

import java.util.Map;

/**
 * @author lv_fan2008
 */
public class MessageStaticServiceImpl implements MessageStaticService {

    /**
     * 请求客户端
     */
    protected Client client;

    /**
     * @param client 请求客户端
     */
    public MessageStaticServiceImpl(Client client) {
        this.client = client;
    }

    @Override
    public WxUpStreamMsgResult getUpStreamMsgData(String beginDate, String endDate) {
        Map<String, String> map = SimpleMap.of("begin_date", beginDate, "end_date", endDate);
        return client.postJson("/datacube/getupstreammsg", map, WxUpStreamMsgResult.class);
    }

    @Override
    public WxUpStreamMsgHourResult getUpStreamMsgHourData(String beginDate, String endDate) {
        Map<String, String> map = SimpleMap.of("begin_date", beginDate, "end_date", endDate);
        return client.postJson("/datacube/getupstreammsghour", map, WxUpStreamMsgHourResult.class);
    }

    @Override
    public WxUpStreamMsgWeekResult getUpStreamMsgWeekData(String beginDate, String endDate) {
        Map<String, String> map = SimpleMap.of("begin_date", beginDate, "end_date", endDate);
        return client.postJson("/datacube/getupstreammsgweek", (Object) map, WxUpStreamMsgWeekResult.class);
    }

    @Override
    public WxUpStreamMsgMonthResult getUpStreamMsgMonthData(String beginDate, String endDate) {
        Map<String, String> map = SimpleMap.of("begin_date", beginDate, "end_date", endDate);
        return client.postJson("/datacube/getupstreammsgmonth", (Object) map, WxUpStreamMsgMonthResult.class);
    }

    @Override
    public WxUpStreamMsgDistResult getUpStreamMsgDistData(String beginDate, String endDate) {
        Map<String, String> map = SimpleMap.of("begin_date", beginDate, "end_date", endDate);
        return client.postJson("/datacube/getupstreammsgdist", (Object) map, WxUpStreamMsgDistResult.class);
    }

    @Override
    public WxUpStreamMsgDistWeekResult getUpStreamMsgDistWeekData(String beginDate, String endDate) {
        Map<String, String> map = SimpleMap.of("begin_date", beginDate, "end_date", endDate);
        return client.postJson("/datacube/getupstreammsgdistweek", (Object) map, WxUpStreamMsgDistWeekResult.class);
    }

    @Override
    public WxUpStreamMsgDistMonthResult getUpStreamMsgDistMonthData(String beginDate, String endDate) {
        Map<String, String> map = SimpleMap.of("begin_date", beginDate, "end_date", endDate);
        return client.postJson("/datacube/getupstreammsgdistmonth", (Object) map, WxUpStreamMsgDistMonthResult.class);
    }
}
