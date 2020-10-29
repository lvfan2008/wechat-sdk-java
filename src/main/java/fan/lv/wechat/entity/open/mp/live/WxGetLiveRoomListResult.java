package fan.lv.wechat.entity.open.mp.live;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 获取直播间列表结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxGetLiveRoomListResult extends WxResult {

    /**
     * 直播房间信息
     */
    @JsonProperty("room_info")
    List<RoomInfo> roomInfo;

    @Data
    public static class RoomInfo {
        /**
         * 直播间名称
         */
        String name;

        /**
         * 直播间ID
         */
        @JsonProperty("roomid")
        Integer roomId;

        /**
         * 直播间背景图链接
         */
        @JsonProperty("cover_img")
        String coverImg;

        /**
         * 直播间状态。101：直播中，102：未开始，103已结束，104禁播，105：暂停，106：异常，107：已过期
         */
        @JsonProperty("live_status")
        Integer liveStatus;

        /**
         * 直播间开始时间，列表按照start_time降序排列
         */
        @JsonProperty("start_time")
        String startTime;

        /**
         * 直播计划结束时间
         */
        @JsonProperty("end_time")
        String endTime;

        /**
         * 主播名
         */
        @JsonProperty("anchor_name")
        String anchorName;

        /**
         * 拉取房间总数
         */
        Goods goods;

        /**
         * 主播名
         */
        Integer total;
    }

    @Data
    public static class Goods {
        /**
         * 商品封面图链接
         */
        @JsonProperty("cover_img")
        String coverImg;

        /**
         * 商品小程序路径
         */
        String url;

        /**
         * 商品价格，单位元；
         */
        Double price;

        /**
         * 商品名称
         */
        String name;
    }
}
