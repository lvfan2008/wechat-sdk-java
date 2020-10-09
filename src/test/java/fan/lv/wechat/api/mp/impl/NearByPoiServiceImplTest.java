package fan.lv.wechat.api.mp.impl;

import fan.lv.wechat.api.mp.service.NearByPoiService;
import fan.lv.wechat.api.mp.service.impl.NearByPoiServiceImpl;
import fan.lv.wechat.api.official.Util;
import fan.lv.wechat.entity.mp.nearbypoi.WxAddNearByPoiParam;
import fan.lv.wechat.entity.mp.nearbypoi.WxAddNearByPoiResult;
import fan.lv.wechat.entity.mp.nearbypoi.WxNearByPoiListResult;
import fan.lv.wechat.entity.result.WxResult;
import fan.lv.wechat.util.JsonUtil;
import junit.framework.TestCase;

/**
 * @author lv_fan2008
 */
public class NearByPoiServiceImplTest extends TestCase {

    NearByPoiService nearByPoiService;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        nearByPoiService = new NearByPoiServiceImpl(Util.getMpClient());
    }

    public void testAll() {
        String json = "{\n" +
                "\"is_comm_nearby\": \"1\", \n" +
                "\"kf_info\": \"{\\\"open_kf\\\":true,\\\"kf_headimg\\\":\\\"http://mmbiz.qpic.cn/mmbiz_jpg/kKMgNtnEfQzDKpLXYhgo3W3Gndl34gITqmP914zSwhajIEJzUPpx40P7R8fRe1QmicneQMhFzpZNhSLjrvU1pIA/0?wx_fmt=jpeg\\\",\\\"kf_name\\\":\\\"Harden\\\"}\",\n" +
                "\"pic_list\": \"{\\\"list\\\":[\\\"http://mmbiz.qpic.cn/mmbiz_jpg/kKMgNtnEfQzDKpLXYhgo3W3Gndl34gITqmP914zSwhajIEJzUPpx40P7R8fRe1QmicneQMhFzpZNhSLjrvU1pIA/0?wx_fmt=jpeg\\\",\\\"http://mmbiz.qpic.cn/mmbiz_jpg/kKMgNtnEfQzDKpLXYhgo3W3Gndl34gITRneE5FS9uYruXGMmrtmhsBySwddEWUGOibG8Ze2NT5E3Dyt79I0htNg0?wx_fmt=jpeg\\\"]}\",\n" +
                "\"service_infos\": \"{\\\"service_infos\\\":[{\\\"id\\\":2,\\\"type\\\":1,\\\"name\\\":\\\"快递\\\",\\\"appid\\\":\\\"wx1373169e494e0c39\\\",\\\"path\\\":\\\"index\\\"},{\\\"id\\\":0,\\\"type\\\":2,\\\"name\\\":\\\"自定义\\\",\\\"appid\\\":\\\"wx1373169e494e0c39\\\",\\\"path\\\":\\\"index\\\"}]}\",\n" +
                "\"store_name\": \"羊村小马烧烤\",\n" +
                "\"contract_phone\": \"111111111\",\n" +
                "\"hour\": \"00:00-11:11\",\n" +
                "\"company_name\": \"深圳市腾讯计算机系统有限公司\",\n" +
                "\"credential\": \"156718193518281\",\n" +
                "\"address\": \"新疆维吾尔自治区克拉玛依市克拉玛依区碧水路15-1-8号(碧水云天广场)\",\n" +
                "\"qualification_list\": \"3LaLzqiTrQcD20DlX_o-OV1-nlYMu7sdVAL7SV2PrxVyjZFZZmB3O6LPGaYXlZWq\",\n" +
                "\"poi_id\": \"\"\n" +
                "}";
        WxAddNearByPoiParam poiParam = JsonUtil.parseJson(json, WxAddNearByPoiParam.class);
        WxAddNearByPoiResult result = nearByPoiService.addNearByPoi(poiParam);
        assertTrue(result.success() || 93019 == result.getErrorCode());

        WxNearByPoiListResult result2 = nearByPoiService.getList(1,10);
        assertTrue(result2.success()|| 93019 == result2.getErrorCode());

        WxResult result3 = nearByPoiService.setShowStatus("test",0);
        assertTrue(result3.success()|| -1 == result3.getErrorCode());

        WxResult result4 = nearByPoiService.delete("test");
        assertTrue(result4.success()|| -1 == result4.getErrorCode());
    }

}