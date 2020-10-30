package fan.lv.wechat.entity.open.mp.live;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 商品的信息与审核状态
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxGoodsAuditInfoResult extends WxResult {

    /**
     * 商品信息
     */
    List<Goods> goods;

    /**
     * 商品个数
     */
    Integer total;

    @Data
    public static class Goods {
        /**
         * 商品ID
         */
        @JsonProperty("goods_id")
        Integer goodsId;

        /**
         * 图片url
         */
        @JsonProperty("cover_img_url")
        String coverImgUrl;

        /**
         * 商品名称
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

        /**
         * 0：未审核，1：审核中，2:审核通过，3审核失败
         */
        @JsonProperty("audit_status")
        Integer auditStatus;


        /**
         * 1、2：表示是为 API 添加商品，否则是直播控制台添加的商品
         */
        @JsonProperty("third_party_tag")
        Integer thirdPartyTag;
    }
}
