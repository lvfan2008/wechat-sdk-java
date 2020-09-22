package fan.lv.wechat.entity.message.template;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lv_fan2008
 */
@Data
public class WxSubscribeMessageParam {

    /**
     * 接收者openid
     */
    @JsonProperty("touser")
    String toUser;

    /**
     * 模板ID
     */
    @JsonProperty("template_id")
    String templateId;

    /**
     * 模板跳转链接（海外帐号没有跳转能力）
     */
    String url;

    /**
     * 订阅场景值
     */
    String scene;

    /**
     * 消息标题，15字以内
     */
    String title;

    /**
     * 跳小程序所需数据，不需跳小程序可不用传该数据
     */
    @JsonProperty("miniprogram")
    WxTemplateMessageParam.MiniProgram miniProgram;

    /**
     * 模板data数据:
     * 消息正文，value为消息内容文本（200字以内），没有固定格式，可用\n换行，
     * color为整段消息内容的字体颜色（目前仅支持整段消息为一种颜色）
     */
    DataContent data;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MiniProgram {
        /**
         * 所需跳转到的小程序appid（该小程序appid必须与发模板消息的公众号是绑定关联关系，暂不支持小游戏）
         */
        @JsonProperty("appid")
        String appId;

        /**
         * 所需跳转到小程序的具体页面路径，支持带参数,（示例index?foo=bar），要求该小程序已发布，暂不支持小游戏
         */
        @JsonProperty("pagepath")
        String pagePath;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DataContent {
        /**
         * 数据内容
         */
        DataValue content;
    }
}
