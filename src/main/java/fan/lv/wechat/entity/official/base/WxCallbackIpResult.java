package fan.lv.wechat.entity.official.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 微信回调IP地址
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxCallbackIpResult extends WxResult {

    /**
     * 微信服务器IP地址列表
     */
    @JsonProperty("ip_list")
    List<String> ipList;
}
