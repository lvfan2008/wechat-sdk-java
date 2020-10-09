package fan.lv.wechat.api.mp.service.impl;

import fan.lv.wechat.api.kernel.Client;
import fan.lv.wechat.api.mp.service.SearchService;
import fan.lv.wechat.entity.mp.search.WxImageSearchResult;
import fan.lv.wechat.entity.mp.search.WxPagesParam;
import fan.lv.wechat.entity.mp.search.WxSiteSearchResult;
import fan.lv.wechat.entity.result.WxResult;
import fan.lv.wechat.util.SimpleMap;

/**
 * @author lv_fan2008
 */
public class SearchServiceImpl implements SearchService {
    /**
     * 请求客户端
     */
    protected Client client;


    /**
     * @param client 请求客户端
     */
    public SearchServiceImpl(Client client) {
        this.client = client;
    }

    @Override
    public WxImageSearchResult imageSearch(String filePath) {
        return client.uploadFile("/wxa/imagesearch", SimpleMap.of(), SimpleMap.of("img", filePath), WxImageSearchResult.class);
    }

    @Override
    public WxSiteSearchResult siteSearch(String keyword, String nextPageInfo) {
        return client.postJson("/wxa/sitesearch", SimpleMap.of("keyword", keyword, "next_page_info", nextPageInfo),
                WxSiteSearchResult.class);
    }

    @Override
    public WxResult submitPages(WxPagesParam pages) {
        return client.postJson("/wxa/search/wxaapi_submitpages", pages, WxResult.class);
    }
}
