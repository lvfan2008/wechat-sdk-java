package fan.lv.wechat.entity.mp.nearbypoi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author lv_fan2008
 */
@Data
public class WxAddNearByPoiParam {
    /**
     * 必填,写死为"1"
     */
    @JsonProperty("is_comm_nearby")
    String isCommNearby = "1";

    /**
     * 门店图片，最多9张，最少1张，上传门店图片如门店外景、环境设施、商品服务等，图片将展示在微信客户端的门店页。
     * 图片链接通过文档https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1444738729中的《上传图文消息内的图片获取URL》接口获取。
     * 必填，文件格式为bmp、png、jpeg、jpg或gif，大小不超过5M pic_list是字符串，内容是一个json
     */
    @JsonProperty("pic_list")
    String picList;

    /**
     * 必服务标签列表 必填，需要填写
     * 1、 服务标签ID
     * 2、 服务类型tpye
     * 3、 服务名称name
     * 详细字段格式见下方《服务标签id编号、类型与服务名称表》
     * 4、 APPID
     * 5、 对应服务落地页的path路径：path路径页面要与对应的服务标签一致，例如选取外卖服务，path路径应该是小程序的外卖对应的那个页面，
     * path路径获取咨询开发或者到小程序管理后台-工具-生成小程序码页面获取
     * 6、新增服务描述desc：描述服务内容，例如满减、折扣等优惠信息或新品、爆品等商品信息，仅标准服务都可添加，10个字符以内。
     * service_infos是字符串，内容是一个json
     */
    @JsonProperty("service_infos")
    String serviceInfos;

    /**
     * 客服信息 选填，可自定义服务头像与昵称，具体填写字段见下方示例kf_info pic_list是字符串，内容是一个json
     */
    @JsonProperty("kf_info")
    String kfInfo;

    /**
     * 门店名字 必填，门店名称需按照所选地理位置自动拉取腾讯地图门店名称，不可修改，如需修改请重现选择地图地点或重新创建地点。
     */
    @JsonProperty("store_name")
    String storeName;

    /**
     * 营业时间，格式11:11-12:12 必填
     */
    String hour;

    /**
     * 地址 必填
     */
    String address;

    /**
     * 如果创建新的门店，poi_id字段为空 如果更新门店，poi_id参数则填对应门店的poi_id 选填
     */
    @JsonProperty("poi_id")
    String poiId;

    /**
     * 主体名字 必填
     */
    @JsonProperty("company_name")
    String companyName;

    /**
     * 门店电话 必填
     */
    @JsonProperty("contract_phone")
    String contractPhone;

    /**
     * 资质号 必填, 15位营业执照注册号或9位组织机构代码
     */
    String credential;

    /**
     * 证明材料 必填 如果company_name和该小程序主体不一致，需要填qualification_list，详细规则见附近的小程序使用指南-
     * 如何证明门店的经营主体跟公众号或小程序帐号主体相关http://kf.qq.com/faq/170401MbUnim17040122m2qY.html
     */
    @JsonProperty("qualification_list")
    String qualificationList;

    /**
     * 对应《在腾讯地图中搜索门店》中的sosomap_poi_uid字段 腾讯地图那边有些数据不一致，如果不填map_poi_id的话，小概率会提交失败！
     * 注：
     * poi_id与map_poi_id关系：
     * map_poi_id是腾讯地图对于poi的唯一标识
     * poi_id是门店进驻附近后的门店唯一标识
     */
    String mapPoiId;

    /**
     * 图片列表，填充后，转为json保存到picList字段
     */
    @Data
    public static class PicList {
        /**
         * 图片列表
         */
        List<String> list;
    }

    /**
     * 服务标签列表,填充后，转为json保存到serviceInfos字段
     */
    @Data
    public static class ServiceInfoList {
        /**
         * 服务标签列表
         */
        @JsonProperty("service_infos")
        List<ServiceInfo> serviceInfos;
    }

    /**
     * 客服信息,填充后，转为json保存到kfInfo字段
     */
    @Data
    public static class KfInfo {
        /**
         * 客服是否打开
         */
        @JsonProperty("open_kf")
        Boolean openKf;

        /**
         * 客服头像
         */
        @JsonProperty("kf_headimg")
        String kfHeadImg;

        /**
         * 客服名称
         */
        @JsonProperty("kf_name")
        String kfName;
    }

    @Data
    public static class ServiceInfo {
        /**
         * 服务标签
         */
        Integer id;

        /**
         * 服务类型
         */
        String type;

        /**
         * 服务名称
         */
        String name;

        /**
         * appId
         */
        @JsonProperty("appid")
        String appId;

        /**
         * 对应服务落地页的path路径：path路径页面要与对应的服务标签一致，例如选取外卖服务，
         * path路径应该是小程序的外卖对应的那个页面，path路径获取咨询开发或者到小程序管理后台-工具-生成小程序码页面获取
         */
        String path;

        /**
         * 新增服务描述desc：描述服务内容，例如满减、折扣等优惠信息或新品、爆品等商品信息，仅标准服务都可添加，10个字符以内。
         */
        String desc;
    }
}