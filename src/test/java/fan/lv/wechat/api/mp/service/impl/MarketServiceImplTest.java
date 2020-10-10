package fan.lv.wechat.api.mp.service.impl;

import fan.lv.wechat.api.mp.service.MarketService;
import fan.lv.wechat.api.mp.service.NearByPoiService;
import fan.lv.wechat.api.official.Util;
import fan.lv.wechat.entity.mp.market.WxInvokeServiceParam;
import fan.lv.wechat.entity.mp.market.WxInvokeServiceResult;
import fan.lv.wechat.util.JsonUtil;
import fan.lv.wechat.util.SignUtil;
import fan.lv.wechat.util.SimpleMap;
import junit.framework.TestCase;

/**
 * @author lv_fan2008
 */
public class MarketServiceImplTest extends TestCase {
    MarketService marketService;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        marketService = new MarketServiceImpl(Util.getMpClient());
    }

    public void testInvokeService() {
        WxInvokeServiceParam param = new WxInvokeServiceParam();
        param.setApi("OcrAllInOne");
        param.setService("wx79ac3de8be320b71");
        param.setClientMsgId(SignUtil.nonceStr());
        param.setData((
                SimpleMap.of("img_url", "http://mmbiz.qpic.cn/mmbiz_jpg/7UFjuNbYxibu66xSqsQqKcuoGBZM77HIyibdiczeWibdMeA2XMt5oibWVQMgDibriazJSOibLqZxcO6DVVcZMxDKgeAtbQ/0",
                        "data_type", 3, "ocr_type", 1)
        ));
        WxInvokeServiceResult result = marketService.invokeService(param);
        assertTrue(result.success() || result.getErrorCode() == 9301010);
    }
}