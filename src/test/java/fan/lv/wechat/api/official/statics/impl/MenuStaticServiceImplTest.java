package fan.lv.wechat.api.official.statics.impl;

import fan.lv.wechat.api.official.Util;
import fan.lv.wechat.api.official.statics.ArticleStaticService;
import fan.lv.wechat.entity.official.statics.*;
import junit.framework.TestCase;

/**
 * @author lv_fan2008
 */
public class MenuStaticServiceImplTest extends TestCase {

    ArticleStaticService articleStaticService;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        articleStaticService = new ArticleStaticServiceImpl(Util.getClient());
    }

    public void testGetArticlesSummary() {
        WxArticlesSummaryResult result = articleStaticService.getArticlesSummary("2020-08-01", "2020-08-01");
        assertTrue(result.success());
    }

    public void testGetArticleTotal() {
        WxArticleTotalResult result = articleStaticService.getArticleTotal("2020-08-01", "2020-08-01");
        assertTrue(result.success());
    }

    public void testGetUserRead() {
        WxUserReadResult result = articleStaticService.getUserRead("2020-08-01", "2020-08-01");
        assertTrue(result.success());
    }

    public void testGetUserReadHour() {
        WxUserReadHourResult result = articleStaticService.getUserReadHour("2020-08-01", "2020-08-01");
        assertTrue(result.success());
    }

    public void testGetUserShare() {
        WxUserShareResult result = articleStaticService.getUserShare("2020-08-01", "2020-08-01");
        assertTrue(result.success());
    }

    public void testGetUserShareHour() {
        WxUserShareHourResult result = articleStaticService.getUserShareHour("2020-08-01", "2020-08-01");
        assertTrue(result.success());
    }
}