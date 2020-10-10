package fan.lv.wechat.entity.mp.operation;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 实时日志查询结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxRealtimeLogSearchResult extends WxResult {

    /**
     * 总条数
     */
    Integer total;

    /**
     * 日志数据和日志条数总量
     */
    LogResult data;

    @Data
    public static class LogResult {
        /**
         * 日志数据列表
         */
        List<LogData> list;

        /**
         * 总条数
         */
        Integer total;
    }

    @Data
    public static class LogData {
        /**
         * 日志等级，是msg数组里面的所有level字段的或操作得到的结果。
         * 例如msg数组里有两条日志，Info（值为2）和Warn（值为4），则level值为6
         */
        Integer level;

        /**
         * 基础库版本
         */
        String libraryVersion;

        /**
         * 客户端版本
         */
        String clientVersion;

        /**
         * 用户微信号或者OpenId
         */
        String id;


        /**
         * 打日志的Unix时间戳
         */
        Integer timestamp;


        /**
         * 1 安卓 2 IOS
         */
        Integer platform;

        /**
         * 小程序页面路径，例如pages/index/index
         */
        String url;


        /**
         * 日志内容数组，log.info等的内容存在这里
         */
        List<String> msg;

        /**
         * 小程序启动的唯一ID，按TraceId查询会展示该次小程序启动过程的所有页面的日志。
         */
        String traceId;

        /**
         * 开发者通过setFileterMsg/addFilterMsg指定的filterMsg字段
         */
        String filterMsg;
    }
}
