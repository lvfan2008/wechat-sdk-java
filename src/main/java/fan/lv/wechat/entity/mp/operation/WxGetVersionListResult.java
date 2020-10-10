package fan.lv.wechat.entity.mp.operation;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 客户端版本列表
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxGetVersionListResult extends WxResult {

    /**
     * 客户端版本列表
     */
    @JsonProperty("cvlist")
    List<Version> list;

    @Data
    public static class Version {
        /**
         * 查询类型 1 代表客户端，2 代表服务直达
         */
        Integer type;

        /**
         * 版本列表
         */
        @JsonProperty("client_version_list")
        List<String> clientVersionList;
    }
}
