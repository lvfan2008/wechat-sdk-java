package fan.lv.wechat.entity.mp.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.official.message.template.WxTemplateMessageParam;
import fan.lv.wechat.entity.official.message.template.base.WxDataColorValue;
import fan.lv.wechat.entity.official.message.template.base.WxDataValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @author lv_fan2008
 */
@Data
public class WxUniformMessageParam {

    /**
     * 接收者openid
     */
    @JsonProperty("touser")
    String toUser;

    /**
     * 小程序模板消息相关的信息，可以参考小程序模板消息接口; 有此节点则优先发送小程序模板消息
     */
    @JsonProperty("weapp_template_msg")
    WeAppTemplateMsg weappTemplateMsg;

    /**
     * 公众号模板消息相关的信息，可以参考公众号模板消息接口；有此节点并且没有weapp_template_msg节点时，发送公众号模板消息
     */
    @JsonProperty("mp_template_msg")
    MpTemplateMsg mpTemplateMsg;

    @Data
    public static class WeAppTemplateMsg {
        /**
         * 小程序模板ID
         */
        @JsonProperty("template_id")
        String templateId;

        /**
         * 小程序页面路径
         */
        String page;

        /**
         * 小程序模板消息formid
         */
        @JsonProperty("form_id")
        String formId;

        /**
         * 模板data数据:
         * {"keyword1":{"value":"339208499"},"keyword2":{"value":"2015年01月05日12:30"},"keyword3":{"value":"腾讯微信总部"},
         * "keyword4":{"value":"广州市海珠区新港中路397号"}}
         */
        Map<String, WxDataValue> data;

        /**
         * 小程序模板放大关键词
         */
        String emphasisKeyword;

    }

    @Data
    public static class MpTemplateMsg {
        /**
         * 公众号appid，要求与小程序有绑定且同主体
         */
        @JsonProperty("appid")
        String appId;

        /**
         * 公众号模板id
         */
        @JsonProperty("template_id")
        String templateId;

        /**
         * 公众号模板消息所要跳转的url
         */
        String url;

        /**
         * 公众号模板消息所要跳转的小程序，小程序的必须与公众号具有绑定关系
         */
        @JsonProperty("miniprogram")
        WxTemplateMessageParam.MiniProgram miniProgram;

        /**
         * 公众号模板消息的数据:
         * <p>
         * {"first":{"value":"恭喜你购买成功！","color":"#173177"},"keyword1":{"value":"巧克力","color":"#173177"},
         * "keyword2":{"value":"39.8元","color":"#173177"},"keyword3":{"value":"2014年9月22日","color":"#173177"},
         * "remark":{"value":"欢迎再次购买！","color":"#173177"}}
         */
        Map<String, WxDataColorValue> data;

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
}


