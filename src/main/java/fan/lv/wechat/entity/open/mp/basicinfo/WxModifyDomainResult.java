package fan.lv.wechat.entity.open.mp.basicinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import fan.lv.wechat.entity.result.WxResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 设置服务器域名结果
 *
 * @author lv_fan2008
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxModifyDomainResult extends WxResult {

    /**
     * request 合法域名
     */
    @JsonProperty("requestdomain")
    List<String> requestDomain;

    /**
     * socket 合法域名
     */
    @JsonProperty("wsrequestdomain")
    List<String> wsRequestDomain;

    /**
     * uploadFile 合法域名
     */
    @JsonProperty("uploaddomain")
    List<String> uploadDomain;

    /**
     * downloadFile 合法域名
     */
    @JsonProperty("downloaddomain")
    List<String> downloadDomain;

}
