package fan.lv.wechat.entity.mp.operation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author lv_fan2008
 */
@Data
public class WxGetPerformanceParam {
    /**
     * 可选值 1（启动总耗时）， 2（下载耗时），3（初次渲染耗时）
     */
    @JsonProperty("cost_time_type")
    Integer costTimeType;

    /**
     * 查询开始时间
     */
    @JsonProperty("default_start_time")
    Integer defaultStartTime;

    /**
     * 查询结束时间
     */
    @JsonProperty("default_end_time")
    Integer defaultEndTime;

    /**
     * 系统平台，可选值 "@_all:"（全部），1（IOS）， 2（android）
     */
    String device;

    /**
     * 是否下载代码包，当 type 为 1 的时候才生效，可选值 "@_all:"（全部），1（是）， 2（否）
     */
    @JsonProperty("is_download_code")
    String isDownloadCode;

    /**
     * 访问来源，当 type 为 1 或者 2 的时候才生效，通过 getSceneList 接口获取
     */
    String scene;

    /**
     * 网络环境, 当 type 为 2 的时候才生效，可选值 "@_all:"，wifi, 4g, 3g, 2g
     */
    @JsonProperty("networktype")
    String networkType;
}
