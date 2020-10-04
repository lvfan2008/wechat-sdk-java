package fan.lv.wechat.entity.mp.message.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class TextWeAppMessage extends BaseWeAppMessage {
    /**
     * 发送类型
     */
    @JsonProperty("msgtype")
    String msgType = "text";

    public TextWeAppMessage(String content) {
        this.text = new Text(content);
    }

    /**
     * 文本
     */
    Text text;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Text {
        /**
         * 文本消息，发送文本消息时，支持插入跳小程序的文字链
         * 例子：<a href="http://www.qq.com" data-miniprogram-appid="appid" data-miniprogram-path="pages/index/index">点击跳小程序</a>
         */
        String content;
    }
}
