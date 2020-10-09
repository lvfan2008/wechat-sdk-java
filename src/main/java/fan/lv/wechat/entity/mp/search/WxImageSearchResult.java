package fan.lv.wechat.entity.mp.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 基于小程序的站内搜商品图片搜索结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxImageSearchResult extends WxResult {

    /**
     * 搜索结果列表
     */
    List<Item> items;

    @Data
    public static class Item {
        /**
         * 小程序商品页面标题
         */
        String title;

        /**
         * 小程序商品页面主图url
         */
        @JsonProperty("img_url")
        String imgUrl;

        /**
         * 小程序商品页面价格
         */
        String price;

        /**
         * 小程序商品页面地址
         */
        String path;
    }
}
