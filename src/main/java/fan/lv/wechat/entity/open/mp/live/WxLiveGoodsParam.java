package fan.lv.wechat.entity.open.mp.live;

import lombok.Data;

/**
 * 上传并提审需要直播的商品信息参数
 *
 * @author lv_fan2018
 */
@Data
public class WxLiveGoodsParam {

    /**
     * 商品信息
     */
    GoodsInfo goodsInfo;

    @Data
    public static class GoodsInfo{

        /**
         * 填入mediaID（mediaID获取后，三天内有效）；图片mediaID的获取，请参考以下文档：
         * https://developers.weixin.qq.com/doc/offiaccount/Asset_Management/New_temporary_materials.html；
         * 图片规则：图片尺寸最大300像素*300像素；
         */
        String coverImgUrl;

        /**
         * 商品名称，最长14个汉字，1个汉字相当于2个字符
         */
        String name;

        /**
         * 价格类型，1：一口价，2：价格区间，3：显示折扣价；
         * 1：一口价，只需要传入price，price2不传；
         * 2：价格区间，price字段为左边界，price2字段为右边界，price和price2必传。
         * 3：显示折扣价，price字段为原价，price2字段为现价， price和price2必传
         */
        Integer priceType;

        /**
         * 最多保留两位小数，单位元
         */
        Double price;

        /**
         * 最多保留两位小数，单位元，priceType为2或3时必填
         */
        Double price2;

        /**
         * 商品详情页的小程序路径，路径参数存在 url 的，该参数的值需要进行 encode 处理再填入
         */
        String url;
    }
}
