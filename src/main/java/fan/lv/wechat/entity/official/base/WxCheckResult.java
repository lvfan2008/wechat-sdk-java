package fan.lv.wechat.entity.official.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxCheckResult extends WxResult {

    /**
     * dns结果列表
     */
    List<DnsResult> dns;

    /**
     * ping结果列表
     */
    List<PingResult> ping;


    /**
     * Ping结果
     */
    @Data
    public static class PingResult {
        /**
         * ping的ip，执行命令为ping ip –c 1-w 1 -q
         */
        String ip;

        /**
         * ping的源头的运营商，由请求中的check_operator控制
         */
        @JsonProperty("from_operator")
        String fromOperator;

        /**
         * ping的丢包率，0%表示无丢包，100%表示全部丢包。因为目前仅发送一个ping包，因此取值仅有0%或者100%两种可能。
         */
        @JsonProperty("package_loss")
        String packageLoss;


        /**
         * ping的耗时，取ping结果的avg耗时。
         */
        String time;
    }

    /**
     * Dns结果
     */
    @Data
    public static class DnsResult {
        /**
         * 解析出来的ip
         */
        String ip;

        /**
         * ip对应的运营商
         */
        @JsonProperty("real_operator")
        String realOperator;
    }
}
