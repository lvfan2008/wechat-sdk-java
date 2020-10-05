package fan.lv.wechat.entity.mp.nearbypoi;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 地点列表
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxNearByPoiListResult extends WxResult {

    /**
     * 地点列表结果
     */
    NearByPoiListResult data;

    @Data
    public static class NearByPoiListResult {
        /**
         * 剩余可添加地点个数
         */
        @JsonProperty("left_apply_num")
        Integer leftApplyNum;

        /**
         * 最大可添加地点个数
         */
        @JsonProperty("max_apply_num")
        Integer maxApplyNum;

        /**
         * 地址列表的 JSON 格式字符串
         */
        String data;
    }


    /**
     * 地址列表，填充后，转为json，保存到data.data中
     */
    @Data
    public static class NearByPoiList {
        /**
         * 地址列表
         */
        @JsonProperty("poi_id")
        List<NearByPoi> poiList;
    }

    /**
     * 地点
     */
    @Data
    public static class NearByPoi {
        /**
         * 附近地点 ID
         */
        @JsonProperty("poi_id")
        String poiId;


        /**
         * 资质证件地址
         */
        @JsonProperty("qualification_address")
        String qualificationAddress;

        /**
         * 资质证件证件号
         */
        @JsonProperty("qualification_num")
        String qualificationNum;

        /**
         * 地点审核状态:  3 审核中  4 审核失败  5 审核通过
         */
        @JsonProperty("audit_status")
        Integer auditStatus;

        /**
         * 地点展示在附近状态： 0 未展示 1 展示中
         */
        @JsonProperty("display_status")
        Integer displayStatus;

        /**
         * 审核失败原因，audit_status=4 时返回
         */
        @JsonProperty("refuse_reason")
        String refuseReason;
    }
}
