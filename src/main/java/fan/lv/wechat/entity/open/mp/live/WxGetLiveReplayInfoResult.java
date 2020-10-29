package fan.lv.wechat.entity.open.mp.live;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 获取直播间回放结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxGetLiveReplayInfoResult extends WxResult {

    /**
     * 直播回放信息
     */
    @JsonProperty("live_replay")
    List<LiveReplay> liveReplay;

    /**
     * 回放视频片段个数
     */
    Integer total;

    @Data
    public static class LiveReplay {
        /**
         * 回放视频url过期时间
         */
        @JsonProperty("expire_time")
        String expireTime;

        /**
         * 回放视频创建时间
         */
        @JsonProperty("create_time")
        String createTime;

        /**
         * 直播间背景图链接
         */
        @JsonProperty("media_url")
        String mediaUrl;
    }
}
