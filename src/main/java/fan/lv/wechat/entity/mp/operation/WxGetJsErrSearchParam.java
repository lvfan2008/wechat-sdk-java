package fan.lv.wechat.entity.mp.operation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author lv_fan2008
 */
@Data
public class WxGetJsErrSearchParam {
    /**
     * 错误关键字
     */
    @JsonProperty("errmsg_keyword")
    String errmsgKeyword;

    /**
     * 查询类型，1 为客户端， 2为服务直达
     */
    Integer type;

    /**
     * 客户端版本，可以通过 getVersionList 接口拉取, 不传或者传空代表所有版本
     */
    @JsonProperty("client_version")
    String clientVersion;

    /**
     * 开始时间，时间戳
     */
    @JsonProperty("start_time")
    Integer startTime;

    /**
     * 结束时间
     */
    @JsonProperty("end_time")
    Integer endTime;

    /**
     * 分页起始值
     */
    Integer start;

    /**
     * 一次拉取最大值
     */
    Integer limit;

    /**
     * 场景描述
     */
    String sceneDesc;
}
