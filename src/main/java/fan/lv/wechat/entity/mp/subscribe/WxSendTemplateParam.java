package fan.lv.wechat.entity.mp.subscribe;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.official.message.template.base.WxDataValue;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Map;

/**
 * 发送模板内容
 *
 * @author lv_fan2008
 * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/subscribe-message/subscribeMessage.send.html" target="_blank">微信官方文档</a>
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxSendTemplateParam extends WxResult {
    /**
     * 接收者（用户）的 openid
     */
    @JsonProperty("touser")
    String toUser;

    /**
     * 所需下发的订阅模板id
     */
    @JsonProperty("template_id")
    String templateId;

    /**
     * 点击模板卡片后的跳转页面，仅限本小程序内的页面。支持带参数,（示例index?foo=bar）。该字段不填则模板无跳转。
     */
    String page;

    /**
     * 跳转小程序类型：developer为开发版；trial为体验版；formal为正式版；默认为正式版
     */
    @JsonProperty("miniprogram_state")
    String miniProgramState;

    /**
     * 进入小程序查看”的语言类型，支持zh_CN(简体中文)、en_US(英文)、zh_HK(繁体中文)、zh_TW(繁体中文)，默认为zh_CN
     */
    String lang;

    /**
     * 模板内容，格式形如 { "key1": { "value": any }, "key2": { "value": any } }
     */
    Map<String, WxDataValue> data;
}
