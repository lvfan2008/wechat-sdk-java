package fan.lv.wechat.entity.open.official;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 公众号关联的小程序
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxMpLinkResult extends WxResult {

    /**
     * 关联小程序
     */
    @JsonProperty("wxopens")
    WxOpens wxopens;

    @Data
    public static class WxOpens {
        /**
         * 关联列表
         */
        List<Item> items;
    }

    @Data
    public static class Item {
        /**
         * 关联状态
         * 1：已关联；
         * 2：等待小程序管理员确认中；
         * 3：小程序管理员拒绝关联
         * 12：等到公众号管理员确认中；
         */
        Integer status;

        /**
         * 小程序 gh_id
         */
        String username;

        /**
         * 来源
         */
        String source;

        /**
         * 小程序名称
         */
        String nickname;

        /**
         * 是否在公众号管理页展示中
         */
        Integer selected;

        /**
         * 是否展示在附近的小程序中 0否 1是
         */
        @JsonProperty("nearby_display_status")
        Integer nearbyDisplayStatus;

        /**
         * 是否已经发布  0否 1是
         */
        Integer released;

        /**
         * 头像 url
         */
        @JsonProperty("headimg_url")
        String headimgUrl;


        /**
         * 微信认证及支付信息，0 表示未开通，1 表示开通
         */
        @JsonProperty("func_infos")
        List<FuncInfo> funcInfo;

        /**
         * 邮箱
         */
        String email;

        /**
         *
         */
        @JsonProperty("copy_verify_status")
        Integer copyVerifyStatus;
    }


    @Data
    public static class FuncInfo {
        /**
         * 权限集Id
         */
        Integer status;

        /**
         * 权限集Id
         */
        Integer id;

        /**
         * 权限集Id
         */
        String name;
    }
}
