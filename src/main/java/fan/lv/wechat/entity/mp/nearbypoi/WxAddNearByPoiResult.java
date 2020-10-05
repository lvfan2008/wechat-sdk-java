package fan.lv.wechat.entity.mp.nearbypoi;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 添加地点结构
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxAddNearByPoiResult extends WxResult {

    /**
     * 地点结果
     */
    NearByPoiResult data;

    @Data
    public static class NearByPoiResult {
        /**
         * 审核单 ID
         */
        @JsonProperty("audit_id")
        String auditId;

        /**
         * 附近地点 ID
         */
        @JsonProperty("poi_id")
        String poiId;

        /**
         * 经营资质证件号
         */
        @JsonProperty("related_credential")
        String relatedCredential;
    }
}
