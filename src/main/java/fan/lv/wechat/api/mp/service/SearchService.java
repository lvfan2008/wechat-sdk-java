package fan.lv.wechat.api.mp.service;

import fan.lv.wechat.entity.mp.search.WxImageSearchResult;
import fan.lv.wechat.entity.mp.search.WxPagesParam;
import fan.lv.wechat.entity.mp.search.WxSiteSearchResult;
import fan.lv.wechat.entity.result.WxResult;

/**
 * @author lv_fan2008
 */
public interface SearchService {
    /**
     * 提供基于小程序的站内搜商品图片搜索能力
     *
     * @param filePath 图片路径
     * @return 搜索结果
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/search/search.imageSearch.html" target="_blank">微信官方文档</a>
     */
    WxImageSearchResult imageSearch(String filePath);

    /**
     * 小程序内部搜索API提供针对页面的查询能力，小程序开发者输入搜索词后，将返回自身小程序和搜索词相关的页面。
     * 因此，利用该接口，开发者可以查看指定内容的页面被微信平台的收录情况；同时，该接口也可供开发者在小程序内应用，给小程序用户提供搜索能力
     *
     * @param keyword      关键词
     * @param nextPageInfo 请求下一页的参数，开发者无需理解。为空时查询的是第一页内容，如需查询下一页，把返回参数的next_page_info填充到这里即可
     * @return 搜索结果
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/search/search.siteSearch.html" target="_blank">微信官方文档</a>
     */
    WxSiteSearchResult siteSearch(String keyword, String nextPageInfo);

    /**
     * 小程序开发者可以通过本接口提交小程序页面url及参数信息(不要推送webview页面)，让微信可以更及时的收录到小程序的页面信息，
     * 开发者提交的页面信息将可能被用于小程序搜索结果展示。
     *
     * @param pages 小程序页面信息列表
     * @return 返回结果
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/search/search.submitPages.html" target="_blank">微信官方文档</a>
     */
    WxResult submitPages(WxPagesParam pages);
}
