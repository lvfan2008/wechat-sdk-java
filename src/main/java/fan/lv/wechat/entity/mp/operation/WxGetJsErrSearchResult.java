package fan.lv.wechat.entity.mp.operation;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 错误查询结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxGetJsErrSearchResult extends WxResult {

    /**
     * 总条数
     */
    Integer total;


    /**
     * 错误列表
     */
    List<JsErrResult> results;

    @Data
    public static class JsErrResult {
        /**
         * 时间戳
         */
        Integer time;

        /**
         * 客户端版本
         */
        @JsonProperty("client_version")
        String clientVersion;

        /**
         * 应用版本
         */
        @JsonProperty("app_version")
        String appVersion;

        /**
         * 版本错误数量
         */
        @JsonProperty("version_error_cnt")
        Integer versionErrorCnt;

        /**
         * 总错误数量
         */
        @JsonProperty("total_error_cnt")
        Integer totalErrorCnt;


        /**
         * 错误描述
         */
        String errmsg;
    }
}
