package fan.lv.wechat.api.official.statics.impl;

import fan.lv.wechat.api.official.Util;
import fan.lv.wechat.api.official.statics.ArticleStaticService;
import fan.lv.wechat.api.official.statics.PublishAdStaticService;
import fan.lv.wechat.entity.official.statics.WxPublisherAdPosGeneralResult;
import fan.lv.wechat.entity.official.statics.WxPublisherCpsGeneralResult;
import fan.lv.wechat.entity.official.statics.WxPublisherSettlementResult;
import junit.framework.TestCase;

/**
 * @author lv_fan2008
 */
public class PublisherAdStaticServiceImplTest extends TestCase {

    PublishAdStaticService publishAdStaticService;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        publishAdStaticService = new PublisherAdStaticServiceImpl(Util.getClient());
    }

    public void testGetPublisherAdPosGeneral() {
        WxPublisherAdPosGeneralResult result = publishAdStaticService.getPublisherAdPosGeneral(1, 20, "2020-08-01", "2020-08-20", null);
        // api unauthorized
        assertEquals(48001, (int) result.getErrorCode());
    }

    public void testGetPublisherCpsGeneral() {
        WxPublisherCpsGeneralResult result = publishAdStaticService.getPublisherCpsGeneral(1, 20, "2020-08-01", "2020-08-20");
        // api unauthorized
        assertEquals(48001, (int) result.getErrorCode());
    }

    public void testGetPublisherSettlement() {
        WxPublisherSettlementResult result = publishAdStaticService.getPublisherSettlement(1, 20, "2020-08-01", "2020-08-20");
        // api unauthorized
        assertEquals(48001, (int) result.getErrorCode());
    }
}