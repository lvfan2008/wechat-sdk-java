package fan.lv.wechat.entity.official.customer.message;

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
public class TextKfMessage extends BaseKfMessage {
    /**
     * 发送类型
     */
    @JsonProperty("msgtype")
    String msgType = "text";


    /**
     * 文本
     */
    Text text;

    /**
     * 以某个客服帐号来发消息
     */
    @JsonProperty("customservice")
    CustomService customService;

    public TextKfMessage(String content) {
        this.text = new Text(content);
    }

    public TextKfMessage(String content, String kfAccount) {
        this.text = new Text(content);
        this.customService = new CustomService(kfAccount);
    }

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

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CustomService {
        /**
         * 客服帐号
         */
        @JsonProperty("kf_account")
        String kfAccount;
    }
}
