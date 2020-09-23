package fan.lv.wechat.entity.message.template;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.message.template.base.WxDataValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @author lv_fan2008
 */
@Data
public class WxTemplateMessageParam {

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
     * 跳小程序所需数据，不需跳小程序可不用传该数据
     */
    @JsonProperty("miniprogram")
    MiniProgram miniProgram;

    /**
     * 模板data数据:
     * {"first":{"value":"恭喜你购买成功！","color":"#173177"},"keyword1":{"value":"巧克力","color":"#173177"},
     * "keyword2":{"value":"39.8元","color":"#173177"},"keyword3":{"value":"2014年9月22日","color":"#173177"},
     * "remark":{"value":"欢迎再次购买！","color":"#173177"}}
     */
    Map<String, WxDataValue> data;

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

}


