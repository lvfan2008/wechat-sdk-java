package fan.lv.wechat.api.official.statics.impl;

import com.google.common.collect.ImmutableMap;
import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.official.statics.InterfaceStaticService;
import fan.lv.wechat.entity.official.statics.*;

import java.util.Map;

/**
 * @author lv_fan2008
 */
public class InterfaceStaticServiceImpl implements InterfaceStaticService {

    /**
     * 请求客户端
     */
    protected Client client;

    /**
     * @param client 请求客户端
     */
    public InterfaceStaticServiceImpl(Client client) {
        this.client = client;
    }

    @Override
    public WxInterfaceSummaryResult getInterfaceSummary(String beginDate, String endDate) {
        Map<String, String> map = ImmutableMap.of("begin_date", beginDate, "end_date", endDate);
        return client.postJson("/datacube/getinterfacesummary", map, WxInterfaceSummaryResult.class);
    }

    @Override
    public WxInterfaceSummaryHourResult getInterfaceSummaryHour(String beginDate, String endDate) {
        Map<String, String> map = ImmutableMap.of("begin_date", beginDate, "end_date", endDate);
        return client.postJson("/datacube/getinterfacesummaryhour", map, WxInterfaceSummaryHourResult.class);
    }
}
