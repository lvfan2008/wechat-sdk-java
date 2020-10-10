package fan.lv.wechat.entity.mp.operation;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 用户反馈列表
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxGetFeedbackResult extends WxResult {

    /**
     * 总条数
     */
    @JsonProperty("total_num")
    Integer totalNum;


    /**
     * 反馈列表
     */
    List<Feedback> list;

    @Data
    public static class Feedback {
        /**
         * 记录Id
         */
        @JsonProperty("record_id")
        String recordId;

        /**
         * 时间戳
         */
        @JsonProperty("create_time")
        Integer createTime;

        /**
         * 反馈内容
         */
        String content;

        /**
         * 反馈者手机号
         */
        String phone;

        /**
         * 反馈者OpenId
         */
        @JsonProperty("openid")
        String openId;

        /**
         * 反馈者昵称
         */
        String nickname;


        /**
         * 反馈者头像
         */
        @JsonProperty("head_url")
        String headUrl;


        /**
         * 反馈类型: 1 无法打开小程序, 2 小程序闪退, 3 卡顿, 4 黑屏白屏, 5 死机, 6 界面错位, 7 界面加载慢, 8 其他异常
         */
        Integer type;

        /**
         * 系统信息
         */
        String systemInfo;
    }
}
