package fan.lv.wechat.api.official.statics.impl;

import fan.lv.wechat.util.SimpleMap;
import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.official.statics.PublisherAdStaticService;
import fan.lv.wechat.entity.official.statics.*;

import java.util.Map;

/**
 * @author lv_fan2008
 */
public class PublisherAdStaticServiceImpl implements PublisherAdStaticService {

    /**
     * 请求客户端
     */
    protected Client client;

    /**
     * @param client 请求客户端
     */
    public PublisherAdStaticServiceImpl(Client client) {
        this.client = client;
    }

    @Override
    public WxPublisherAdPosGeneralResult getPublisherAdPosGeneral(Integer page, Integer pageSize,
                                                                  String startDate, String endDate, String adSlot) {
        Map<String, String> queryMap = SimpleMap.of(
                "page", String.valueOf(page), "page_size", String.valueOf(pageSize),
                "start_date", startDate, "end_date", endDate);
        if (adSlot != null) {
            queryMap.put("ad_slot", adSlot);
        }
        return client.get("/publisher/stat?action=publisher_adpos_general", queryMap, WxPublisherAdPosGeneralResult.class);
    }

    @Override
    public WxPublisherCpsGeneralResult getPublisherCpsGeneral(Integer page, Integer pageSize, String startDate, String endDate) {
        Map<String, String> queryMap = SimpleMap.of(
                "page", String.valueOf(page), "page_size", String.valueOf(pageSize),
                "start_date", startDate, "end_date", endDate);
        return client.get("/publisher/stat?action=publisher_cps_general", queryMap, WxPublisherCpsGeneralResult.class);
    }

    @Override
    public WxPublisherSettlementResult getPublisherSettlement(Integer page, Integer pageSize, String startDate, String endDate) {
        Map<String, String> queryMap = SimpleMap.of(
                "page", String.valueOf(page), "page_size", String.valueOf(pageSize),
                "start_date", startDate, "end_date", endDate);
        return client.get("/publisher/stat?action=publisher_settlement", queryMap, WxPublisherSettlementResult.class);
    }
}
