package fan.lv.wechat.entity.message.template;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 所属行业
 *
 * @author lv_fan2008
 * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Template_Message_Interface.html#0" target="_blank">微信官方说明文档</a>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WxIndustryParam {
    /**
     * 公众号模板消息所属行业编号
     */
    @JsonProperty("industry_id1")
    Integer industryId1;

    /**
     * 公众号模板消息所属行业编号
     */
    @JsonProperty("industry_id2")
    Integer industryId2;
}
