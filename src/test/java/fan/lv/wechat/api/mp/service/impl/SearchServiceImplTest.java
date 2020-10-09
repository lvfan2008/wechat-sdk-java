package fan.lv.wechat.api.mp.service.impl;

import fan.lv.wechat.api.mp.service.DataAnalysisService;
import fan.lv.wechat.api.mp.service.SearchService;
import fan.lv.wechat.api.official.Util;
import fan.lv.wechat.entity.mp.search.WxImageSearchResult;
import fan.lv.wechat.entity.mp.search.WxPagesParam;
import fan.lv.wechat.entity.mp.search.WxSiteSearchResult;
import fan.lv.wechat.entity.result.WxResult;
import junit.framework.TestCase;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author lv_fan2008
 */
public class SearchServiceImplTest extends TestCase {

    SearchService searchService;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        searchService = new SearchServiceImpl(Util.getMpClient());
    }
    public void testImageSearch() {
        WxImageSearchResult result = searchService.imageSearch(Util.getProperty("thumb.path"));
        assertTrue(result.success() || result.getErrorCode() == 48001);
    }

    public void testSiteSearch() {
        WxSiteSearchResult result = searchService.siteSearch("首页",null);
        assertTrue(result.success());
    }

    public void testSubmitPages() {
        WxResult result = searchService.submitPages(
                new WxPagesParam(Collections.singletonList(new WxPagesParam.Pages("pages/index/index", "page=0"))));
        assertTrue(result.success() );
    }
}