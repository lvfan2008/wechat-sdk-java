package fan.lv.wechat.entity.mp.market;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 调用服务平台提供的服务参数
 *
 * @author lv_fan2008
 * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/service-market/serviceMarket.invokeService.html" target="_blank">微信官方文档</a>
 */
@Data
public class WxInvokeServiceParam {
    /**
     * 服务 ID
     */
    String service;

    /**
     * 接口名
     */
    String api;

    /**
     * 服务提供方接口定义的 JSON 对象的数据
     */
    Object data;

    /**
     * 随机字符串 ID，调用方请求的唯一标识
     */
    @JsonProperty("client_msg_id")
    String clientMsgId;

}
