package fan.lv.wechat.entity.open.mp.qrcode;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 二维码规则列表
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxQrCodeRuleListResult extends WxResult {

    /**
     * 是否已经打开二维码跳转链接设置
     */
    @JsonProperty("qrcodejump_open")
    Integer qrcodeJumpOpen;

    /**
     * 本月还可发布的次数
     */
    @JsonProperty("qrcodejump_pub_quota")
    Integer qrcodeJumpPubQuota;

    /**
     * 二维码规则数量
     */
    @JsonProperty("list_size")
    Integer listSize;

    /**
     * 二维码规则列表
     */
    @JsonProperty("rule_list")
    List<QrCodeRule> ruleList;


    @Data
    public static class QrCodeRule {
        /**
         * 二维码规则
         */
        @JsonProperty("prefix")
        String prefix;

        /**
         * 是否独占符合二维码前缀匹配规则的所有子规 1 为不占用，2 为占用; 详见
         */
        @JsonProperty("permit_sub_rule")
        Integer permitSubRule;

        /**
         * 小程序功能页面
         */
        String path;

        /**
         * 测试范围
         * 1	开发版（配置只对开发者生效）
         * 2	体验版（配置对管理员、体验者生效)
         * 3	正式版（配置对开发者、管理员和体验者生效）
         */
        @JsonProperty("open_version")
        Integer openVersion;

        /**
         * 测试链接（选填）可填写不多于 5 个用于测试的二维码完整链接，此链接必须符合已填写的二维码规则。
         */
        @JsonProperty("debug_url")
        List<String> debugUrl;

        /**
         * 发布标志位，1 表示未发布，2 表示已发布
         */
        Integer state;

    }
}
