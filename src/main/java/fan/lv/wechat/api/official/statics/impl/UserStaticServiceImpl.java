package fan.lv.wechat.api.official.statics.impl;

import com.google.common.collect.ImmutableMap;
import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.official.statics.UserStaticService;
import fan.lv.wechat.entity.official.statics.WxUserCumulateResult;
import fan.lv.wechat.entity.official.statics.WxUserSummaryResult;

import java.util.Map;

/**
 * @author lv_fan2008
 */
public class UserStaticServiceImpl implements UserStaticService {
    /**
     * 请求客户端
     */
    protected Client client;

    /**
     * @param client 请求客户端
     */
    public UserStaticServiceImpl(Client client) {
        this.client = client;
    }

    @Override
    public WxUserSummaryResult getUserSummary(String beginDate, String endDate) {
        Map<String, String> map = ImmutableMap.of("begin_date", beginDate, "end_date", endDate);
        return client.postJson("/datacube/getusersummary", (Object) map, WxUserSummaryResult.class);
    }

    @Override
    public WxUserCumulateResult getUserCumulateData(String beginDate, String endDate) {
        Map<String, String> map = ImmutableMap.of("begin_date", beginDate, "end_date", endDate);
        return client.postJson("/datacube/getusercumulate", (Object) map, WxUserCumulateResult.class);
    }
}
